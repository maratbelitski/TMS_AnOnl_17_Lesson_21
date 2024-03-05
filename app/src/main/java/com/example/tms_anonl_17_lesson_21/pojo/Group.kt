package com.example.tms_anonl_17_lesson_21.pojo

import java.util.UUID

data class Group(
    val name: String = "",
    val id: String = UUID.randomUUID().toString()
) : ListItems
