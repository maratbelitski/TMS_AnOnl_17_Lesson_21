package com.example.tms_anonl_17_lesson_21.pojo

import java.util.Date
import java.util.UUID

data class Note(
    val name: String = "",
    val description: String = "",
    var isFavorite: Boolean = false,
    val date: String = Date().toString(),
    val id: String = UUID.randomUUID().toString()
) : ListItems
