package com.akiniyalocts.codelab_room

import android.app.Application
import com.akiniyalocts.codelab_room.model.Word
import android.os.AsyncTask



/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
class WordRepository(application: Application){

    private val db = WordRoomDatabase.getDatabase(application)

    private val wordDao = db.wordDao()

    private val allWords = wordDao.getAllWords()


    fun getAllWords() = allWords


    fun insert(word: Word){
        InsertAsyncTask(wordDao).execute(word)
    }

    private class InsertAsyncTask internal constructor(private val asyncTaskDao: WordDao) : AsyncTask<Word, Void, Void>() {

        override fun doInBackground(vararg params: Word): Void? {
            asyncTaskDao.insert(params[0])
            return null
        }
    }
}