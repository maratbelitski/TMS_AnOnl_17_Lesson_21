package com.example.tms_anonl_17_lesson_19

import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MyNoteViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.input_name)
    val description: TextView = itemView.findViewById(R.id.input_description)
    val date: TextView = itemView.findViewById(R.id.tv_date)
    val card: CardView = itemView.findViewById(R.id.card_note)
}