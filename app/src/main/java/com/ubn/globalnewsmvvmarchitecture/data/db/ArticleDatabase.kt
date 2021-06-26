package com.ubn.globalnewsmvvmarchitecture.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ubn.globalnewsmvvmarchitecture.data.model.Article


@Database(
    entities = [Article::class],
    version = 1,
 //   exportSchema = false
)
@TypeConverters(Converters::class)
abstract  class ArticleDatabase : RoomDatabase(){
    abstract fun getArticleDAO(): ArticleDAO
}

