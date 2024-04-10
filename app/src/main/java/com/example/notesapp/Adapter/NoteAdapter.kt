package com.example.notesapp.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.notesapp.Entity.Note
import com.example.notesapp.Fragment.homeFragment
import com.example.notesapp.databinding.ActivityMainBinding
import com.example.notesapp.databinding.NoteLayoutBinding

class NoteAdapter :RecyclerView.Adapter<NoteAdapter.NoteViewHolder>(){

    class NoteViewHolder(val itemBinding: NoteLayoutBinding):RecyclerView.ViewHolder(itemBinding.root)

    private  val differCallback =object :DiffUtil.ItemCallback<Note>(){
        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id== newItem.id&&
                    oldItem.noteDesc== newItem.noteDesc&&
                    oldItem.noteTitle== newItem.noteTitle
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
           return  oldItem==newItem
        }

    }
    val differ= AsyncListDiffer(this,differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
        NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
  }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote=differ.currentList[position]

        holder.itemBinding.noteTitle.text=currentNote.noteTitle
        holder.itemBinding.noteDesc.text=currentNote.noteDesc

        holder.itemView.setOnClickListener{
            val direction =homeFragmentDirections.actionhomeFragmentToeditNoteFragment(currentNote)
            it.findNavController().navigate(direction)
        }
    }

}