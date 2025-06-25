package screens

import data.Archive

class ArchiveSelectScreen(val archives: MutableList<Archive>): Menu<Archive>("Список архивов") {

    fun displayMenu() {
        do {
            items.clear()
            super.addItem("Создать архив") { createArchive() }
            archives.forEach { archive: Archive -> super.addItem(archive.name) {openArchive(archive)} }
            super.addItem("Выход") { }
        } while (super.displayMenu(archives))
    }
    fun createArchive() {
        println("Введите имя архива:")
        val name = inputValidator.readStr()
        when {
            name.isBlank() -> println("Имя архива не может быть пустым")
            else -> {
                archives.add(Archive(name))
                println("Архив \"$name\" создан")
            }
        }

    }
    fun openArchive(archive: Archive) {
        val archiveScreen = ArchiveScreen(archive)
        archiveScreen.displayMenu()
    }
}