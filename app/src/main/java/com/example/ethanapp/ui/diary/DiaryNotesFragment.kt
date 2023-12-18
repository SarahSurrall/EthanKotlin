package com.example.ethanapp.ui.diary

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ethanapp.R
import com.example.ethanapp.databinding.FragmentDiaryNotesBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DiaryNotesFragment : Fragment(){

        private var _binding: FragmentDiaryNotesBinding? = null

        // This property is only valid between onCreateView and
        // onDestroyView.
        private val binding get() = _binding!!
        private lateinit var db : DiaryDatabaseHelper

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val diaryViewNotesModel =
                ViewModelProvider(this).get(DiaryNotesViewModel::class.java)

            _binding = FragmentDiaryNotesBinding.inflate(inflater, container, false)
            val root: View = binding.root
            db = DiaryDatabaseHelper(requireContext())


            val icon = arguments?.getInt("btn", 0) ?: 0
            val image = root.findViewById(com.example.ethanapp.R.id.selected_icon) as ImageView
            image.setImageResource(icon)

            return root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.saveBtn.setOnClickListener {
                val entry = getUserEntryInput()
                db.insertNote(entry)
                Toast.makeText(requireContext(), "Diary entry saved", Toast.LENGTH_SHORT).show()

                db.getAllEntries().forEach { e -> Log.d("OIK","$e.notes" +" " + "$e.emoji" +" " + "$e.ts") }
                binding.dairyEntryField.text.clear()
                findNavController().navigate(R.id.action_nav_ethan_diary_notes_to_nav_home)
            }
        }

        private fun getUserEntryInput(): DiaryEntry {
            val notesEdit: EditText = binding.dairyEntryField
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            val ts = current.format(formatter)

            val emoji = 111//"happy"
            Log.d("TAG", notesEdit.text.toString() + " " + ts + " " + emoji)
            return DiaryEntry(notesEdit.text.toString(), ts, emoji)
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }
}