package com.example.notesapp.Repository

import com.example.notesapp.Entity.Note
import com.example.notesapp.database.NoteDatabase

class noteRepository (private  val db:NoteDatabase){
    suspend fun insertNote(note:Note)= db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note:Note)= db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note)=db.getNoteDao().updateNote(note)

    fun getAllNotes()= db.getNoteDao().getAllNOtes()
    fun  searchNote(query:String ?)=db.getNoteDao().searchNote(query)
}