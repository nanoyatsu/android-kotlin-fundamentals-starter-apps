package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    val word = MutableLiveData<String>()
    var score = MutableLiveData<Int>()
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
            word.value = wordList.removeAt(0)
    }

    init {
        Log.i(this::class.java.simpleName, "created.")
        word.value = ""
        score.value = 0
        resetList()
        nextWord()
    }

    /** Methods for buttons presses **/
    fun onSkip() {
        if (wordList.isNotEmpty())
            score.value = score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        if (wordList.isNotEmpty())
            score.value = score.value?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(this::class.java.simpleName, "destroyed.")
    }
}
