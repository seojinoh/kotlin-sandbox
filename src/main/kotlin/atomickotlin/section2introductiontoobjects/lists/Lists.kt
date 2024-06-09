import atomictest.*

fun inferred(p: Char, q: Char) = listOf(p, q)

// <>는 타입 파라미터를 표시하며, 이 컨테이너는 타입 파라미터의 타입인 객체를 담는다라고 정의한다.
// 함수의 반환 타입을 지정하는 경우, 타입 파라미터를 반드시 명시해야 한다.
fun explicit(p: Char, q: Char): List<Char> = listOf(p, q)

fun getList(): List<Int> {
    return mutableListOf(1, 2, 3)
}

fun main() {
    val ints = listOf(1, 2, 3, 4, 5)
    ints eq "[1, 2, 3, 4, 5]"

    // List의 각 원소에 대해 이터레이션하기
    var result = ""
    for (i in ints) { // val i 및 i의 타입을 지정할 필요가 없으며, Kotlin이 문맥을 보고 식별자임을 판단한다.
        result += "$i "
    }
    result eq "1 2 3 4 5"

    // List 원소를 인덱싱하기
    ints[4] eq 5

    // List 원소의 마지막 인덱스보다 더 큰 인덱스를 사용 시
    capture {
        ints[5]
    } contains
            listOf("ArrayIndexOutOfBoundsException")

    val doubles = listOf(1.1, 2.2, 3.3, 4.4)
    doubles.sum() eq 11.0

    val strings = listOf("Twas", "Brillig", "And", "Slithy", "Toves")
    strings eq listOf("Twas", "Brillig ", "And", "Slithy", "Toves")
    strings.sorted() eq listOf("And", "Brillig", "Slithy", "Toves", "Twas") // 일반적으로 sort는 원본 List를 직접 바꾸는 의미이고, sorted는 새로운 List를 반환한다.
    strings.reversed() eq listOf("Toves", "Slithy", "And", "Brillig", "Twas") // 일반적으로 reverse는 원본 List를 직접 바꾸는 의미이고, reversed는 새로운 List를 반환한다.
    strings.first() eq "Twas"
    strings.takeLast(2) eq listOf("Slithy", "Toves")

    val numbers1 = listOf(1, 2, 3)
    val numbers2: List<Int> = listOf(1, 2, 3)
    numbers1 eq numbers2

    inferred('a', 'b') eq "[a, b]"
    explicit('y', 'z') eq "[y, z]"

    // 가변 List
    val list1 = listOf(1, 2, 3, 4, 5)
    val list2 = mutableListOf<Int>()

    // list1.add(1) // 오류
    // list1.sort() // 오류
    list2.add(5)
    list2.addAll(listOf(4, 3))
    list2 += 2
    list2 += listOf(1)
    list2.sort()

    list1 eq list2

    // 가변 List는 읽기 전용 List로 취급할 수 있지만, 내용은 변경할 수 없다.
    // 읽기 전용 List는 가변 List로 취급할 수 없다.
    val list = getList()
    // list += 3 // 오륲
    list eq listOf(1, 2, 3)

    // 에일리어싱의 예로, 읽기 전용 List가 가변 List를 참조한 경우, 가변 List를 변경하여, 읽기 전용 List를 변경할 수 있다.
    val first = mutableListOf(1)
    val second: List<Int> = first
    second eq listOf(1)

    first += 2
    second eq listOf(1, 2)

    // var로 정의된 읽기 전용 List의 경우 += 연산자를 사용할 수 있는데, 기존 List를 새로운 List로 대체한다.
    // 이러한 += 작동은 다른 컬렉션에서도 동일하며, 이러한 혼동을 방지하기 위해 var보다는 val을 써야한다.
    val listA = listOf(1)
    // listA.add(2) // 오류
    // listA += 3 // 오류

    var listB = listOf(1)
    println(System.identityHashCode(listB))
    // listB.add(2) // 오류
    listB += 3
    println(System.identityHashCode(listB)) // 객체의 고유 식별자가 다름
    listB eq listOf(1, 3)

    var listC = mutableListOf<Int>(1)
    println(System.identityHashCode(listC))
    listC += 3
    println(System.identityHashCode(listC)) // 객체의 고유 식별자가 같음
}