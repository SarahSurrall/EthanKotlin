package com.example.ethanapp.ui.diary_entries

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.ethanapp.R
import com.example.ethanapp.databinding.FragmentDiaryEntriesBinding
import com.example.ethanapp.ui.diary.DiaryDatabaseHelper
import com.example.ethanapp.ui.diary.DiaryIconHelper

class DiaryEntriesFragment : Fragment() {

    private var _binding: FragmentDiaryEntriesBinding? = null
    private lateinit var db : DiaryDatabaseHelper

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDiaryEntriesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        db = DiaryDatabaseHelper(requireContext())

        val tableLayout = root.findViewById<TableLayout>(R.id.TableLayoutDiaryEntries)

        val data = db.getAllEntries()
        for (item in data) {
            val helper = DiaryIconHelper()
            val emoji_id =  helper.getDrawable(item.emoji)

            val tableRow = createRow(item.ts, emoji_id, item.notes)
            tableLayout.addView(tableRow)
        }

        return root
    }


    private fun createRow(dateTime: String, drawableResId: Int, multilineText: String): TableRow {
        val tableRow = TableRow(requireContext())

        // Create TextView for DateTime
        val dateTimeTextView = createTextView(dateTime)
        tableRow.addView(dateTimeTextView)

        // Create ImageView for Drawable
        val drawableImageView = createImageView(drawableResId)
        tableRow.addView(drawableImageView)

        // Create TextView for Multiline Text
        val multilineTextView = createTextView(multilineText)
        tableRow.addView(multilineTextView)

        return tableRow
    }

    private fun createTextView(text: String): TextView {
        val textView = TextView(requireContext())
        textView.text = text
        textView.gravity = Gravity.CENTER
        textView.setPadding(8, 8, 8, 8)
        return textView
    }

    private fun createImageView(drawableResId: Int): ImageView {
        val imageView = ImageView(requireContext())
        val drawable: Drawable? = ContextCompat.getDrawable(requireContext(), drawableResId)
        imageView.setImageDrawable(drawable)
        imageView.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.WRAP_CONTENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )
        imageView.setPadding(8, 8, 8, 8)
        return imageView
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}