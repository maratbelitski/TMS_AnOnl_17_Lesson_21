package com.example.tms_anonl_17_lesson_19

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyNoteAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val NO_FAVORITE = 0
        private const val FAVORITE = 1
        private const val IS_GROUP = 2
    }

    var listItems = listOf<ListItems>()

    lateinit var onNoteClick: ((Note) -> Unit)
    lateinit var onNoteLongClick: ((Note) -> Unit)
    lateinit var onGroupClick: ((Group) -> Unit)

    override fun getItemViewType(position: Int): Int {

        return when (listItems[position]) {
            is Group -> IS_GROUP
            is Note -> {
                val note = listItems[position] as Note
                if (note.isFavorite) {
                    FAVORITE
                } else {
                    NO_FAVORITE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return when (viewType) {
            FAVORITE -> MyNoteViewHolder.from(parent, viewType)
            NO_FAVORITE -> MyNoteViewHolder.from(parent, viewType)
            IS_GROUP -> MyGroupViewHolder.from(parent)
            else -> throw IllegalStateException()
        }
    }

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = listItems[position]

        if (item is Note && holder is MyNoteViewHolder) {
            holder.bind(item, onNoteClick, onNoteLongClick)
        }

        if (item is Group && holder is MyGroupViewHolder) {
            holder.bind(item, onGroupClick)
        }
    }
}