fun main() {
    val n = 2

    if (n % 2 == 0)
        println("n is even!")
    else
        println("n is odd!")

    // if 문장 전체가 식이므로, 결과를 내놓을 수 있다.
    val isEven = if (n % 2 == 0) true else false

    println(isEven)
}