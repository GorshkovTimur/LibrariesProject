package com.timmyg.librariesproject.model.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photo {

    @Expose
    @SerializedName("hits")
    private List<Hit> hits;

    public List<Hit> getHits() {
        return hits;
    }
}
