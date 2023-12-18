package com.example.ethanapp.ui.diary

import com.example.ethanapp.R

class DiaryIconHelper {
    public fun getString( savedIcon: Int): String {
        if (savedIcon == R.drawable.happy) return "happy"
        else if (savedIcon == R.drawable.excited) return "excited"
        else if (savedIcon == R.drawable.explode) return "explode"
        else if (savedIcon == R.drawable.angry) return "angry"
        else if (savedIcon == R.drawable.funny) return "funny"
        else if (savedIcon == R.drawable.hearts) return "hearts"
        else if (savedIcon == R.drawable.ill) return "ill"
        else if (savedIcon == R.drawable.quiet) return "quiet"
        else if (savedIcon == R.drawable.sad) return "sad"
        else if (savedIcon == R.drawable.scared) return "scared"
        else if (savedIcon == R.drawable.thinking) return "thinking"
        else return "tired"
    }

    public fun getDrawable( savedIcon: String): Int {
        if (savedIcon == "happy") return R.drawable.happy
        else if (savedIcon == "excited") return R.drawable.excited
        else if (savedIcon == "explode") return R.drawable.explode
        else if (savedIcon == "angry") return R.drawable.angry
        else if (savedIcon == "funny") return R.drawable.funny
        else if (savedIcon == "hearts") return R.drawable.hearts
        else if (savedIcon == "ill") return R.drawable.ill
        else if (savedIcon == "quiet") return R.drawable.quiet
        else if (savedIcon == "sad") return R.drawable.sad
        else if (savedIcon == "scared") return R.drawable.scared
        else if (savedIcon == "thinking") return R.drawable.thinking
        else return R.drawable.tired
    }

}