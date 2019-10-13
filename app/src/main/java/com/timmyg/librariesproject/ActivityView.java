package com.timmyg.librariesproject;

import com.arellomobile.mvp.MvpView;

public interface ActivityView extends MvpView {

    void onRecyclerItemClick(int position);

}
