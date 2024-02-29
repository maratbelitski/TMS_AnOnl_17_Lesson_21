package com.example.tms_anonl_17_lesson_20

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_anonl_17_lesson_20.pojo.Group
import com.example.tms_anonl_17_lesson_20.pojo.Note
import com.example.tms_anonl_17_lesson_20.adapter.MyNoteAdapter
import com.example.tms_anonl_17_lesson_20.databinding.ActivityMainBinding
import java.util.Date

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var myAdapter: MyNoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
        doListeners()
    }

    private fun doListeners() {
        with(binding){
            btnSave.setOnClickListener {
                createNewNote()
            }

            myAdapter.onNoteClick = {
                Toast.makeText(
                    this@MainActivity,
                    "Name note: ${it.name}\nFavorite: ${it.isFavorite}",
                    Toast.LENGTH_SHORT).show()
            }

            myAdapter.onGroupClick = {
                Toast.makeText(
                    this@MainActivity,
                    "Group notes: ${it.name}", Toast.LENGTH_SHORT).show()
            }

            myAdapter.onNoteLongClick = {
                SingletonListItems.changeNote(it)
                myAdapter.notifyItemChanged(myAdapter.itemCount)  //сообщаем об обновлении
            }
        }
    }

    private fun initViews() {
        myAdapter = MyNoteAdapter()
        binding.recycler.adapter = myAdapter
        myAdapter.listItems = SingletonListItems.getListItems()
    }

    private fun createNewNote() {
        with(binding){
            val nameText = etName.text.toString().trim()
            val descriptionText = etDescription.text.toString().trim()

            val newItem = if (descriptionText.isEmpty()) {
                Group(nameText)
            } else {
                Note(nameText, descriptionText, Date().toString(), false)
            }

            SingletonListItems.insertItems(newItem)
            myAdapter.listItems = SingletonListItems.getListItems()
            myAdapter.notifyItemInserted(myAdapter.itemCount)   //сообщаем об обновлении

            etName.text?.clear()
            etDescription.text?.clear()
        }
    }
}