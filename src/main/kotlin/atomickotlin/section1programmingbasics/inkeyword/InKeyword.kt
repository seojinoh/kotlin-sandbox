fun isDigit(ch: Char) = ch in '0'..'9'

fun notDigit(ch: Char) = ch !in '0'..'9'

fun inFloatRange(n: Double) {
    val r = 1.0..10.0
    println("$n in $r? ${n in r}")
}

fun main() {
    val percent = 35
    println(percent in 1..100)

    // in 키워드는 이터레이션과 원소 여부 검사에 모두 사용된다.
    val values = 1..3
    for (v in values) {
        println("iteration $v")
    }

    val v = 2
    if (v in values) {
        println("$v is a member of $values")
    }

    println('t' in "kotlin")
    println('a' in "kotlin")

    println(isDigit('a'))
    println(isDigit('5'))
    println(notDigit('z'))

    inFloatRange(0.999999)
    inFloatRange(5.000001)
    inFloatRange(10.0)
    inFloatRange(10.000001)

    // Kotlin은 알파벳순으로 문자열을 비교한다.
    println("ab" in "aa".."az")
    println("ba" in "aa".."az")
}