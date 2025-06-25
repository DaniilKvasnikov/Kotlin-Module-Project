package screens

import data.Note

class NoteScreen(var note: Note): Menu<Note>("Заметка") {
    fun displayMenu() {
        do {
            items.clear()
            super.addItem("Выход") { }
        } while (displayMenu(listOf(note)))
    }

    override fun displayMenu(archives: List<Note>): Boolean {
        println("$title:")
        println(note.content)
        println(items.keys.withIndex().joinToString("\n"){(index, it) -> "$index. $it"})
        return super.navigate(archives)
    }
}