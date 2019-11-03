package com.timmyg.librariesproject.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "table_hit")
public class Hit {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @Expose
    @SerializedName("webformatURL")
    private String webformatURL;

    @Expose
    @SerializedName("largeImageURL")
    private String largeImageURL;

    public String getWebformatURL() {
        return webformatURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }
}
