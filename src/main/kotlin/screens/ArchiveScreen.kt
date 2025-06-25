package screens

import data.Archive
import data.Note

class ArchiveScreen(var archive: Archive): Menu<Note>("Список заметок в архиве ${archive.name}") {
    fun displayMenu() {
        do {
            items.clear()
            super.addItem("Создать заметку") { createNote() }
            archive.notes.forEach { note: Note -> super.addItem(note.content) {openNote(note)} }
            super.addItem("Выход") { }
        } while (super.displayMenu(archive.notes.toList()))
    }
    fun createNote() {
        println("Введите текст заметки:")
        val content = inputValidator.readStr()
        when {
            content.isBlank() -> println("Текст заметки не может быть пустым")
            else -> {
                archive.addNote(Note(content))
                println("Заметка \"$content\" создана")
            }
        }
    }
    fun openNote(note: Note) {
        val noteScreen = NoteScreen(note)
        noteScreen.displayMenu()
    }
}