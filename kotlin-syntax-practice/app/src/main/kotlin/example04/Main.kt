package example04

// 함수위 범위

var global = 10

fun main() {

    val local1 = 20
    val local2 = 30

    fun nestedFunc() {
        global += 1

        val local1 = 50
        println("nested local1: ${local1}")
        println("nested local2: ${local2}")
        println("nested global: ${global}")
    }

    nestedFunc()

    println("main local1: ${local1}")
    println("main local2: ${local2}")
    println("main local3: ${global}")
}