package com.example.tms_anonl_17_lesson_19

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var recycler: RecyclerView
    private lateinit var myAdapter: MyNoteAdapter
    private lateinit var btnSave: Button
    private lateinit var name: TextInputEditText
    private lateinit var description: TextInputEditText


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
                "Name note: ${it.name}\nFavorite: ${it.isFavorite}",
                Toast.LENGTH_SHORT).show()
        }

        myAdapter.onGroupClick = {
            Toast.makeText(
                this,
                "Group notes: ${it.name}", Toast.LENGTH_SHORT).show()
        }

        myAdapter.onNoteLongClick = {
            SingletonListItems.changeNote(it)
            myAdapter.notifyItemChanged(myAdapter.itemCount)  //сообщаем об обновлении
        }
    }

    private fun initViews() {
        recycler = findViewById(R.id.recycler)
        myAdapter = MyNoteAdapter()
        recycler.adapter = myAdapter
        myAdapter.listItems = SingletonListItems.getListItems()

        btnSave = findViewById(R.id.btn_save)
        name = findViewById(R.id.et_name)
        description = findViewById(R.id.et_description)
    }

    private fun createNewNote() {
        val nameText = name.text.toString().trim()
        val descriptionText = description.text.toString().trim()

        val newItem = if (descriptionText.isEmpty()) {
            Group(nameText)
        } else {
            Note(nameText, descriptionText, Date().toString(), false)
        }

        SingletonListItems.insertItems(newItem)
        myAdapter.listItems = SingletonListItems.getListItems()

        myAdapter.notifyItemInserted(myAdapter.itemCount)   //сообщаем об обновлении

        name.text?.clear()
        description.text?.clear()
    }
}