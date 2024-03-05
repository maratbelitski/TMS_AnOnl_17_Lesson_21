package com.example.tms_anonl_17_lesson_21.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.content.res.Resources
import android.content.res.Resources.Theme
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.tms_anonl_17_lesson_21.R
import com.example.tms_anonl_17_lesson_21.pojo.Group
import com.example.tms_anonl_17_lesson_21.databinding.NoteItemGroupBinding

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

        //смена цветов представления через контекст
        binding.cardNote.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(itemView.context,R.color.card_back_group_blue))
        binding.inputName.setTextColor(ContextCompat.getColor(itemView.context,R.color.white))

        itemView.setOnClickListener {
            click?.invoke(group)
        }
    }
}