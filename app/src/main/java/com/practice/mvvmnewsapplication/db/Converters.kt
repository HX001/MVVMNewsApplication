package com.practice.mvvmnewsapplication.db

import androidx.room.TypeConverter
import com.practice.mvvmnewsapplication.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}