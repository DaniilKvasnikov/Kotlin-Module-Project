package screens

import data.Archive
import data.Note

class ArchiveScreen(var archive: Archive): Menu<Note>("Список заметок в архиве ${archive.name}") {
    fun displayMenu() {
        do {
            items.clear()
            super.addItem("Создать заметку") { createNote() }
            archive.notes.forEach { note: Note -> super.addItem(note.name) {openNote(note)} }
            super.addItem("Выход") { }
        } while (super.displayMenu(archive.notes.toList()))
    }
    fun createNote() {
        println("Введите имя заметки:")
        val name = inputValidator.readStr()
        when {
            name.isBlank() -> println("Имя заметки не может быть пустым")
            else -> {
                archive.addNote(Note(name))
                println("Заметка \"$name\" создана")
            }
        }
    }
    fun openNote(note: Note) {
        val noteScreen = NoteScreen(note)
        noteScreen.displayMenu()
    }
}