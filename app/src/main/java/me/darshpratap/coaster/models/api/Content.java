package me.darshpratap.coaster.models.api;

import com.google.gson.annotations.SerializedName;

public class Content {
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("displayValue")
    private String displayValue;
    @SerializedName("group")
    private String group;
    @SerializedName("scoreDisplayMode")
    private String scoreDisplayMode;
    @SerializedName("score")
    private Double score;

    public Content(String title, String description, String displayValue, String group, String scoreDisplayMode, Double score) {
        this.title = title;
        this.description = description;
        this.displayValue = displayValue;
        this.group = group;
        this.scoreDisplayMode = scoreDisplayMode;
        this.score = score;
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
