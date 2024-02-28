package com.example.tms_anonl_17_lesson_19

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyGroupViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    companion object {
        fun from(parent: ViewGroup): MyGroupViewHolder {
            return MyGroupViewHolder(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.note_item_group, parent, false)
            )
        }
    }


    private val name: TextView = itemView.findViewById(R.id.input_name)
    fun bind(group: Group, click: ((Group) -> Unit)?) {
        name.text = group.name

        itemView.setOnClickListener {
            click?.invoke(group)
        }
    }
}