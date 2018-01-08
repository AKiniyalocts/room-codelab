package com.akiniyalocts.codelab_room

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.akiniyalocts.codelab_room.model.Word

/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
@Database(entities = [(Word::class)], version = 1)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao

    companion object {

        private var INSTANCE : WordRoomDatabase? = null

        fun getDatabase(context: Context) : WordRoomDatabase{

            synchronized(WordRoomDatabase::class){
                if(INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            WordRoomDatabase::class.java, "word_database")
                            .build()
                }
            }

            return INSTANCE!!
        }


    }
}