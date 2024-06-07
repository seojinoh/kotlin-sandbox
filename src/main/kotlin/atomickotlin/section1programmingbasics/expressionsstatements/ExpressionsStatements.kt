fun unitFun() = Unit
fun main() {
    // Statement: 문은 효과를 발생시키지만 결과를 내놓지 않는다.
    // - A statement changes state (문은 상태를 변경한다).
    // Expression: 식은 항상 결과를 만들어낸다.
    // - An expression expresses (식은 값을 짜낸다).

    // val f = for (i in 1..10) {} // 오류 메시지: For is not an expression, and only expressions are allowed here

    println(unitFun())
    val u1: Unit = println(10)
    println(u1)
    val u2 = println(10) // Unit 타입 추론
    println(u2)

    val result1 = if (1 > 2) true else false
    val result2 = if (1 > 2) {
        val a = 10
        a + 1
    } else false
    val result3 = if ('x' < 'y') {
        println("x < y")
    } else {
        println("x > y")
    }

    // x < y가 먼저 출력되는 이유는, result3이 정의될 때 if 식을 평가하기 때문이다.
    println(result1)
    println(result2)
    println(result3)

    var i = 10
    println(i++)
    println(i)

    var j = 20
    println(++j)
    println(j)
}