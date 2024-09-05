package com.practice.mvvmnewsapplication.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.practice.mvvmnewsapplication.models.Article

@Database(
    entities = [Article::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class ArticleDataBase: RoomDatabase() {

    abstract fun getArticleDao(): ArticleDAO

    companion object {
        @Volatile // make sure the field is updated by one thread will be immediately visible to other threads
        private var instance: ArticleDataBase ?= null
        private val LOCK = Any() // make sure only one instance exist at once

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            // everything happens here cant be accessed by other thread at the same time
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ArticleDataBase::class.java,
                "article_db.db"
            ).build()

    }
}