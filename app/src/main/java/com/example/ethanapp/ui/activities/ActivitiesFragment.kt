package com.example.ethanapp.ui.activities

import android.graphics.drawable.Drawable
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.ethanapp.R
import com.example.ethanapp.databinding.FragmentActivitiesBinding
import kotlin.random.Random

class ActivitiesFragment : Fragment() {

    private var _binding: FragmentActivitiesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
                ViewModelProvider(this).get(ActivitiesViewModel::class.java)

        _binding = FragmentActivitiesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.randomButton.setOnClickListener {
            val pairing = getRandomPairing()
            binding.randomButton.setImageResource(pairing.image)
            binding.randomButton.scaleType = ImageView.ScaleType.FIT_CENTER
            binding.activityInstructionsText.setText(pairing.text)
            binding.randomButton.animate().apply{
                duration = 1000
                rotationXBy(360f)
            }
            binding.activityInstructionsText.animate().apply {
                duration = 1000
                rotationXBy(360f)
            }

        }
    }



    fun getRandomPairing() : ImageTextPair{
        val imageTextPairs = listOf(
            ImageTextPair(R.drawable.lego, "Build something awesome with Lego. Maybe a fort, castle, zoo and spaceship"),
            ImageTextPair(R.drawable.disco, "Have a dance party with Freya"),
            ImageTextPair(R.drawable.star, "Do 30 star jumps"),
            ImageTextPair(R.drawable.write, "Write a book"),
            ImageTextPair(R.drawable.karate, "Practice your martial arts"),
            ImageTextPair(R.drawable.hop,"Balance on one leg for as long as you can, then try the other leg"),
            ImageTextPair(R.drawable.draw, "Draw a picture of the best thing you have done this week"),
            ImageTextPair(R.drawable.sing, "Sing your favourite song"),
            ImageTextPair(R.drawable.read, "Read a chapter of a book")
        )

        return imageTextPairs[Random.nextInt(imageTextPairs.size)]
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

data class ImageTextPair(val image: Int, val text: String)