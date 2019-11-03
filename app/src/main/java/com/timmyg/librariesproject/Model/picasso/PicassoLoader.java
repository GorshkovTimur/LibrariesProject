package com.timmyg.librariesproject.model.picasso;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class PicassoLoader {

    public void loadImage(String url, ImageView imageView){
        Picasso
                .get()
                .load(url)
                .into(imageView);
    }
}
