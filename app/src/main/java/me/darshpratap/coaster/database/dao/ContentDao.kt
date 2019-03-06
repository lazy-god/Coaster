package me.darshpratap.coaster.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import me.darshpratap.coaster.models.db.Content

@Dao
interface ContentDao {
    @Insert
    fun insert(content: Content)

    @Query("SELECT * FROM content WHERE cat_id=:id")
    fun getContentsForCategory(id: Int): List<Content>
}