class Giraffe
class Bear
class Hippo
class Hamster {
    fun speak() = "Squeak! "
    fun exercise() =
        this.speak() + // this로 한정함 (불필요한 this는 지양)
        speak() + // this 없이 호출
        "Running on wheel"
}

fun main() {
    val g1 = Giraffe()
    val g2 = Giraffe()
    val b = Bear()
    val h = Hippo()

    // {{ 클래스 이름 }}@{{ 16진 표기법 메모리 주소 }}
    println(g1) // Giraffe@4517d9a3
    println(g2) // Giraffe@372f7a8d
    println(b) // Bear@2f92e0f4
    println(h) // Hippo@28a418fc

    val hamster = Hamster()
    println(hamster.exercise())
}