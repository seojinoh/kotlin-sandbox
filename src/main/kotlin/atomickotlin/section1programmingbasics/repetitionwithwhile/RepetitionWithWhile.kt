fun main() {
    // while: 조건문에 따라 본문이 실행되지 않을 수 있다.
    var i = 0
    while(i < 5) {
        print(i)
        i++
    }
    println()

    // do-while: 최소 한 번은 실행된다.
    i = 0
    do {
        print(i)
        i++
    } while (i < 5)
    println()
}