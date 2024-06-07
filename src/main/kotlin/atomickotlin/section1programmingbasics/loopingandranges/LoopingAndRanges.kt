fun showRange(r: IntProgression) {
    for (i in r) {
        print(i)
    }
    print(" // $r")
    println()
}

fun main() {
    for (i in 0..3) {
        print(i)
    }
    println()

    for (c in 'a'..'z') {
        print(c)
    }
    println()

    val s = "abc"
    for (i in 0..s.lastIndex) {
        print(s[i] + 1)
    }
    println()

    for (ch in "Jnskhm ") {
        print(ch + 1)
    }
    println()

    // IntProgression은 Kotlin의 기본 타입으로, 입력한 범위를 표준적인 형태로 변환하기 때문에, String으로 표현된 결과는 다를 수 있다.
    showRange(1..5) // 12345 // 1..5
    showRange(0 until 5) // 01234 // 0..4
    showRange(5 downTo 1) // 54321 // 5 downTo 1 step 1
    showRange(0..9 step 2) // 02468 // 0..8 step 2
    showRange(0 until 10 step 3) // 0369 // 0..9 step 3
    showRange(9 downTo 2 step 3) // 963 // 9 downTo 3 step 3

    repeat(2) {
        println("Hello!")
    }
}