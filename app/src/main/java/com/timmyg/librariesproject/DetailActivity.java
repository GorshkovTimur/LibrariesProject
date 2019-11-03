package com.timmyg.librariesproject;


import android.os.Bundle;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpActivity;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.timmyg.librariesproject.app.App;
import com.timmyg.librariesproject.model.picasso.PicassoLoader;
import com.timmyg.librariesproject.presenter.DetailPresenter;

import javax.inject.Inject;

public class DetailActivity extends MvpActivity implements DetailedView {

    private static final String TAG = "MAINPRESENTER";
    private ImageView imageView;
    private String url;

    @InjectPresenter
    DetailPresenter detailPresenter;

    @ProvidePresenter
    DetailPresenter providePresenter() {
        return new DetailPresenter(this);
    }

    @Inject
    PicassoLoader picassoLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        App.getAppComponent().inject(this);
        imageView = findViewById(R.id.detailed_imageview);
        url = getIntent().getStringExtra(TAG);
        detailPresenter.loadImage(url);
        picassoLoader.loadImage(url, imageView);
    }

    @Override
    public void setImage(String url) {

    }
}



