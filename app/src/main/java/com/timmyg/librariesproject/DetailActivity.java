package com.timmyg.librariesproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.timmyg.librariesproject.Presenter.DetailPresenter;

public class DetailActivity extends AppCompatActivity implements DetailedView {

    private static final String TAG = "MAINPRESENTER";
    private DetailPresenter detailPresenter =new DetailPresenter(this);
    private ImageView imageView;

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
