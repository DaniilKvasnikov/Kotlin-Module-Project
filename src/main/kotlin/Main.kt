import data.Archive
import data.Note
import screens.ArchiveSelectScreen

fun main(args: Array<String>) {
    val archives: MutableList<Archive> = mutableListOf()
    val archiveSelectScreen = ArchiveSelectScreen(archives)
    archiveSelectScreen.displayMenu()
}