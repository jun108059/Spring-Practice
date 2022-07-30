# 스프링 핵심 원리 - 기본편

> DI 컨테이너 정확하게 이해하기

**목표**

1. 좋은 객체지향설계를 설명할 수 있다.
2. 스프링에 적용된 객체지향 원리를 설명할 수 있다.
3. 스프링 컨테이너와 스프링 빈에 대해 설명할 수 있다.
4. 스프링의 의존관계 주입에 대해 설명할 수 있다.
5. 스프링 빈의 생명주기와 빈 스코프에 대해 설명할 수 있다.

## 프로젝트 Spec

- Java 11
- IDE : IntelliJ
- Project : Gradle Project
- Spring boot
- Packaging : Jar

## 객체지향설계 원칙 in Spring

### 1. OCP 지켜질까?

- Spirng에서 DB 변경할 때 OCP를 지키려면 어떻게 해야할까

### 2. DIP를 잘 지키고 있을까?

- 의존관계가 인터페이스 뿐아니라 구현까지 모두 의존하는 문제..

```java
// 예시
private final MemberRepository memberRepository = new MemoryMemberRepository();
```

할인 정책을 바꿀 때 클라이언트 코드를 바꾸지 않을 수 있을까?

> 클라이언트에 Interface 구현 객체를 대신 주입해주어야 함!

### 3. 관심사 분리를 어떻게 할까?

- `AppConfig` 라는 구현 객체 생성 설정 정보를 담은 Config 클래스 생성
- 객체를 생성/연결하는 역할 vs 실행하는 역할 명확히 분리
- 클라이언트에 의존관계를 외부에서 주입한다고 하여 DI(Dependency Injection)으로 부름 

> 이제 DIP를 잘 지키게 된다.

**전체 구조는 Config에서 볼 수 없을까?**

- AppConfig 클래스의 메소드명 + 리턴타입 + 파라미터로 유추 가능

## 스프링 컨테이너 원리(ApplicationContext)

### 1. ApplicationContext : 스프링 컨테이너

- 기존에는 개발자가 AppConfig 를 사용해서 직접 객체를 생성하고 DI를 했지만, 이제부터는 스프링 컨테이너를 통해서 사용한다.
- 스프링 컨테이너는 `@Configuration` 이 붙은 AppConfig 를 설정(구성) 정보로 사용한다.
  여기서 `@Bean` 이라 적힌 메서드를 모두 호출해서 반환된 객체를 **스프링 컨테이너에 등록**한다. 이렇게 **스프링 컨테이너에 등록된 객체를 스프링 빈**이라 한다.

### 2. Bean 등록과 조회, 설정

- getBean() 메서드로 조회 가능
- BeanDefinition 설정으로 다양한 형식 지원


