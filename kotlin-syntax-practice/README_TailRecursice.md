꼬리재귀 함수
=========

일반적인 재귀 함수는 함수의 호출 단계가 깊어지면 스택오버플로우가 발생할 수 있다.

<u><b>꼬리 재귀를 사용하면 스택 오버플로를 방지 할 수 있다.</b></u>

### 일반적인 재귀 알로리즘
```kotlin
fun main() {
    val mnumber = 4
    val result:Long

    result = factorial(number)
    println(result)
}

fun factorial(n: Int): Long {
    return if (n == 1) n.toLong() else n * factorial(n - 1)
}
```

### 꼬리 재귀 함수 (tailrec)
```kotlin
fun main() {
    val mnumber = 4
    val result:Long

    result = factorial(number)
    println(result)
}

tailrec fun factorial(n: Int, run:Int = 1 ): Long {
    return if (n == 1) n.toLong() else factorial(n - 1, run * n)
}

// 꼬리 재귀는 결국 아래와 같이 해석 된다.
fun factorial(n:Int, run:Int = 1): Long {

    while(n >= 1)
    {
        n = n - 1
        run = run * n
    }

    return run
}
```

> tailrect 키워드가 붙은 함수의 특징<br>
> 자기 자신을 호출하는 구문이 마지막에 위치해야 한다.