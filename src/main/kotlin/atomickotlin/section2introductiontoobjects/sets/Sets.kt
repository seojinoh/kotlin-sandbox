import atomictest.*

fun main() {
    // Set은 값의 중복이 없는 컬렉션이다.
    val intSet = setOf(1, 1, 2, 2, 3)
    intSet eq setOf(1, 2, 3)

    // 값의 순서는 중요하지 않다.
    setOf(1, 2) eq setOf(2, 1)

    (1 in intSet) eq true
    (11 in intSet) eq false

    intSet.contains(1) eq true
    intSet.contains(11) eq false

    intSet.containsAll(setOf(1, 2)) eq true

    // 합집합
    intSet.union(setOf(4, 5, 6)) eq setOf(1, 2, 3, 4, 5, 6)

    // 교집합
    intSet intersect setOf(1, 2) eq setOf(1, 2)

    // 차집합
    intSet subtract setOf(1, 2, 4) eq setOf(3)
    intSet - setOf(1, 2, 4) eq setOf(3)

    val list = listOf(3, 2, 3, 2, 1)
    list.toSet() eq setOf(1, 2, 3)
    list.distinct() eq listOf(3, 2, 1)
    "abbcc".toSet() eq setOf('a', 'b', 'c')

    // setOf()의 결과는 읽기 전용 Set이며, 가변 Set은 mutableSetOf()로 생성한다.
    val mutableSet = mutableSetOf<Int>()
    mutableSet += 1
    mutableSet += 1
    mutableSet eq setOf(1)
    mutableSet -= 1
    mutableSet eq setOf()
}