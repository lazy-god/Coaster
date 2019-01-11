package me.darshpratap.coaster.models.db;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "category",
        foreignKeys = @ForeignKey(
                entity = Response.class,
                parentColumns = "id",
                childColumns = "res_id",
                onDelete = CASCADE
        )
)
public class Category {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private Double score;
    private int res_id;

    public Category(String title, Double score, int res_id) {
        this.title = title;
        this.score = score;
        this.res_id = res_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getScore() {
        return score;
    }

    public int getRes_id() {
        return res_id;
    }
}
