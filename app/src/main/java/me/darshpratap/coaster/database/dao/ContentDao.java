package me.darshpratap.coaster.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import me.darshpratap.coaster.models.db.Content;

@Dao
public interface ContentDao {
    @Insert
    void insert(Content category);
    @Delete
    void delete(Content category);
    @Update
    void update(Content category);
}
