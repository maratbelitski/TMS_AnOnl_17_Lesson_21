package com.example.tms_anonl_17_lesson_20.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_anonl_17_lesson_20.pojo.Note
import com.example.tms_anonl_17_lesson_20.databinding.NoteItemFavoriteBinding

class MyFavoriteHolder(private val binding: NoteItemFavoriteBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): MyFavoriteHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val noteItemFavoriteBinding = NoteItemFavoriteBinding.inflate(layoutInflater, parent, false)
            return MyFavoriteHolder(noteItemFavoriteBinding)
        }
    }

    fun bind(note: Note, click: ((Note) -> Unit)?, longClick: ((Note) -> Unit)?) {
        with(binding){
            inputName.text = note.name
            inputDescription.text = note.description
            tvDate.text = note.date
        }

        itemView.setOnLongClickListener {
            longClick?.invoke(note)
            true
        }

        itemView.setOnClickListener {
            click?.invoke(note)
        }
    }
}