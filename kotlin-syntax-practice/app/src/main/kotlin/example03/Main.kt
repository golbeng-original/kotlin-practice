/*
Lambda에 대해서 코딩
*/

package example03

// 일단 함수문
fun sum(a:Int, b:Int):Int = a + b

// 1줄 람다 구문
val lambda = { x:Int, y:Int -> x + y }

// 2줄 람다 구문
val lambda2 = { x:Int, y:Int ->
    val temp = x + y

    temp * temp
}

// 람다 매개변수 한개 일때! 매개변수 생략 하고 싶을때?!?
val lambda3:(String) -> Unit = { println("single argument ${it}") }

// 고차 함수 (함수를 받아들이는 고차 함수)
// 람다식 자료형 표현을 잘 살펴 보자
fun highFunc(sum:(Int, Int)->Int, a:Int, b:Int) : Int {
    return sum(a, b)
}

fun oneParam(out:(Any)->String):Unit {
    val value = out("oneParam")

    println(value)
}

fun lastLambdaParam(a:Int, b:Int, sum:(Int, Int) -> Int) : Int {
    val result = sum(a, b)

    return result
}

fun main() {
    println("hello example03")

    var result = lambda(10, 30)
    println("lambda = ${result}")

    result = highFunc({x, y -> x + y}, 50, 100)
    println("highFunc = ${result}")

    result = lambda2(1, 1)
    println("lambda2 = ${result}")
    
    // 일반함수 넘겨 주기
    result = highFunc(::sum, 1, 2)
    println("highFunc with sum = ${result}")

    lambda3("oneParam")

    // 고차함수 표현 방법
    oneParam({a:Any -> "heyhey!! ${a}"})
    oneParam { a:Any -> "hihi!! ${a}" }
    oneParam { "ohohoh!! ${it}" }

    // 마지막 매개변수가 람다 일경우 표현 방법
    result = lastLambdaParam(10, 20, {x, y -> x + y})
    println("lastLambdaParam = ${result}")

    result = lastLambdaParam(10, 20) 
    {
        x, y -> x + y
    }

    println("lastLambdaParam2 = ${result}")

    val a = 10
    val b = 20
    for(i in a..b)
    {
        println(i)
    }
}