package com.example.tms_anonl_17_lesson_21.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.tms_anonl_17_lesson_21.pojo.Group
import com.example.tms_anonl_17_lesson_21.pojo.ListItems
import com.example.tms_anonl_17_lesson_21.pojo.Note

class NoteDiffUtils : DiffUtil.ItemCallback<ListItems>() {
    override fun areItemsTheSame(oldItem: ListItems, newItem: ListItems): Boolean {
        var result = false
        if (oldItem is Note && newItem is Note) {
            result = oldItem.id == newItem.id
        } else if (oldItem is Group && newItem is Group) {
            result = oldItem.id == newItem.id
        }
        return result
    }

    override fun areContentsTheSame(oldItem: ListItems, newItem: ListItems): Boolean {
        var result = false
        if (oldItem is Note && newItem is Note) {
            result = oldItem == newItem
        } else if (oldItem is Group && newItem is Group) {
            result = oldItem == newItem
        }
        return result
    }
}