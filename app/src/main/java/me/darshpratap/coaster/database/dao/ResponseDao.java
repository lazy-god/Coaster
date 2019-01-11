package me.darshpratap.coaster.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import me.darshpratap.coaster.models.db.Response;

@Dao
public interface ResponseDao {
    @Insert
    void insert(Response category);
    @Delete
    void delete(Response category);
    @Update
    void update(Response category);
    @Query("SELECT id FROM response_table WHERE url=:url")
    LiveData<Integer> getId(String url);
}
