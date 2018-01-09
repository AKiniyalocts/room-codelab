package com.akiniyalocts.codelab_room;

import android.arch.persistence.room.TypeConverter;

import org.threeten.bp.Instant;

/**
 * Created by anthonykiniyalocts on 1/9/18.
 */

public class Converters {

    @TypeConverter
    public static Instant fromTimestamp(Long value){
        return Instant.ofEpochSecond(value);
    }

    @TypeConverter
    public static Long toTimeStamp(Instant value){
        return value.toEpochMilli();
    }

}
