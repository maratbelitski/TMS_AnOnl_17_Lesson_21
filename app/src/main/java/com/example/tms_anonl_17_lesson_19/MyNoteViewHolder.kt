package com.example.tms_anonl_17_lesson_19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyNoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        private const val FAVORITE = 1
        fun from(parent: ViewGroup, viewType: Int): MyNoteViewHolder {

            val layout = when (viewType) {
                FAVORITE -> R.layout.note_item_favorite
                else -> R.layout.note_item
            }
            return MyNoteViewHolder(
                LayoutInflater.from(parent.context).inflate(layout, parent, false)
            )
        }
    }

    private val name: TextView = itemView.findViewById(R.id.input_name)
    private val description: TextView = itemView.findViewById(R.id.input_description)
    private val date: TextView = itemView.findViewById(R.id.tv_date)

    fun bind(note: Note, click: ((Note) -> Unit)?, longClick: ((Note) -> Unit)?) {
        name.text = note.name
        description.text = note.description
        date.text = note.date

        itemView.setOnLongClickListener {
            longClick?.invoke(note)
            true
        }

        itemView.setOnClickListener {
            click?.invoke(note)
        }
    }
}