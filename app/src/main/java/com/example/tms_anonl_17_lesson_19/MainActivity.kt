package com.example.tms_anonl_17_lesson_19

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var myAdapter: MyNoteAdapter
    private lateinit var btnSave: Button
    private lateinit var name: TextInputEditText
    private lateinit var description: TextInputEditText

    private val newListNote = mutableListOf<Note>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        doListeners()
    }

    private fun doListeners() {
        btnSave.setOnClickListener {
            createNewNote()
        }

        myAdapter.onNoteClick = {
            Toast.makeText(
                this,
                "Name note: ${it.name}\n Favorite: ${it.isFavorite}",
                Toast.LENGTH_SHORT).show()
        }

        myAdapter.onNoteLongClick = {
            val newNote = it.copy(isFavorite = true)

            if (!it.isFavorite) {
                addNewNoteInList(newNote)
                newListNote.remove(it)
            } else {
                addNewNoteInList(newNote)
                newListNote.remove(it)
            }
        }
    }

    private fun initViews() {
        recycler = findViewById(R.id.recycler)
        myAdapter = MyNoteAdapter()
        recycler.adapter = myAdapter

        btnSave = findViewById(R.id.btn_save)
        name = findViewById(R.id.et_name)
        description = findViewById(R.id.et_description)
    }

    private fun createNewNote() {
        val nameText = name.text.toString().trim()
        val descriptionText = description.text.toString().trim()

        val newNote = Note(nameText, descriptionText, date = Date().toString(), isFavorite = false)
        addNewNoteInList(newNote)

        name.text?.clear()
        description.text?.clear()
    }

    private fun addNewNoteInList(newNote: Note) {
        newListNote.add(newNote)
        myAdapter.listNote = newListNote
    }
}