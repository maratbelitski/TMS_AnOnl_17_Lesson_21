package com.example.tms_anonl_17_lesson_21

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tms_anonl_17_lesson_20.SingletonListItems
import com.example.tms_anonl_17_lesson_21.pojo.Note
import com.example.tms_anonl_17_lesson_21.adapter.MyNoteAdapter
import com.example.tms_anonl_17_lesson_21.databinding.ActivityMainBinding
import com.example.tms_anonl_17_lesson_21.pojo.Group
import java.util.Date
import java.util.UUID

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

            myAdapter.onNoteLongClick = {
                SingletonListItems.changeNote(it)
                myAdapter.notifyItemChanged(myAdapter.itemCount)  //сообщаем об обновлении
            }

            myAdapter.onGroupClick = {
                Toast.makeText(
                    this@MainActivity,
                    "Group notes: ${it.name}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initViews() {
        myAdapter = MyNoteAdapter()
        binding.recycler.adapter = myAdapter
        myAdapter.submitList(SingletonListItems.getListItems())
    }

    private fun createNewNote() {
        with(binding){
            val nameText = etName.text.toString().trim()
            val descriptionText = etDescription.text.toString().trim()

            val newItem = if (descriptionText.isEmpty()) {
                Group(UUID.randomUUID().toString(),nameText)
            } else {
                Note(UUID.randomUUID().toString(),nameText, descriptionText, Date().toString(), false)
            }

            SingletonListItems.insertItems(newItem)
            myAdapter.submitList(SingletonListItems.getListItems())
            myAdapter.notifyItemInserted(myAdapter.itemCount)   //сообщаем об обновлении

            etName.text?.clear()
            etDescription.text?.clear()
        }
    }
}