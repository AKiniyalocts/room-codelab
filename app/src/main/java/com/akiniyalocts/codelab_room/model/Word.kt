package com.akiniyalocts.codelab_room.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import org.threeten.bp.Instant

/**
 * Created by anthonykiniyalocts on 1/8/18.
 */
@Entity(tableName = "word_table")
class Word(@PrimaryKey @ColumnInfo(name = "word") val word:String, @ColumnInfo(name = "date_created") val createdOn : Instant)
