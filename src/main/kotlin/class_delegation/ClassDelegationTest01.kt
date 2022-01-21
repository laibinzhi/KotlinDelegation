package class_delegation

/**
 * 类委托
 */

interface IWork {
    fun work()
}

class Teacher : IWork {
    override fun work() {
        println("I am a teacher")
    }
}

class Police : IWork {
    override fun work() {
        println("I am a Police")
    }
}

class Tony(work: IWork) : IWork by work

fun main() {
    Tony(Teacher()).work()
    Tony(Police()).work()
}