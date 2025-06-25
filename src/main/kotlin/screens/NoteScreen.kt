package screens

import data.Note

class NoteScreen(var note: Note): Menu<Note>("Заметка") {
    fun displayMenu() {
        do {
            items.clear()
            super.addItem("Задать текст") {setText(note)}
            super.addItem("Выход") { }
        } while (displayMenu(listOf(note)))
    }

    override fun displayMenu(archives: List<Note>): Boolean {
        println("$title:")
        println(note.content)
        println(items.withIndex().joinToString("\n"){(index, it) -> "$index. ${it.name}"})
        return super.navigate(archives)
    }
    fun setText(note: Note) {
        println("Введите текст заметки:")
        val content = inputValidator.readStr()
        when {
            content.isBlank() -> println("Текст заметки не может быть пустым")
            else -> {
                note.content = content
                println("Текст заметки \"${note.name}\" изменен")
            }
        }
    }
}