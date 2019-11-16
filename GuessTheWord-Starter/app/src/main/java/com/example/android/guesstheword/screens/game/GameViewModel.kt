package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word
    private var _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score
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
            _word.value = wordList.removeAt(0)
    }

    init {
        Log.i(this::class.java.simpleName, "created.")
        _word.value = ""
        _score.value = 0
        resetList()
        nextWord()
    }

    /** Methods for buttons presses **/
    fun onSkip() {
        if (wordList.isNotEmpty())
            _score.value = score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        if (wordList.isNotEmpty())
            _score.value = score.value?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i(this::class.java.simpleName, "destroyed.")
    }
}
