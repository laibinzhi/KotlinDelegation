package property_delegation

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class StringDelegate(private var s: String = "student") : ReadWriteProperty<Student, String> {
    override operator fun getValue(thisRef: Student, property: KProperty<*>): String {
        return s
    }

    override operator fun setValue(thisRef: Student, property: KProperty<*>, value: String) {
        s = value
    }
}

class StudentDelegator {

    operator fun provideDelegate(thisRef: Student, prop: KProperty<*>): ReadWriteProperty<Student, String> {
        return if (prop.name.contains("userName")) {
            StringDelegate("userName")
        } else {
            StringDelegate("country")
        }
    }
}


class Student {
    var userName: String by StudentDelegator()
    var country: String by StudentDelegator()
}

fun main() {
    val student = Student()
    println(student.userName)
    println(student.country)
}