package com.example.memory.mynote.ui

import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.memory.mynote.R
import com.example.memory.mynote.db.Note
import com.example.memory.mynote.db.NoteDatabase
import kotlinx.android.synthetic.main.fragment_add_note.*

class AddNoteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_note, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_done.setOnClickListener {

            val noteTitle = edit_text_title.text.toString().trim()
            val noteBody = edit_text_note.text.toString().trim()

            if (noteTitle.isEmpty()) {
                edit_text_title.error = "Title required!"
                edit_text_title.requestFocus()
                return@setOnClickListener
            }

            if (noteBody.isEmpty()) {
                edit_text_note.error = "Body required!"
                edit_text_note.requestFocus()
                return@setOnClickListener
            }

            val note = Note(noteTitle, noteBody)

            saveNote(note)

        }
    }

    private fun saveNote(note: Note) {
        class Savenote : AsyncTask<Void, Void, Void>() {
            override fun doInBackground(vararg params: Void?): Void? {
                NoteDatabase(requireActivity()).getNoteDao().addNote(note)

                return null
            }

            override fun onPostExecute(result: Void?) {
                super.onPostExecute(result)

                Toast.makeText(requireActivity(), "Note Saved!", Toast.LENGTH_SHORT).show()
            }

        }

        Savenote().execute()
    }
}