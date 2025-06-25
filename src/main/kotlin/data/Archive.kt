package data

data class Archive(var name: String) {
    val notes = mutableListOf<Note>()

    fun addNote(newNote: Note) {
        notes.add(newNote)
    }
}
