
package example02

// 함수 영역
fun funcname(a:Int, b:Int) : Int {
    return a + b
}

fun sum(a:Int, b:Int):Int = a + b
fun sum2(a:Int, b:Int) = a + b

// 반환값이 없으면 Unit
fun print(str:String):Unit {
    println("str = ${str}")
}

// 기본 매개변수
fun defaultArg(x:Int, y:Int = 20):Unit {
    println("x = ${x}, y = ${y}")
}

fun defaultVarArg(vararg counts:String):Unit {
    
    println("counts length = ${counts.size}")

    for(count in counts) {
        println(count)
    }
}

fun main() {
    println("hello example02")

    var result = funcname(10, 20)
    println("funcname = ${result}")

    result = sum(10, 20)
    result = sum(a = 10, b = 20)
    println("sum = ${result}")

    print("gogogoog")

    defaultArg(30)

    defaultVarArg("aa", "bb", "cc")

    /*
    var array = Array<Int>(size = 10, init = {0})
    array[0] = 10

    for(val v in array) {
        print("${v}, ")
    }
    */
}