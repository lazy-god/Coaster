package me.darshpratap.coaster.database.dao

import androidx.room.Dao
import androidx.room.Insert
import me.darshpratap.coaster.models.db.Category

@Dao
interface CategoryDao {
    @Insert
    fun insert(category: Category): Long
}