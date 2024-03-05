package com.example.tms_anonl_17_lesson_21.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_anonl_17_lesson_21.pojo.Note

import com.example.tms_anonl_17_lesson_21.databinding.NoteItemBinding

class MyNotFavoriteHolder(private val binding: NoteItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): MyNotFavoriteHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val noteItemBinding = NoteItemBinding.inflate(layoutInflater, parent, false)
            return MyNotFavoriteHolder(noteItemBinding)
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