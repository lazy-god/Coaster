package me.darshpratap.coaster.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import me.darshpratap.coaster.models.db.Category;

@Dao
public interface CategoryDao {
    @Insert
    void insert(Category category);
    @Delete
    void delete(Category category);
    @Update
    void update(Category category);
}
