package com.akiniyalocts.codelab_room

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.akiniyalocts.codelab_room.model.Word

/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
class WordViewModel(application: Application) : AndroidViewModel(application){

    private val repo = WordRepository(application)

    val words = repo.getAllWords()

    fun insert(word: Word){
        repo.insert(word)
    }

}