package property_delegation

class ListWithTrash<T>(private val innerList: MutableList<T> = ArrayList()) : MutableList<T> by innerList {
    var deletedItem: T? = null
    override fun remove(element: T): Boolean {
        deletedItem = element
        return innerList.remove(element)
    }

    fun recover(): T? {
        return deletedItem
    }
}

fun main() {
    val listWithTrash = ListWithTrash(arrayListOf(1, 2, 3))
    listWithTrash.remove(2)
    println("被删除的元素是=" + listWithTrash.recover())
}