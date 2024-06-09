import atomictest.*

fun main() {
    val v1 = 11
    val v2 = "Ontology"

    // 중위 표기법: infix 키워드를 사용하여, a.{{ 함수 }}(b)를 a {{ 함수 }} b처럼 사용하는 것이다.
    v1 eq 11
    v2 eq "Ontology"
    v2 neq "Epistimology"
    v2 eq "Epistimology" // 실패 케이스

    trace("line 1")
    trace(47)
    trace("line 2")
    trace eq """
        line 1
        47
        line 2
    """
}