package com.example.tms_anonl_17_lesson_20.pojo

import com.example.tms_anonl_17_lesson_20.pojo.ListItems

data class Note(
   val name: String = "",
   val description: String = "",
   val date: String ="",
   var isFavorite: Boolean = false
): ListItems
