package com.example.loginandsignupwithfirebase

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.loginandsignupwithfirebase.databinding.ActivityAllNotesBinding
import com.example.loginandsignupwithfirebase.databinding.DialogUpdateNoteBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class AllNotes : AppCompatActivity(), NoteAdapter.OnItemClickListener {

    private lateinit var binding: ActivityAllNotesBinding
    private lateinit var databaseReference: DatabaseReference
    private lateinit var auth: FirebaseAuth
    private lateinit var adapter: NoteAdapter
    private val noteList = mutableListOf<NoteItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAllNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser ?: return

        adapter = NoteAdapter(noteList, this)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        databaseReference = FirebaseDatabase.getInstance().reference
        val noteReference =
            databaseReference.child("users").child(currentUser.uid).child("notes")

        noteReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                noteList.clear()
                for (noteSnapshot in snapshot.children) {
                    val note = noteSnapshot.getValue(NoteItem::class.java)
                    note?.let { noteList.add(it) }
                }
                noteList.reverse()
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@AllNotes, "Failed to load notes", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDeleteClick(noteId: String) {
        val currentUser = auth.currentUser ?: return

        databaseReference.child("users")
            .child(currentUser.uid)
            .child("notes")
            .child(noteId)
            .removeValue()
            .addOnSuccessListener {
                Toast.makeText(this, "Note Deleted", Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Delete Failed", Toast.LENGTH_SHORT).show()
            }
    }

    override fun onUpdateClick(noteId: String, currentTitle: String, currentDescription: String) {

        val dialogBinding = DialogUpdateNoteBinding.inflate(LayoutInflater.from(this))

        dialogBinding.updatenotetitle.setText(currentTitle)
        dialogBinding.updatenotedescription.setText(currentDescription)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogBinding.root)
            .create()

        dialogBinding.btnUpdate.setOnClickListener {
            val newTitle = dialogBinding.updatenotetitle.text.toString().trim()
            val newDescription = dialogBinding.updatenotedescription.text.toString().trim()
            updateNoteDatabase(noteId, newTitle, newDescription)
            dialog.dismiss()
        }

        dialogBinding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun updateNoteDatabase(noteId: String, newTitle: String, newDescription: String) {
        val currentUser = auth.currentUser ?: return

        val noteReference =
            databaseReference.child("users")
                .child(currentUser.uid)
                .child("notes")
                .child(noteId)

        val updatedNote = NoteItem(newTitle, newDescription, noteId)

        noteReference.setValue(updatedNote)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Note Updated Successfully", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Failed to update note", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
