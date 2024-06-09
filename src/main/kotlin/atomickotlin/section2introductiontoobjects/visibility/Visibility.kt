class Counter(var start: Int) {
    fun increment() {
        start += 1
    }
    override fun toString() = start.toString()
}

class CounterHolder(counter: Counter) {
    private val ctr = counter
    override fun toString() = "CounterHolder: $ctr"
}

fun main() {
    // 다른 파일에 정의한 private 멤버에 접근할 수 없다.
    // val rabbit = Animal("Rabbit") // 오류: 클래스가 private인 경우
    // recordAnimal(rabbit) // 오류: 함수가 private인 경우
    // index++ // 오류: 프로퍼티가 private인 경우
    recordAnimals()
    recordAnimalsCount()

    // 에일리어싱(aliasing): 한 객체에 대해 참조를 여러 개 유지하는 경우
    val c = Counter(11)
    val ch = CounterHolder(c)
    println(ch)
    c.increment()
    println(ch)

    // CounterHolder 안에 있는 ctr 외에는 Counter(9)를 가르키는 참조가 존재하지 않아, ch2만 이 객체를 조작할 수 있다.
    val ch2 = CounterHolder(Counter(9))
    println(ch2)
}