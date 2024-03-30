package example05

//조건문, 조건식
fun ifStatementAndExpression() {
    // 조건문
    val a = 12
    val b = 13
    
    var c = 0
    if( a > b) {
        c = a
    }
    else {
        c = b
    }

    println("c = $c")

    // 조건식
    val d = if(a > b) {
        println("a choose")
        a
    }
    else {
        println("b choose")
        b
    }

    println("d = $d")
}

// in 연산자
fun inOperation() {

    val value = 10

    if(value in 1..9) {
        println("value under 10")
    }
    else if(value in 10..20) {
        println("value 10 <= x <= 20")
    }

}

// when 연산자
fun whenOperation() {
    val value:Any = 10
    when(value) {
        1, 2 -> println("1 or 2")
        in 8..12 -> println("8 <= x <= 12")
        !in 0..4 -> println("0, 1, 2, 3, 4 is not")
        is String -> println("String")
        else -> println("아무것도 아니다.")
    }

    val a = 11
    val str = "Hi"

    // 다른 표현식
    when {
        a == 11 && str == "Hi" -> println("correct")
        a == 10 -> println("ok")
        str == "Hi" -> println("str is hi")
        else -> println("nothing")
    }
}

// for문
fun forOperation() {

    // 상행
    for(x in 1..10) {
        print("$x, ")
    }

    println()

    // 하행
    for(x in 10 downTo 1) {
        print("$x, ")
    }

    println()

    // 단계 출력
    for(x in 0..10 step 2) {
        print("$x, ")
    }
}

// for break
fun forBreakLabel() {

    // for 문과 라벨을 섞어서 사용하면
    // 바로 첫번쨰 for문 단계 중단을 할수 있다.
    first@ for (i in 1..5) {
        second@ for (j in 1..5) {
            if (j == 3) {
                break@first
            }

            println("i:$i, j:$j")
        }
        println("after for j")
    }
    println("after for i")
}

fun main() {

    //ifStatementAndExpression()
    //inOperation()

    //whenOperation()
    //forOperation()

    //forBreakLabel()

    codingPractice("1234")
}