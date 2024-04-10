package com.example.notesapp.database

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import java.util.concurrent.locks.Lock

@Database(entities = [Note::class], version = 1)

 abstract class NoteDatabase : RoomDatabase(){

     abstract  fun getNoteDao(): NoteDao

     companion object{
         @Volatile
         private  var instance:NoteDatabase? = null
         private val LOCK= Any ()

         operator fun invoke(context:Context) = instance ?:
         synchronized(LOCK){
             instance ?:
             createDatabase(context).also {
                 instance = it
             }

     }

      private fun createDatabase(context: Context)=
          Room.databaseBuilder(
              context.applicationContext,
              NoteDatabase::class.java,
              name = "note_db"
          ).build()

}
}