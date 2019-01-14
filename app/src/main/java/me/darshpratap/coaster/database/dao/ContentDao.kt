package me.darshpratap.coaster.database.dao

import androidx.room.Dao
import androidx.room.Insert
import me.darshpratap.coaster.models.db.Content

@Dao
interface ContentDao {
    @Insert
    fun insert(content: Content)
}