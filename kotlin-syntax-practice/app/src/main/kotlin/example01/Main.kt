/*
 * This source file was generated by the Gradle 'init' task
 */

package example01

import kotlin.math.*
import kotlin.io.println


// typealias 
typealias Username = String

// class 새성 기본
class Person(val name:String, val age:Int)

fun main() {
    println("hello world")

    val person = Person("june", 10)

    println("${person.name}, ${person.age}")

    val value = abs(10)
    println("value = ${value}")

    var str:String = "aBcDDed"

    str = str.lowercase()
    println(str)

    var userName:Username = "4990tj"
    println("userName = ${userName}")

    /// null 허용 여부
    var str1:String? = null
    println(str1)

    val string:String? = "35234fsdf"
    println(string)


    // 3항 연산가
    val a = 20
    val b = 15

    val c = if(a > b) true else false
    println(c)

    // null 체크일 떄 유용한 엘비스 연산자
    val a1:Int? = null

    val c1 = a1 ?: -1
    println("c1 = ${c1}")

    // 비교 원리
    // == 값 비교
    // === 참조 주소 비교

    // 자료형 검사
    val num:Any = "vasdf2efsdf"

    if(num is String) {
        println(num)
    }

    // as
    val dd:Any? = "aaaaaa"
    val ee = dd as? String
    println(ee)
}