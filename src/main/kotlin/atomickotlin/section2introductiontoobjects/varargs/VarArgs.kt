import atomictest.*

fun v1(s: String, vararg i: Int) {}

fun v2(vararg i: Int, s: String) {}

fun first(vararg numbers: Int): String {
    var result = ""
    for (i in numbers) {
        result += "[$i]"
    }
    return result
}

// 스프레드 연산자(*)는 Array에만 사용할 수 있으므로, List인 경우 우선 Array로 변환해야 한다.
fun second(vararg numbers: Int) = first(*numbers)

// 명령줄 인자를 사용하는 경우, String 파라미터를 원하는 타입으로 변환 후 사용한다.
fun main(args: Array<String>) {
    // 가변 인자 목록은 최대 하나만 있어야 하며, 일반적으로 마지막 파라미터로 선언한다.
    // vararg 키워드로 선언할 수 있으며, Array로 취급된다.
    v1("abc", 1, 2, 3)
    v2(1, 2, 3, s = "abc")

    second(1, 2, 3) eq "[1][2][3]"
}