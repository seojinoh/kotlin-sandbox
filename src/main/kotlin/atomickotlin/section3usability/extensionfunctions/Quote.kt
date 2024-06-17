import atomictest.*
// 다른 패키지에서도 확장 함수를 임포트해서 사용 가능
import extensionfunctions.singleQuote
import extensionfunctions.doubleQuote

fun main() {
    "Single".singleQuote() eq "'Single'"
    "Double".doubleQuote() eq "\"Double\""
}