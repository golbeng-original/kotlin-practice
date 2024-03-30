조건문 및 제어문
============

### in 연산자와 범위 연산자
```
변수 이름 in 시작값..마지막값
```

### when 문
when문은 switch-case 문 대용으로 아래와 같이 사용 할 수 있다.
```kotlin
when(인자) {
    값 혹은 표현식 -> 수행할 문장
    일치하는 범위 -> 수행할 문장
    else -> 수행할 문장
}

when {
    a is Int -> println("a is Int")
    a == 1 && b == 2 -> println("a, b correct")
    a in 10..100 -> println("10 <= x <= 100 correct")
}
```

### for 문
kotlin에서는 ;을 표현식을 사용하지 않는다.

아래와 같은 구문은 사용할 수 없다.
```
for(var i = 0 ; i < 10 ; i++) {}
```

야래와 같은 방법으로 반복문을 써야 한다.
```
for(요소 in 컬렉션 또는 범위) {}
```

하행 요소 건너뛰기는 조금 특이하다.
```kotlin
// 상행
for(x in 1..10) {}

// 하행
for(x in 10 downTo 1) {}

// 건너뛰기
for(x in 1..10 step 2) {}
for(x in 10 downTo 1 step 2) {} 
```
