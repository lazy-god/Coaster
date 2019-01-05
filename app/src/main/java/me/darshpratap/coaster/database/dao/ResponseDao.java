package me.darshpratap.coaster.database.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;

@Dao
public interface ResponseDao {
    @Insert
    void insert();
    @Delete
    void delete();
    @Update
    void update();
}
