package property_delegation

import kotlin.properties.Delegates

class Person {
    var age: Int by Delegates.observable(10) { property, oldValue, newValue ->
        println("onChange property.name=" + property.name + "   oldValue=" + oldValue + "   newValue=" + newValue)
    }

    var level: Int by Delegates.vetoable(10) { property, oldValue, newValue ->
        println("onChange property.name=" + property.name + "   oldValue=" + oldValue + "   newValue=" + newValue)
        newValue >= oldValue
    }
}

fun main() {
    val person = Person()
    println(person.age)
    person.age = 20
    println(person.age)
    println("-----------------------------------------")

    println(person.level)
    person.level = 20
    println("person.level="+person.level)
    person.level = 5
    println("person.level="+person.level)
}