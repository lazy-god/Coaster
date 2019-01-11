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
                onDelete = CASCADE
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
    private int cat_id;

    public Content(String title, String description, String displayValue, String group, String scoreDisplayMode, Double score, int cat_id) {
        this.title = title;
        this.description = description;
        this.displayValue = displayValue;
        this.group = group;
        this.scoreDisplayMode = scoreDisplayMode;
        this.score = score;
        this.cat_id = cat_id;
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

    public int getCat_id() {
        return cat_id;
    }
}
