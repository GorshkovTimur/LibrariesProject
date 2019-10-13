package com.timmyg.librariesproject.Presenter;

import android.util.Log;

import com.timmyg.librariesproject.DetailedView;
import com.timmyg.librariesproject.Model.Model;

public class DetailPresenter {

    private static final String TAG = "DetailPresenter";

    private Model model;
    private DetailedView detailedView;

    private int position = 0;
    private int image;

    public DetailPresenter(DetailedView detailedView) {
        this.detailedView = detailedView;
        model = new Model();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;

    }


    public void log() {
        Log.d(TAG, String.valueOf(position));
        image = model.getList().get(position);
        detailedView.setImage(image);

    }
}