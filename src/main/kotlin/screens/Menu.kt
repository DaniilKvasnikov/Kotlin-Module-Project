package screens
import input.ValidateInput

abstract class Menu<T>(protected val title: String) {
    protected val items = mutableListOf<MenuItem<T>>()
    protected val inputValidator = ValidateInput()

    fun addItem(name: String, action: (T?) -> Unit) {
        items.add(MenuItem<T>(name, action))
    }

    protected open fun displayMenu(archives: List<T>): Boolean {
        println("$title:")
        println(items.withIndex().joinToString("\n"){(index, it) -> "$index. ${it.name}"})
        return navigate(archives)
    }

    protected fun navigate(archives: List<T>): Boolean {
        val index = inputValidator.selectItem(items.toList())
        when {
            index == null -> println("Введите число")
            index == items.toList().lastIndex -> return false
            index == 0 -> items.toList()[index].action(null)
            index - 1 in archives.indices -> items.toList()[index].action(archives[index - 1])
        }
        return true
    }
    protected data class MenuItem<T>(val name: String, val action: (T?) -> Unit)
}