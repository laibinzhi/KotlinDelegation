package property_delegation

class User(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

fun main() {
    val user = User(mapOf("name2" to "Wang", "age" to 25))
    println(user.name)  // Prints "Wang"
    println(user.age)  // Prints 25
}