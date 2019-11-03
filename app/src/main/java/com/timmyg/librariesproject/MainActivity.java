package com.timmyg.librariesproject;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.timmyg.librariesproject.presenter.MainPresenter;

public class MainActivity extends MvpActivity implements ActivityView, MyAdapter.onRecyclerItemClickListener {

    @InjectPresenter
    MainPresenter mainPresenter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view_activity_three);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        MyAdapter myAdapter = new MyAdapter(mainPresenter.getRecyclerPresenter(),this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        mainPresenter.onRecyclerItemClick(this, position);
    }
}
