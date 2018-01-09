package com.akiniyalocts.codelab_room

import android.app.Application
import com.akiniyalocts.codelab_room.model.Word
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
class WordRepository(application: Application){

    private val wordDao = RoomApplication.db?.wordDao()

    private val allWords = wordDao?.getAllWords()


    fun getAllWords() = allWords


    fun insert(word: Word){

        Single.fromCallable {
            RoomApplication.db?.wordDao()?.insert(word)
        }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }
}