package com.example.notesapp.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.core.view.MenuProvider
import com.example.notesapp.Adapter.NoteAdapter
import com.example.notesapp.Entity.Note
import com.example.notesapp.R
import com.example.notesapp.Viewmoddel.NoteViewModel
import com.example.notesapp.databinding.FragmentHomeBinding

class homeFragment:Fragment(R.layout.fragment_home),SearchView.OnQueryTextListener ,MenuProvider {

    private val noteBinding: FragmentHomeBinding? = null
    private val binding get() = homeBinding!!

    private lateinit var notesViewModel: NoteViewModel
    private lateinit var noteAdapter: NoteAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

            override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
                super.onViewCreated(view, savedInstanceState)

                val menuHost: MenuHost = requireActivity()
                menuHost.addMenuProvider(this, viewlifecycleOwner, lifecycle.State.RESUME)

                notesViewModel = (activity as MainActivity).noteViewModel

                binding.addNoteFab.setOnClickLstner {
                    it.findNavController().navigate(R.id.action_homeFragment_to_addNoteFragment)
                }
            }

            private fun updateUI(note: List<Note>?) {
                if (note != null) {
                    if (note.isNotEmpty()) {
                        binding.emptyNotesImage.visibility = View.GONE
                        binding.homeRecyclerView.visibilit = View.GONE
                    }
                }
            }
            private fun setupHomeRecyclerView(){
                noteAdapter = NoteAdapter()
                binding.homeRecyclerView.apply{
                    layoutManager =staggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
                    setHasFixedSize(true)
                    adapter=NoteAdapter
                }
                activity?.let{
                    notesViewModel.getAllNotes().observe(viewLifeCycleOwner){note->
                        noteAdapter.differ.submitList(note)
                        updateUI(note)
                    }
                }

             }
        }


