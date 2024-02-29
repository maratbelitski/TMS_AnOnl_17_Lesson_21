package com.example.tms_anonl_17_lesson_20.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_anonl_17_lesson_20.pojo.Group
import com.example.tms_anonl_17_lesson_20.databinding.NoteItemGroupBinding

class MyGroupViewHolder(private val binding: NoteItemGroupBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun from(parent: ViewGroup): MyGroupViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val noteItemGroupBinding = NoteItemGroupBinding.inflate(layoutInflater, parent, false)

            return MyGroupViewHolder(noteItemGroupBinding)
        }
    }

    fun bind(group: Group, click: ((Group) -> Unit)?) {
        binding.inputName.text = group.name

        itemView.setOnClickListener {
            click?.invoke(group)
        }
    }
}