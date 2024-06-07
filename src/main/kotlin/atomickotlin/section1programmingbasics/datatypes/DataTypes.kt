fun main() {
    // 기본 데이터 타입 일부
    val whole: Int = 11
    val fractional: Double = 1.1
    val trueOrFalse: Boolean = true
    val words: String = "Hello, world!"
    val character: Char = 'a'
    val lines: String =
        """
            Hello
            ,
            world!
        """.trimIndent()

    println(whole)
    println(fractional)
    println(trueOrFalse)
    println(words)
    println(character)
    println(lines)

    // Double 타입 추론
    val n = 11 + 1.1

    println(n)
}