import data.Archive
import screens.ArchiveSelectScreen

fun main() {
    val archives: MutableList<Archive> = mutableListOf()
    val archiveSelectScreen = ArchiveSelectScreen(archives)
    archiveSelectScreen.displayMenu()
}