package com.example.notesapp.Viewmoddel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Entity.Note
import com.example.notesapp.Repository.noteRepository
import kotlinx.coroutines.launch

class NoteViewModel(app:Application,private val noteRepository: noteRepository ):AndroidViewModel(app) {

    fun addNote(note: Note) =
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    fun insertNote(note: Note)=
    viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    fun updateNote(note: Note)=
    viewModelScope.launch {
        noteRepository.insertNote(note)
    }

    fun getAllNotes()= noteRepository.getAllNotes()

    fun searchNote(query: String?)=
        noteRepository.searchNote(query)
}