Kotlin 중요한 사항
================

## 코틀린의 함수 종류
1. 일반 함수
2. 람다식 함수
3. 익명 함수
4. 인라인 함수
5. 확장 함수
6. 중위 함수 (사용할 일이 있을까? 닫힌 연산 객체 정의 할때 사용할 수도?)

### 일반 함수
```kotlin
fun foo(a:Int, b:Int):Int {}
```

### 람다식 함수

> 람다식에서 return 사용 방법<br>
> return에 라벨을 표기를 해야만 return을 사용할 수 있다. <br>
> return@라벨 같은 형식이다.

```kotlin
val foo:(Int, Int) -> Int = { x, y -> x + y}
```

아래와 같이 @라벨을 붙여줘야 `println("end of retFunc")` 구문까지 실행 할 수 있다.
```kotlin
fun inlineLambda(a:Int, b:Int, out:(Int, Int) -> Int) {
    out(a, b)
}

fun retFunc() {
    println("start of retFunc")
    inlineLambda(13, 3) {
        val result = a+b
        if(result > 10) return@inlineLambda
        println("result $result")
    }
    
    println("end of retFunc")
}
```

### 익명함수
람다식과 매우 유사하다

*익명함수를 사용하는 이유*<br>
람다식에서는 `return`, `break`, `continue` 처럼 제어문을 사용하기 어렵기 때문이다.

```kotlin
val foo(Int,Int) -> Int = fun(x:Int, y:Int):Int = x + y
```

### 인라인 함수
인라인 함수는 이함수가 호출되는 곳에 함수 본문의 내용을 모두 복사해 넣어 함수의 분기 없이

처리되기 때문에 코드의 성능을 높일 수 있다.

#### 인라인 함수 제한하기

```kotlin
inline fun sub(out1: () -> Unit, noinline out2: () -> Unit) {}
```

noinline이 없다면 out1과 같이 본문에 람다식 함수 내용이 복사해 들어가게 된다.<br>
(보통 고차함수에는 람다식이 들어가는 듯하다.)

noinline을 붙여주면 복사해 들어가지 않고 분기 함수 호출로 본무에 들어간다.

### crossinline (비지역 반환 금지)

비지역 반환 금지하기 라는 내용으로 아래와 같이 inline 함수를 사용하게 되면 문제가 된다.
```kotlin
inline fun shortFun(a:Int, out:(Int) -> Unit) -> Unit {
    println("Before Calling out()")
    out(a)
    println("Ater Calling out()")
}

fun main() {
    shortFun(3) { 
        println("First call: $it")
        return
    }
}

// 역컴파일 상태 예상
// 중간에 return이 들어가게 되어 예상하지 않은 문제가 발생한다.
fun main() {
    println("Before Calling out()")
    
    println("First call: 3")
    return
    
    println("Ater Calling out()")
}
```

crossinline 키워드 사용
```kotlin
inline fun shortFun(a:Int, crossinline out:(Int) -> Unit) -> Unit {
    println("Before Calling out()")
    out(a)
    println("Ater Calling out()")
}

fun main() {
    shortFun(3) { 
        println("First call: $it")
        return // 이 부분에서 컴파일 오류를 발생 시킨다.
    }
}
```

### 확장 함수

c#의 확장 함수와 가튼 역할

```kotlin
fun main() {
    val source = "Hello World!"
    val target = "Kotlin"

    println(source.getLongString(target))
}

fun String.getLongString(target:String):String {
    if(this.length > target.length) {
        return this
    }

    return target
}
```

### 중위 함수
```kotlin
fun main() {
    val multi = 3 multiply 10
    println("multi: $multi")
}

infix fun Int.multifly(x: Int) : Int {
    return this * x
}
```