package me.darshpratap.coaster.models.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Best_Practices {
    @SerializedName("title")
    private String title;
    @SerializedName("score")
    private Double score;
    @SerializedName("contents")
    ArrayList<Content> contents;

    public Best_Practices(String title, Double score, ArrayList<Content> contents) {
        this.title = title;
        this.score = score;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public Double getScore() {
        return score;
    }

    public ArrayList<Content> getContents() {
        return contents;
    }
}