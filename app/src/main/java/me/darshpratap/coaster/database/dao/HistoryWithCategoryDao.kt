package me.darshpratap.coaster.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.darshpratap.coaster.models.db.HistoryWithCategory as HistoryWithCategoryDB

@Dao
interface HistoryWithCategoryDao {
    @Query("SELECT * FROM history ORDER BY id DESC")
    fun getHistory(): LiveData<List<HistoryWithCategoryDB>>
}