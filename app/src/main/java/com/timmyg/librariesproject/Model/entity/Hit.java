package com.timmyg.librariesproject.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hit {

    @Expose
    @SerializedName("webformatURL")
    String webformatURL;

    @Expose
    @SerializedName("largeImageURL")
    String largeImageURL;

    public String getWebformatURL() {
        return webformatURL;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }
}
