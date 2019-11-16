package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var word = ""
    var score = 0
    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    /** Resets the list of words and randomizes the order */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /** Moves to the next word in the list */
    private fun nextWord() {
        if (wordList.isNotEmpty()) //Select and remove a word from the list
            word = wordList.removeAt(0)
    }

    init {
        Log.i(this::class.java.simpleName, "created.")
        resetList()
        nextWord()
    }

    /** Methods for buttons presses **/
    fun onSkip() {
        if (wordList.isNotEmpty())
            score--
        nextWord()
    }

    fun onCorrect() {
        if (wordList.isNotEmpty())
            score++
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(this::class.java.simpleName, "destroyed.")
    }
}
