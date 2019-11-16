package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.ViewModel

class ScoreViewModel(var finalScore: Int) : ViewModel() {
    init {
        Log.i(this::class.java.simpleName, "Final score is $finalScore")
    }
}