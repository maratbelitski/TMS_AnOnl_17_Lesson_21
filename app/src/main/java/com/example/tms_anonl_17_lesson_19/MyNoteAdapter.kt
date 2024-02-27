package com.example.tms_anonl_17_lesson_19

import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyNoteAdapter : RecyclerView.Adapter<MyNoteViewHolder>() {

    var onNoteClick: ((Note) -> Unit)? = null
    var onNoteLongClick: ((Note) -> Unit)? = null

    var listNote = mutableListOf<Note>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        return if (listNote[position].isFavorite){
            1
        } else {
            0
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyNoteViewHolder {
        val layout: Int
        if (viewType == 1) {
            layout = R.layout.note_item_favorite
        } else {
            layout = R.layout.note_item
        }

        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return MyNoteViewHolder(view)
    }

    override fun getItemCount() = listNote.size


    override fun onBindViewHolder(holder: MyNoteViewHolder, position: Int) {
        val note = listNote[position]

        holder.name.text = note.name
        holder.description.text = note.description
        holder.date.text = note.date

        holder.itemView.setOnClickListener {
            onNoteClick?.invoke(note)
        }

        holder.itemView.setOnLongClickListener {
            onNoteLongClick?.invoke(note)
            true
        }
    }
}