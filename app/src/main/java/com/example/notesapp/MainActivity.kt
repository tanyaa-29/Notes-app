package com.example.notesapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Repository.noteRepository
import com.example.notesapp.Viewmoddel.NoteViewModel
import com.example.notesapp.Viewmoddel.NoteViewModelFactory
import com.example.notesapp.database.NoteDatabase

class MainActivity : AppCompatActivity() {

lateinit var noteViewModel: NoteViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        setupViewModel()



    }
    private fun setupViewModel(){
        val noteRepository= noteRepository(NoteDatabase(this))
    val viewModelProviderFactory=NoteViewModelFactory(application,noteRepository)
    noteViewModel=ViewModelProvider(this,viewModelProviderFactory)[NoteViewModel::class.java]
    }
}