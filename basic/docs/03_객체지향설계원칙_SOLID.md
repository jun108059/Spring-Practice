# 3. 좋은 객체지향 설계의 5가지 원칙(SOLID)

## SOLID

*클린코드로 유명한 로버트 마틴이 좋은 객체 지향 설계의 5가지 원칙을 정리*

- SRP : 단일 책임 원칙(Single Responsibility Principle)
- OCP : 개방-폐쇄 원칙(Open/Closed Principle)
- LSP : 리스코프 치환 원칙(Liskov Substitution Principle)
- ISP : 인터페이스 분리 원칙(Interface Segregation Principle)
- DIP : 의존관계 역전 원칙(Dependency Inversion Principle)

### SRP 단일 책임 원칙

*Single Responsibility Principle*

- 한 클래스는 하나의 책임만 가져야 한다.
- 하나의 책임이라는 것은 모호
  - 문맥과 상황에 따라 다르고, 책임이 클수 있고 작을 수 있다.
- **중요한 기준 : 변경**
  - 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것

    → Ex) UI 변경, 객체의 생성과 사용을 분리

<aside>
💡 변경이 있을 때 하나의 클래스만 변경하면 되도록 설계! → 쉽지는 않다.

</aside>

### OCP 개방-폐쇄 원칙 ⭐️

*Open/Closed Principle*

- 소프트웨어 요소는 **확장에는 열려**있으나 **변경에는 닫혀**있어야한다.

<aside>
💡 코드를 변경하지 않고 기능을 확장한다?
→ 다형성을 활용하면 됨
→ 인터페이스를 구현한 새로운 클래스는 코드 변경이 아님!

</aside>

- 다형성을 사용해도 OCP를 못지키는 문제가 발생하는 부분

  ![image](https://user-images.githubusercontent.com/42997924/180614111-8a43e094-c577-4bbc-8e1a-9ae45cf95739.png)

**어떻게 해결할까?**

<aside>
💡 **객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요
→ 스프링이 해준다!! (스프링 컨테이너)**

</aside>

*이 원칙을 지키려고 DI(컨테이너), IoC 등이 필요하다.*

*→ 지금은 기존 방식이 어떤 문제가 있는지 먼저 이해하면 됨*

### LSP 리스코프 치환 원칙

*Liskov Substitution Principle*

- 프로그램의 객체는 **프로그램의 정확성을 깨뜨리지 않으면서** 하위 타입의 인스턴스로 바꿀 수 있어야 한다.

  <aside>
    💡 간단하게 설명하면 인터페이스 규약을 잘 따르는 것

  </aside>
- 다형성에서 하위 클래스는 인터페이스 규약을 다 지켜야 한다는 것.

  → 다형성을 지원하기 위한 원칙

  → 인터페이스를 구현한 구현체를 믿고 사용할 수 있음!

### ISP 인터페이스 분리 원칙

*Interface Segregation Principle*

<aside>
💡 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 낫다.

</aside>

인터페이스는 기능 별로 분리를 잘 하는게 좋다!

### DIP 의존관계 역전 원칙 ⭐️

*Dependency Inversion Principle*

<aside>
💡 추상화에 의존! 구체화에 의존하면 안된다.

</aside>

- 구현 클래스에 의존하지 말고, 역할을 알아야한다!

![image](https://user-images.githubusercontent.com/42997924/180614052-29f332e8-7807-424f-ae74-5e58b9c3a82a.png)

인터페이스에 의존해야한다.

---

## 정리

1. 객체지향의 핵심은 다형성!
2. 다형성만으로는 쉽게 부품을 갈아 끼우듯이 개발할 수 없다.
3. 다형성만으로는 구현 객체를 변경할 때 클라이언트 코드도 함께 변경된다.
4. **다형성만으로는 OCP, DIP를 지킬 수 없다.**
5. 뭔가 더 필요하다!
