package com.example.ethanapp.ui.calmzone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import com.example.ethanapp.R
import com.example.ethanapp.databinding.FragmentCalmBinding
import com.example.ethanapp.databinding.FragmentDiaryEntriesBinding
import com.example.ethanapp.ui.diary.DiaryDatabaseHelper


class CalmFragment : Fragment() {


    private var _binding: FragmentCalmBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCalmBinding.inflate(inflater, container, false)
        val root: View = binding.root

            val views = listOf<WebView>(root.findViewById(R.id.WebView1),
                root.findViewById(R.id.WebView2),
                root.findViewById(R.id.WebView3),
                root.findViewById(R.id.WebView4),
                root.findViewById(R.id.WebView5),
                root.findViewById(R.id.WebView6),
                root.findViewById(R.id.Webview7))

            val videos = listOf("<iframe width=\"500\" height=\"375\" src=\"https://www.youtube.com/embed/qTN_MtV5TFw\" title=\"Candle and Flower Breathing - Mindful and Calming Breathing Technique\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
                "<iframe width=\"500\" height=\"375\" src=\"https://www.youtube.com/embed/_YwsrhQwoNE\" title=\"Super Mario Brothers Yoga Freeze Dance | Brain Break | Gonoodle inspired | PE Warm Up | Dance Party\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
                "<iframe width=\"400\" height=\"375\" src=\"https://www.youtube.com/embed/tymHYCbMJ-o\" title=\"Underwater Metronome for Sleep, Relaxation / Underwater Ambient , HQ Audio, Binaural, 4HRS 4K\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
                "<iframe width=\"400\" height=\"375\" src=\"https://www.youtube.com/embed/RGMj6yBKSTM\" title=\"NEW! Teenage Mutant Ninja Turtles Mutant Mayhem - Cosmic Kids Yoga Adventure!\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
                "<iframe width=\"400\" height=\"375\" src=\"https://www.youtube.com/embed/O2xtuHeyPac\" title=\"Kids Heart Challenge - Workout Challenge - Deep Breathing with Breeze\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
                "<iframe width=\"400\" height=\"375\" src=\"https://www.youtube.com/embed/0aSGy8Y-XxM\" title=\"Interoception for Kids\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>",
                "<iframe width=\"400\" height=\"375\" src=\"https://www.youtube.com/embed/ORRdf_nLc_I\" title=\"7-Minute Emotion Regulating Activity To Help Kids Calm Down! [with mindful breathing techniques]\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>")

        for (pair in views.zip(videos)) {
            pair.first.loadData(pair.second, "text/html","utf-8")
            pair.first.settings.javaScriptEnabled = true
            pair.first.webChromeClient = object : WebChromeClient(){}
        }
        return root
    }

}