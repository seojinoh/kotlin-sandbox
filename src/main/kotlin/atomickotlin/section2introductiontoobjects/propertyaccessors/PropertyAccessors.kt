import atomictest.*

class Data(var i: Int)

class Default {
    // get()과 set()을 정의하는 순서는 중요하지 않다.
    var i: Int = 0
        get() {
            trace("get()")
            return field
        }
        set(value) {
            trace("set($value)")
            field = value
        }
}

class Aggregator {
    // 세터를 private로 선언하여, 프로퍼티 값을 변경하는 일은 클래스 내부에서만 가능하다.
    var value: Int = 0
        private set
    fun inc() = value++
}

class Cage1 {
    // 일반적으로 프로퍼티는 값을 필드에 저장하지만, 필드가 없는 프로퍼티도 정의할 수 있다.
    val capacity: Int
        get() = 10
}

class Cage2(private val maxCapacity: Int) {
    // Kotlin 스타일 가이드에서는 계산 비용이 많이 들지 않고, 객체 상태가 바뀌지 않는 한 같은 결과를 내놓는 함수의 경우 프로퍼티를 사용하는 편이 낫다고 안내한다.
    fun capacity(): Int {
        val capacity = maxCapacity - 10
        return if (capacity < 1) 0 else capacity
    }
}

fun main() {
    val data = Data(10)
    data.i eq 10
    data.i = 20

    val d = Default()
    d.i = 1
    trace(d.i)
    trace eq """
        set(1)
        get()
        1
    """

    val aggregator = Aggregator()
    // aggregator.value = 2 // 오류
    repeat(10) {
        aggregator.inc()
    }
    aggregator.value eq 10

    val cage1 = Cage1()
    // cage1.capacity = 20 // 오류
    cage1.capacity eq 10

    val cage2 = Cage2(20)
    cage2.capacity() eq 10
}