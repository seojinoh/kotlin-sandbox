// package 키워드를 사용하여 패키지 생성
// 주석이 아닌 코드의 가장 앞 부분에 위치해야 한다.
// 관례적으로 소문자만 사용하며, Java와 달리 파일 이름과 달라도 된다.
// 패키지 이름은 디렉터리 경로와 똑같이 하는 게 좋은 스타일로 여겨진다.
package pythagorean
import kotlin.math.sqrt

class RightTriangle(
    val a: Double,
    val b: Double
) {
    fun hypotenuse() = sqrt(a * a + b * b)
    fun area() = a * b / 2
}