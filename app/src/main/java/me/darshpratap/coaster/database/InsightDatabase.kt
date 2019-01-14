package me.darshpratap.coaster.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import me.darshpratap.coaster.database.dao.CategoryDao
import me.darshpratap.coaster.database.dao.ContentDao
import me.darshpratap.coaster.database.dao.HistoryDao
import me.darshpratap.coaster.models.db.Category
import me.darshpratap.coaster.models.db.Content
import me.darshpratap.coaster.models.db.History

@Database(
        entities = [
            History::class,
            Category::class,
            Content::class
        ],
        version = 1
)
abstract class InsightDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
    abstract fun categoryDao(): CategoryDao
    abstract fun contentDao(): ContentDao

    companion object {
        private var instance: InsightDatabase? = null

        @Synchronized
        fun getInstance(context: Context): InsightDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(context.applicationContext,
                        InsightDatabase::class.java, "insight_database")
                        .fallbackToDestructiveMigration()
                        .build()
            }
            return instance
        }
    }
}