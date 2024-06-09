class Alien(name: String) {
    val greeting = "Poor $name!"
}
class MutableNameAlien(var name: String)
class FixedNameAlien(val name: String)
class Artist(val name: String)
class Scientist(val name: String) {
    override fun toString(): String {
        return "Scientist($name)"
    }
}

fun main() {
    val alien = Alien("Mr. Meeseeks")
    println(alien.greeting)
    // println(alien.name) // 오류: name 파라미터는 greeting 프로퍼티를 초기화 하지만, 프로퍼티로 정의되지는 않았다.

    // 생성자 파라미터를 var나 val로 정의하면 해당 식별자가 프로퍼티로 바뀐다.
    val alien1 = MutableNameAlien("Reverse Giraffe")
    val alien2 = FixedNameAlien("Krombopolis Michael")
    alien1.name = "Parasite"
    // alien2.name = "Parasite" // 오류: val는 불변

    // println()은 문자열 대신 객체를 전달받은 경우, 객체의 toString()을 호출한 결과를 출력한다.
    // override 키워드로 이미 정의되어 있는 함수를 재정의 할 수 있다.
    val a = Artist("Vincent van Gogh")
    val s = Scientist("Zeep Xanflorp")

    println(a)
    println(s)
}