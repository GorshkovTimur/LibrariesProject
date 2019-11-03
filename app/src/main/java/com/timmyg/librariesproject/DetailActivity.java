package com.timmyg.librariesproject;


import android.os.Bundle;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpActivity;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.timmyg.librariesproject.presenter.DetailPresenter;

public class DetailActivity extends MvpActivity implements DetailedView {

    private static final String TAG = "MAINPRESENTER";
    private ImageView imageView;

    @InjectPresenter
    DetailPresenter detailPresenter;

    @ProvidePresenter
    DetailPresenter providePresenter() {return new DetailPresenter(this);}



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageView = findViewById(R.id.detailed_imageview);
        int position = getIntent().getIntExtra(TAG, 0);
        detailPresenter.setPosition(position);
        detailPresenter.log();

    }

    @Override
    public void setImage(int image) {
        imageView.setImageResource(image);
    }
}
