# JavaToKotin
> java를 사용하다가 Kotlin으로 개발하면서 느꼈던, 현실적인 편리함과 불편함을 정리

1. 지극히 경험적이고 편리함만을 기준으로 정리한 내용.
2. 이론보다는 실제코딩에서 경험했던 편리함과 불편함을 정리

#### 장점
- findViewByID
- 람다식에 의한 코딩량 감소
- 변수의 형변환
- 프로퍼티 (Set / Get 구별)
- let, apply, run 함수
- 고차원 함수(Interface까지 만들필요없을 때)
- collection과 함수형 코딩스타일(map, filter)
- Singleton 처리
- 초기화시점(lazy)
- nullcheck 스타일
- data class


#### 단점(기존습관에 의한 불편함)
- Nullable 변수
null 채크(immutable, mutable 에러)를 반드시해주거나, 데이터형을
nullable로 선언하고 처리해주어야 한다.

- Java에서 가져온 것(데이터형, 변수..)의 형변환
변수나 데이터형을 ?형으로 선언하고 !!로 지정해주어야 java와 호환하기 쉽다
