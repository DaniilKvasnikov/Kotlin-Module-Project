package input

import java.util.Scanner

class ValidateInput {
    private val scanner = Scanner(System.`in`)
    fun selectItem(items: List<Any>): Int? {
        val input = scanner.nextLine().trim()
        val num = input.toIntOrNull()
        when {
            input.isBlank() -> println("Введите номер пункта")
            num == null -> {}
            num !in items.indices -> println("Пункта ${input.toInt()} не существует")
        }
        return num
    }
    fun readStr(): String {
        return scanner.nextLine().trim()
    }
}