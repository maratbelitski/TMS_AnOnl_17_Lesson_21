package com.example.tms_anonl_17_lesson_21.pojo

data class Note(
   val id: String = "",
   val name: String = "",
   val description: String = "",
   val date: String ="",
   var isFavorite: Boolean = false
) : ListItems
