package com.timmyg.librariesproject.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.timmyg.librariesproject.DetailedView;

@InjectViewState
public class DetailPresenter extends MvpPresenter<DetailedView> {

    private static final String TAG = "DetailPresenter";
    private DetailedView detailedView;
    private String fullImage;

    public DetailPresenter(DetailedView detailedView) {
        this.detailedView = detailedView;
    }


    public void loadImage(String url) {
        fullImage = url;
        detailedView.setImage(fullImage);
    }
}
