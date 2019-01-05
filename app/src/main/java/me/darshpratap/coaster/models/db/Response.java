package me.darshpratap.coaster.models.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "response_table")
public class Response {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String url;

    public Response(String url) {
        this.url = url;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }
}
