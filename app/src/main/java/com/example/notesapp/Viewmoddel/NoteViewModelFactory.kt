package com.example.notesapp.Viewmoddel

import android.app.Application
import android.credentials.CreateCredentialException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.Repository.noteRepository

class NoteViewModelFactory(val app:Application,private  val noteRepository: noteRepository):ViewModelProvider.Factory {

fun <T:ViewModel> Create(modelClass: Class<T>):T{
    return NoteViewModel(app,noteRepository)as T
}
}