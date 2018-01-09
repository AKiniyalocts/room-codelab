package com.akiniyalocts.codelab_room

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.arch.persistence.room.migration.Migration
import com.akiniyalocts.codelab_room.model.Word

/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
@Database(entities = [(Word::class)], version = 2)
@TypeConverters(Converters::class)
abstract class WordRoomDatabase : RoomDatabase() {

    abstract fun wordDao() : WordDao

      companion object {
         val migration_1_2 : Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE 'word_table' " +
                        " ADD COLUMN 'date_created' INTEGER NOT NULL DEFAULT 0")
            }

        }
    }

}