package com.example.tms_anonl_17_lesson_20

import com.example.tms_anonl_17_lesson_21.pojo.ListItems
import com.example.tms_anonl_17_lesson_21.pojo.Note

object SingletonListItems {

    private val newListNote = mutableListOf<ListItems>()
    fun insertItems(item: ListItems) {
        newListNote.add(item)
    }
    fun getListItems(): MutableList<ListItems> {
        return newListNote
    }
    fun changeNote(note: Note) {
        note.isFavorite = !note.isFavorite
    }
}