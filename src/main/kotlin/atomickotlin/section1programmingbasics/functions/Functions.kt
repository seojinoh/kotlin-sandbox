// 함수의 이름, 파라미터, 반환 타입을 합쳐서, 함수 시그니처라고 부른다.
fun multiplyByTwo(x: Int): Int {
    return x * 2
}

// 의미 있는 결과를 제공하지 않는 함수의 반환 타입은 Unit이며, 생략 가능하다.
fun sayHello() {
    println("Hello!")
}

fun sayGoodbye(): Unit {
    println("Goodbye!")
}

fun main() {
    val n: Int = multiplyByTwo(1)
    println(n)

    sayHello()
    sayGoodbye()
}