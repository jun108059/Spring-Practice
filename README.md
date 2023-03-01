# Spring Practice

Spring 관련 강의, 서적 정리

## 강의

| No  | 강의 제목                                                                                      |
|:---:|:-------------------------------------------------------------------------------------------|
|  1  | [스프링 핵심 원리 - 기본편](https://github.com/jun108059/spring-practice/tree/main/basic)            |
|  2  | 모든 개발자를 위한 HTTP 웹 기본 지식                                                                    |
|  3  | [스프링 MVC 1편 - 백엔드 웹 개발 핵심 기술](https://github.com/jun108059/spring-practice/tree/main/mvc1) |
|  4  | [스프링 MVC 2편 - 백엔드 웹 개발 활용 기술](https://github.com/jun108059/spring-practice/tree/main/mvc2) |
|  5  | 스프링 DB 1편 - 데이터 접근 핵심 원리                                                                   |
|  6  | 스프링 DB 2편 - 데이터 접근 활용 기술                                                                   |
|  7  | 스프링 핵심 원리 - 고급편                                                                            |
|  8  | [실전! Querydsl](https://github.com/jun108059/spring-practice/tree/main/querydsl)            |

## 서적

| No  | 강의 제목                                                                               |
|:---:|:------------------------------------------------------------------------------------|
|  1  | [스프링 인 액션](https://github.com/jun108059/spring-practice/tree/main/spring-in-action) |

## Multi-Module 생성

> Project → New → Module

|        항목         |           선택           |
|:-----------------:|:----------------------:|
|     Language      |          Java          |
|       Type        |     Gradle-Groovy      |
|       Group       |        practice        |
|   Package.name    | practice.{projectName} |
|        JDK        |        java 11         |
|     Packaging     |          Jar           |
| SpringBootVersion |         2.7.x          |

### SubModule 등록하기

1. root → `settings.gradle`에 프로젝트 추가
2. sub-module → `settings.gradle` 삭제
3. root → `build.gradle` project 추가
4. sub-module → `build.gradle` 공통항목 제거
5. Reload All Gradle Projects