package property_delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class MyDelegate {
    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue $thisRef,新的值是=$value")
    }

    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        println("getValue $thisRef,你委托的属性名是= ${property.name}")
        return "world"
    }
}

class MyDelegateV2 : ReadWriteProperty<PropertyDelegationTest02, String> {
    override fun getValue(thisRef: PropertyDelegationTest02, property: KProperty<*>): String {
        println("getValue $thisRef,你委托的属性名是= ${property.name}")
        return "world2"
    }

    override fun setValue(thisRef: PropertyDelegationTest02, property: KProperty<*>, value: String) {
        println("setValue $thisRef,新的值是=$value")
    }
}

class PropertyDelegationTest02 {
    var str: String by MyDelegateV2()
}

fun main() {
    val propertyDelegationTest02 = PropertyDelegationTest02()
    propertyDelegationTest02.str = "hello"
    println(propertyDelegationTest02.str)
}