package com.folioreader.util

import com.folioreader.model.SelectedWord

interface WordSelectedListener {

    fun onSelected(selectedWord: SelectedWord)
}