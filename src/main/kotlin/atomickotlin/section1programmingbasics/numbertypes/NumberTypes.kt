fun main() {
    // Int 타입 추론
    val million = 1_000_000
    println(million)

    // 정수 나눗셈에서 나머지를 처리하는 일반적인 방법은 버림이다.
    val truncation = 3 / 2
    println(truncation)

    // Double 등으로 타입 캐스팅하여 나머지를 보존할 수 있다.
    val fractional = 3.toDouble() / 2
    println(fractional)

    // Int는 -2^31과 +2^31 - 1 사이의 값을 저장할 수 있다.
    val i: Int = Int.MAX_VALUE
    println(i)
    println(i + i) // overflow

    // Long은 -2^63과 +2^63 - 1 사이의 값을 저장할 수 있다.
    val l: Long = Long.MAX_VALUE
    println(l)
    println(0L + i + i) // overflow 방지
}