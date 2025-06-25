package screens
import input.ValidateInput

abstract class Menu<T>(protected val title: String) {
    protected val items = mutableMapOf<String, (T?) -> Unit>()
    protected val inputValidator = ValidateInput()

    fun addItem(name: String, action: (T?) -> Unit) {
        items[name] = action
    }

    protected open fun displayMenu(archives: List<T>): Boolean {
        println("$title:")
        println(items.keys.withIndex().joinToString("\n"){(index, it) -> "$index. $it"})
        return navigate(archives)
    }

    protected fun navigate(archives: List<T>): Boolean {
        val index = inputValidator.selectItem(items.toList())
        when {
            index == null -> {}
            index == items.toList().lastIndex -> return false
            index == 0 -> items.values.toList()[index](null)
            index-1 in archives.indices -> items.values.toList()[index](archives[index - 1])
        }
        return true
    }

}