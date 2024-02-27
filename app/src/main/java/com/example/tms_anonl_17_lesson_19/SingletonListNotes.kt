package com.example.tms_anonl_17_lesson_19

object SingletonListNotes {

    private val newListNote = mutableListOf<ListItems>()
    fun insertNote(item: ListItems) {
        newListNote.add(item)
    }
    fun getListNote(): List<ListItems> {
        return newListNote
    }
    fun changeNote(note: Note) {
        note.isFavorite = !note.isFavorite
    }
}