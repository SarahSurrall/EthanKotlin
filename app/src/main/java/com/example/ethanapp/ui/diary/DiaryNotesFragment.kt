package com.example.ethanapp.ui.diary

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ethanapp.databinding.FragmentDiaryNotesBinding
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DiaryNotesFragment : Fragment(){

        private var _binding: FragmentDiaryNotesBinding? = null

        // This property is only valid between onCreateView and
        // onDestroyView.
        private val binding get() = _binding!!

        private val csvFileHandler by lazy { CsvFileHandler(requireContext()) }

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            val diaryViewNotesModel =
                ViewModelProvider(this).get(DiaryNotesViewModel::class.java)

            _binding = FragmentDiaryNotesBinding.inflate(inflater, container, false)
            val root: View = binding.root

            val icon = arguments?.getInt("btn", 0) ?: 0
            val image = root.findViewById(com.example.ethanapp.R.id.selected_icon) as ImageView
            image.setImageResource(icon)

            return root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.saveBtn.setOnClickListener {
                val entry = getUserEntryInput()
                saveValueToCsv(entry)
                binding.dairyEntryField.text.clear()
            }
        }

        private fun getUserEntryInput(): DiaryEntry {
            val notesEdit: EditText = binding.dairyEntryField
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
            val ts = current.format(formatter)

            val emoji = "happy"
            Log.d("TAG", notesEdit.text.toString() + " " + ts + " " + emoji)
            return DiaryEntry(notesEdit.text.toString(), ts, emoji)
        }

        private fun saveValueToCsv(value: DiaryEntry) {
            csvFileHandler.saveValueToCsv(value)
            csvFileHandler.readCsv().forEach { e -> Log.d("OIK","$e.notes" +" " + "$e.emoji" +" " + "$e.ts") }
        }

        override fun onDestroyView() {
            super.onDestroyView()
            _binding = null
        }

}

data class DiaryEntry(
    val notes: String,
    val ts: String,
    val emoji: String
)

class CsvFileHandler(private val context: Context) {

    private val csvFileName = "diary_file.csv"

    fun saveValueToCsv(entry: DiaryEntry) {
        try {
            val file = File(context.filesDir, csvFileName)
            val fileWriter = FileWriter(file, true) // append mode
            val bufferedWriter = BufferedWriter(fileWriter)

            //no headers for simplicity
            // Write the new data
            bufferedWriter.write("$entry.notes,$entry.ts, $entry.emoji\n")
            Log.d("TAG", "$entry.notes" + " " + "$entry.ts")

            // Close the writer
            bufferedWriter.close()

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun readCsv(): ArrayList<DiaryEntry> {
        val file = File(context.filesDir, csvFileName)
        val fileReader = FileReader(file)

        val reader = BufferedReader(fileReader)
        var line : String? = reader.readLine()
        val results = ArrayList<DiaryEntry>()
        while (line != null) {
            val cols = line.split(",")
            results.add(DiaryEntry(cols[0], cols[1], cols[2]))
            line = reader.readLine()
        }
        return results
    }

}