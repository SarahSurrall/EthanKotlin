package com.example.ethanapp.ui.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DiaryViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is Ethan's Diary"
    }
    val text: LiveData<String> = _text

    val fragment = DiaryNotesFragment()

}

