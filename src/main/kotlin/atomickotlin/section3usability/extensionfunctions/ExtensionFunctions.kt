package extensionfunctions
import atomictest.*

// 확장 함수: {{ 수신 객체 타입 }}.{{ 확장 함수 }}() { ... }
fun String.singleQuote() = "'$this'"
fun String.doubleQuote() = "\"$this\""

// this 키워드로 멤버 함수나 다른 확장에 접근할 수 있으며, 클래스 내부처럼 확장 함수 안에서도 this 생략 가능
fun String.strangeQuote() = this.singleQuote().singleQuote()
fun String.tooManyQuote() = doubleQuote().doubleQuote()

// 확장 함수는 수신 객체 타입의 public 프로퍼티에만 접근할 수 있으며, 일반 함수와 같은 역할만 가능하지만, 강력한 syntax sugar가 될 수 있다.
class Book(val title: String, private val author: String = "Unknown")

fun Book.categorize(category: String) = """title: "$title", category: $category"""
// fun Book.richCategorize(category: String) = """title: "$title", author: $author, category: $category""" // 오류: private 프로퍼티에는 접근할 수 없음

fun main() {
    "Hi".singleQuote() eq "'Hi'"
    "Hi".doubleQuote() eq "\"Hi\""

    "Hi".strangeQuote() eq "''Hi''"
    "Hi".tooManyQuote() eq "\"\"Hi\"\""

    Book("Dracula").categorize("Vampire") eq """title: "Dracula", category: Vampire"""
}