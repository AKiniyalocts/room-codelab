package com.akiniyalocts.codelab_room

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context

/**
 * Created by anthonykiniyalocts on 1/9/18.
 */
class RoomApplication : Application(){

    companion object {

        var db : WordRoomDatabase? = null

        fun initDatabase(context: Context){

            synchronized(WordRoomDatabase::class){
                if(db == null) {
                    db = Room.databaseBuilder(context.applicationContext,
                            WordRoomDatabase::class.java, "word_database")
                            .addMigrations(WordRoomDatabase.migration_1_2)
                            .build()
                }
            }
        }
    }

    override fun onCreate() {
        super.onCreate()

        initDatabase(this)

    }
}
