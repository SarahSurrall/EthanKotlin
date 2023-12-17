package com.example.ethanapp.ui.diary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DiaryNotesViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "These are Ethan's Diary Notes"
    }
    val text: LiveData<String> = _text

}