# 14. @Configuration과 싱글톤 (ByteCode)

- `@Configuration` 은 싱글톤을 위한 설정이다.
- 이상한 점이 있다! AppConfig 에서 Bean 등록 Flow를 살펴보자.

```java
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
		// 아래 생략
}
```

1. @Bean memberService → new MemoryMemberRepository()
2. @Bean orderService → new MemoryMemberRepository()

> 이렇게 호출되면 결국 Repository 를 두번 생성하는데 싱글톤이 깨지는 것 아닐까?

## 1. 가설 검증 (Test 코드)

```java
@Test
void configurationTest() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
    OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

    MemberRepository memberRepository1 = memberService.getMemberRepository();
    MemberRepository memberRepository2 = orderService.getMemberRepository();

    // 값 3개가 같다
    Assertions.assertSame(memberRepository1, memberRepository2);
    Assertions.assertSame(memberRepository1, memberRepository);

}
```

AppConfig 호출 flow 와 다르게 새로운 객체 2개가 생성되지 않고 같은 객체를 공유하고 있다.

## 2. 원인 분석

- `@Configuration` 에너테이션이 ByteCode를 조작한다고 한다.

등록된 AppConfig Bean을 꺼내서 Class를 조회해보자.

```java
@Test
void configurationDeep() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    AppConfig bean = ac.getBean(AppConfig.class);

    System.out.println("bean = " + bean.getClass());
    // 결과: bean = class practice.basic.AppConfig$$EnhancerBySpringCGLIB$$84e8d0a8
}
```

> 클래스의 기대 값은 practice.basic.AppCofing 인데, CGLIB 이 붙은 클래스가 등록됐다.
>

### EnhancerBySpringCGLIB

- 스프링이 Bean을 등록하는 과정에서 `CGLIB` 이라는 ByteCode 조작 라이브러리를 사용한다.

![image](https://user-images.githubusercontent.com/42997924/181345738-5bf39d3f-4bd8-4c98-8077-2443d4b2ef72.png)

- CGLIB을 통해서 AppConfig 클래스를 상속받는 임의의 클래스를 만들고 Bean으로 등록한다.

> 이 CGLIB을 통해 등록된 Bean이 싱글톤을 보장해준다!


아마 아래와 같은 로직으로 싱글톤을 보장해줄 것 같다.

```java
// 추측하는 sudo 코드
@Bean
public MemberRepository memberRepository() {
    if (memberRepository가 이미 스프링 컨테이너에 등록되어 있으면?) {
        return 스프링 컨테이너에서 찾아서 반환;
    } else { // 스프링 컨테이너에 없으면?
        기존 로직을 호출해서 MemberRepository 생성 후 스프링 컨테이너에 등록
        return 반환;
    }
}
```

- @Bean 이 붙은 메서드마다 기존 스프링 빈 존재 유무를 파악해서 등록/반환하는 `코드가 동적으로 생성`된다.

> 💡참고    
> AppConfig@CGLIB 는 AppConfig의 자식 타입으므로, AppConfig 타입으로 조회 가능

## 3. @Configuration 없는 경우

`@Configuration` 없이 `@Bean` 만 적용해도 될까?

- 스프링 Bean으로 등록은 되지만, CGLIB 기술이 적용되지 않는다.

```java
@Test
void configurationDeep() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    AppConfig bean = ac.getBean(AppConfig.class);

    System.out.println("bean = " + bean.getClass());
    // 결과: bean = class practice.basic.AppConfig
}
```

AppConfig 그대로 조회가 되고, 기존 Bean 등록 여부와 상관 없이 새로운 객체가 생성되어 싱글톤이 보장되지 않는다.

> 스프링 컨테이너가 Bean을 관리해주지 않는다!

이후에 의존관계 주입을 통해 @Configuration 없이 스프링 컨테이너에 등록시킬 수 있음.

하지만, 스프링 설정 정보에는 항상 @Configuration 에너테이션을 넣어준다고 생각하는게 좋다!