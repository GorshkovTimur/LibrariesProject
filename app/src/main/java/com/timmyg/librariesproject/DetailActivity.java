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

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends MvpActivity implements DetailedView {

    private static final String TAG_FOR_EXTRACT_DATA = "MAINPRESENTER";
    private String url;

    @BindView(R.id.detailed_imageview)
    ImageView imageView;

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
        ButterKnife.bind(this);
        App.getAppComponent().inject(this);
        loadImageFromMainActivity();
    }

    private void loadImageFromMainActivity() {
        url = getIntent().getStringExtra(TAG_FOR_EXTRACT_DATA);
        picassoLoader.loadImage(url, imageView);
    }


}



