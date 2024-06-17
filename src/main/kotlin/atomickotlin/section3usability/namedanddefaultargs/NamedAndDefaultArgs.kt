import atomictest.*

// named 인자
fun color(red: Int, green: Int, blue: Int) = "($red, $green, $blue)"

// default 인자
fun color2(
    red: Int = 0,
    green: Int = 0,
    blue: Int = 0,
) = "($red, $green, $blue)"

class DefaultArg
val da = DefaultArg()

fun g(d: DefaultArg = da) = println(d)

fun h(d: DefaultArg = DefaultArg()) = println(d)

fun main() {
    color(1, 2, 3) eq "(1, 2, 3)"
    color(
        red = 1,
        green = 2,
        blue = 3) eq "(1, 2, 3)"
    color(
        1,
        2,
        blue = 3) eq "(1, 2, 3)"
    color(
        blue = 3,
        green = 2,
        red = 1) eq "(1, 2, 3)"
    color(
        red = 1,
        2,
        3) eq "(1, 2, 3)"
    // named 인자와 일반 인자를 혼용할 수 있지만, 순서가 바뀐 경우에는 모두 named 인자를 사용해야 함
    // color(
    //     blue = 3,
    //     2,
    //     1) eq "(1, 2, 3)"

    // default 인자가 사용됨
    color2(1, 1) eq "(1, 1, 0)"
    color2(blue = 1) eq "(0, 0, 1)"

    g() // DefaultArg@28feb3fa
    g() // DefaultArg@28feb3fa
    h() // DefaultArg@675d3402
    h() // DefaultArg@51565ec2
}