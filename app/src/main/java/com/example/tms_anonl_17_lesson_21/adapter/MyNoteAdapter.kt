package com.example.tms_anonl_17_lesson_21.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.tms_anonl_17_lesson_21.pojo.Group
import com.example.tms_anonl_17_lesson_21.pojo.ListItems
import com.example.tms_anonl_17_lesson_21.pojo.Note
import com.example.tms_anonl_17_lesson_21.R

class MyNoteAdapter : ListAdapter<ListItems, ViewHolder>(NoteDiffUtils()) {
    companion object {
        private const val NO_FAVORITE = 0
        private const val FAVORITE = 1
        private const val IS_GROUP = 2
    }

    var onNoteClick: ((Note) -> Unit)? = null
    var onGroupClick: ((Group) -> Unit)? = null
    var onNoteLongClick: ((Note) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is Group -> IS_GROUP
            is Note -> {
                val note = getItem(position) as Note
                if (note.isFavorite) {
                    FAVORITE
                } else {
                    NO_FAVORITE
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            FAVORITE -> MyFavoriteHolder.from(parent)
            NO_FAVORITE -> MyNotFavoriteHolder.from(parent)
            IS_GROUP -> MyGroupViewHolder.from(parent)
            else -> throw IllegalStateException(parent.resources.getString(R.string.error_message))
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)

        if (item is Note && holder is MyFavoriteHolder) {
            holder.bind(item, onNoteClick, onNoteLongClick)
        } else if (item is Note && holder is MyNotFavoriteHolder) {
            holder.bind(item, onNoteClick, onNoteLongClick)
        } else if (item is Group && holder is MyGroupViewHolder) {
            holder.bind(item, onGroupClick)
        }
    }
}