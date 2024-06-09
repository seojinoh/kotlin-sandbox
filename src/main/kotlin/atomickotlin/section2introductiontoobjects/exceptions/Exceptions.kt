import atomictest.*
import java.lang.IllegalArgumentException

fun averageIncome(income: Int, months: Int) =
    // '개월 수는 양의 정수만 됩니다'라고 쓰는 게 '주어진 기간 동안의 평균 수입: null'보다 더 낫다.
    if (months == 0) {
        throw IllegalArgumentException("Months can't be zero")
    } else {
        income / months
    }

fun main() {
    // val i = "1$".toInt() // 예외
    capture {
        "1$".toInt()
    } eq "NumberFormatException: " +
            """For input string: "1$""""
    "1$".toIntOrNull() eq null

    averageIncome(3300, 3) eq 1100
    capture {
        averageIncome(5000, 0)
    } eq "IllegalArgumentException: " +
            "Months can't be zero"
}