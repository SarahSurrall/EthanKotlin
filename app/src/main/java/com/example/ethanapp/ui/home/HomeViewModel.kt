package com.example.ethanapp.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = """Hello Ethan, welcome to your personal app.
                     
I made this for you as a special gift for Christmas 2023. 
Daddy did lots of extra chores to make time for mummy to finish the project.

This is a special place just for you. There are lots of parts for you to explore.
You can create a New Diary Entry to write notes about your day.
Previous entries can be seen in the Diary Entries page.
The Activities section might give you ideas for things to do.
The Calm Zone can give you ideas of things to try to help calm down and relax.
                                
I hope you enjoy this, as you are very special.
                                
Love Mummy"""
    }
    val text: LiveData<String> = _text
}