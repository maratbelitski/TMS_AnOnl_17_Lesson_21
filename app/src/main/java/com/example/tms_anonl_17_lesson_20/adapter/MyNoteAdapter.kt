package com.example.tms_anonl_17_lesson_20.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_anonl_17_lesson_20.R
import com.example.tms_anonl_17_lesson_20.pojo.Group
import com.example.tms_anonl_17_lesson_20.pojo.ListItems
import com.example.tms_anonl_17_lesson_20.pojo.Note

class MyNoteAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        private const val NO_FAVORITE = 0
        private const val FAVORITE = 1
        private const val IS_GROUP = 2
    }

    var listItems = listOf<ListItems>()

    var onNoteClick: ((Note) -> Unit)? = null
    var onNoteLongClick: ((Note) -> Unit)? = null
    var onGroupClick: ((Group) -> Unit)? = null

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
            FAVORITE -> MyFavoriteHolder.from(parent)
            NO_FAVORITE -> MyNotFavoriteHolder.from(parent)
            IS_GROUP -> MyGroupViewHolder.from(parent)
            else -> throw IllegalStateException(parent.resources.getString(R.string.error_message))
        }
    }

    override fun getItemCount() = listItems.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = listItems[position]

        if (item is Note && holder is MyFavoriteHolder) {
            holder.bind(item, onNoteClick, onNoteLongClick)
        } else if (item is Note && holder is MyNotFavoriteHolder) {
            holder.bind(item, onNoteClick, onNoteLongClick)
        } else if (item is Group && holder is MyGroupViewHolder) {
            holder.bind(item, onGroupClick)
        }
    }
}