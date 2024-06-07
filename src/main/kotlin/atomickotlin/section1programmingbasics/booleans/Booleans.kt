fun main() {
    // &&: 논리곱(and) 연산자
    println(true && true) // true
    println(true && false) // false
    println(false && false) // false

    // ||: 논리합(or) 연산자
    println(true || true) // true
    println(true || false) // true
    println(false || false) // false

    // 괄호가 없는 경우 &&가 ||보다 먼저 평가된다.
    println(true || true && false) // true
    println((true || true) && false) // false
    println(true || (true && false)) // true
}