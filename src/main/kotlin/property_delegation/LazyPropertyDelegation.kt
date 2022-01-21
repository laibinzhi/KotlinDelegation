package property_delegation

val lazyValue: Int by lazy {
    println("world")
    10
}

fun main() {
    println("hello")
    println(lazyValue)
    println(lazyValue)
}