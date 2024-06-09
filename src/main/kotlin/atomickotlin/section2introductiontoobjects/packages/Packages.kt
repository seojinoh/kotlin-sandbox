import kotlin.math.PI
import kotlin.math.cos

// as 키워드를 사용하여 이름 변경
import kotlin.math.PI as circleRatio
import kotlin.math.cos as cosine

// 패키지에 있는 모든 내용을 임포트
import kotlin.math.*

import pythagorean.RightTriangle

fun main() {
    println(PI)
    println(cos(PI))
    println(cos(2 * PI))

    println(circleRatio)
    println(cosine(circleRatio))
    println(cosine(2 * circleRatio))

    println(kotlin.math.PI)
    println(kotlin.math.cos(kotlin.math.PI))
    println(kotlin.math.cos(2 * kotlin.math.PI))

    println(E)
    println(E.roundToInt()) // Double을 Int로 타입 캐스팅 (반올림)
    println(E.toInt()) // Double을 Int로 타입 캐스팅 (버림)

    val rt = RightTriangle(3.0, 4.0)
    println(rt.hypotenuse())
    println(rt.area())
}