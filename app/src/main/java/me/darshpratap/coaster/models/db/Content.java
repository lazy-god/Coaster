package me.darshpratap.coaster.models.db;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(
        tableName = "content",
        foreignKeys = @ForeignKey(
                entity = Category.class,
                parentColumns = "id",
                childColumns = "cat_id",
                onDelete = CASCADE,
                onUpdate = CASCADE
        )
)
public class Content {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String title;
    private String description;
    private String displayValue;
    private String group;
    private String scoreDisplayMode;
    private Double score;

    public Content(String title, String description, String displayValue, String group, String scoreDisplayMode, Double score) {
        this.title = title;
        this.description = description;
        this.displayValue = displayValue;
        this.group = group;
        this.scoreDisplayMode = scoreDisplayMode;
        this.score = score;
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

    public String getDescription() {
        return description;
    }

    public String getDisplayValue() {
        return displayValue;
    }

    public String getGroup() {
        return group;
    }

    public String getScoreDisplayMode() {
        return scoreDisplayMode;
    }

    public Double getScore() {
        return score;
    }
}
