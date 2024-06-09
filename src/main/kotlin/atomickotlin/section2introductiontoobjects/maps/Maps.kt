import atomictest.*

class Contact(
    val name: String,
    val phone: String
) {
    override fun toString(): String {
        return "Contact('$name', '$phone')"
    }
}

fun main() {
    val constants = mapOf(
        "Pi" to 3.141,
        "e" to 2.718,
        "phi" to 1.618
    )
    constants eq "{Pi=3.141, e=2.718, phi=1.618}"

    // 키에 해당하는 값을 찾는다.
    constants["e"] eq 2.718
    constants.keys eq setOf("Pi", "e", "phi")
    constants.values eq "[3.141, 2.718, 1.618]"

    // 키-값 쌍을 이터레이션한다.
    var s = ""
    for (entry in constants) {
        s += "${entry.key}=${entry.value}, "
    }
    s eq "Pi=3.141, e=2.718, phi=1.618,"

    // 이터레이션을 하면서 키와 값을 분리한다.
    s = ""
    for ((key, value) in constants) {
        s += "$key=$value, "
    }
    s eq "Pi=3.141, e=2.718, phi=1.618,"

    // mapOf()의 결과는 읽기 전용 Map이며, 가변 Map은 mutableMapOf()로 생성한다.
    val m = mutableMapOf(
        5 to "five",
        6 to "six"
    )
    m[5] eq "five"
    m[5] = "5ive"
    m[5] eq "5ive"
    m += 4 to "four"
    // mapOf()와 mutableMapOf()는 원소가 Map에 전달된 순서를 유지해준다.
    m eq mapOf(
        5 to "5ive",
        4 to "four",
        6 to "six"
    )

    val map1 = mapOf(5 to "five", 6 to "six")
    map1[5] eq "five"
    // map[5] = "5ive" // 오류
    // map += (4 to "four") // 오류
    map1 + (4 to "four") // 기존 맵이 아닌 새로운 맵을 만든다.
    map1 eq mapOf(5 to "five", 6 to "six")
    val map2 = map1 + (4 to "four")
    map2 eq mapOf(5 to "five", 6 to "six", 4 to "four")

    // 주어진 키에 해당하는 원소가 없으면, Map은 null을 반환한다.
    // null이 될 수 없는 결과를 원한다면, getValue()를 사용한다.
    // 일반적으로 getOrDefault()이 null을 반환하거나 예외를 발생시키는 것보다 더 나은 대안이다.
    val mapA = mapOf('a' to "attempt")
    mapA['b'] eq null
    capture {
        mapA.getValue('b')
    } eq "NoSuchElementException: " + "Key b is missing in the map."
    mapA.getOrDefault('a', "??") eq "attempt"
    mapA.getOrDefault('b', "??") eq "??"

    // 클래스 인스턴스를 Map의 키나 값으로 사용할 수 있다.
    val miffy = Contact("Miffy", "1-234-567890")
    val cleo = Contact("Cleo", "098-765-4321")
    val contacts = mapOf(
        miffy.phone to miffy,
        cleo.phone to cleo
    )
    contacts["1-234-567890"] eq miffy
    contacts["1-111-111111"] eq null
}