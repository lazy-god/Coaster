package me.darshpratap.coaster.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.darshpratap.coaster.models.db.History

@Dao
interface HistoryDao {
    @Insert
    fun insert(history: History): Long
    @Query("SELECT * FROM history ORDER BY id DESC")
    fun getAllHistory(): LiveData<List<History>>
}