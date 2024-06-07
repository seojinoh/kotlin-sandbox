fun main() {
    val n = 2

    println("n is $n")
    println("n is ${if (n % 2 == 0) "even" else "odd"}")
    println("\"n\" is $n")
    println(""""n" is $n""")
}