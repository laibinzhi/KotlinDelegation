package property_delegation

import kotlin.properties.Delegates

/**
 * 非空属性
 */
class NotNullPropertyDelegation {
    var userName: String by Delegates.notNull<String>()
}

fun main() {
    val notNullPropertyDelegation = NotNullPropertyDelegation()
    notNullPropertyDelegation.userName = "hello"
    println(notNullPropertyDelegation.userName)
}
