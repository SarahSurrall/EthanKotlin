package com.example.ethanapp.ui.diary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ethanapp.R
import com.example.ethanapp.databinding.FragmentDiaryBinding


class DiaryFragment : Fragment(){

        private var _binding: FragmentDiaryBinding? = null

        // This property is only valid between onCreateView and
        // onDestroyView.
        private val binding get() = _binding!!


        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            _binding = FragmentDiaryBinding.inflate(inflater, container, false)

            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            binding.happyBtn.setOnClickListener {
                val btn = R.drawable.happy
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.angryBtn.setOnClickListener {
                val btn = R.drawable.angry
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.sadBtn.setOnClickListener {
                val btn = R.drawable.sad
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.excitedBtn.setOnClickListener {
                val btn = R.drawable.excited
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.explodeBtn.setOnClickListener {
                val btn = R.drawable.explode
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.funnyBtn.setOnClickListener {
                val btn = R.drawable.funny
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.loveBtn.setOnClickListener {
                val btn = R.drawable.hearts
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.illBtn.setOnClickListener {
                val btn = R.drawable.ill
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.quietBtn.setOnClickListener {
                val btn = R.drawable.quiet
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.scaredBtn.setOnClickListener {
                val btn = R.drawable.scared
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.thinkingBtn.setOnClickListener {
                val btn = R.drawable.thinking
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
            binding.tiredBtn.setOnClickListener {
                val btn = R.drawable.tired
                val bundle = bundleOf("btn" to btn)
                findNavController().navigate(R.id.action_DiaryFragment_to_NotesFragment, bundle)
            }
        }

        override fun onDestroyView() {
                super.onDestroyView()
                _binding = null
            }
    }
