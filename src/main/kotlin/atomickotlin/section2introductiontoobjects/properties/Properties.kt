class Cup {
    var percentFull = 0
    val max = 100
    fun add(increase: Int): Int {
        percentFull += increase
        if (percentFull > max) {
            percentFull = max
        }
        return percentFull
    }
}

class House1 {
    val sofa: String = "Simple sleeper sofa: $80.00"
}

class House2 {
    var sofa: String = "Simple sleeper sofa: $80.00"
}

class Kitchen {
    var table: String = "Round table"
}

fun main() {
    val cup = Cup()
    cup.add(50)
    println(cup.percentFull)
    cup.add(70)
    println(cup.percentFull)

    // 객체의 가변성은 내부 상태를 바꿀 수 있다는 뜻이다.
    // House1: 불변 객체
    // House2: 가변 객체
    var house1 = House1()
    val house2 = House2()

    // house1.sofa = "New leather sofa: $200.00" // 오류: sofa는 val이므로 불변
    house1 = House1() // house1는 var이므로 가변

    println(house1.sofa)

    house2.sofa = "New leather sofa: $200.00" // sofa는 var이므로 가변
    // house2 = House() // 오류: house2는 val이므로 가변

    println(house2.sofa)

    // 생성된 인스턴스의 식별자는 객체가 아닌 참조다.
    val kitchen1 = Kitchen()
    val kitchen2 = kitchen1

    println(kitchen1.table)
    println(kitchen2.table)

    kitchen1.table = "Square table"

    println(kitchen1.table)
    println(kitchen2.table)
}