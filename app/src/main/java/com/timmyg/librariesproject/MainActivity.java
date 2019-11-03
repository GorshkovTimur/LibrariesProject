package com.timmyg.librariesproject;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.arellomobile.mvp.MvpActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.timmyg.librariesproject.presenter.MainPresenter;

public class MainActivity extends MvpActivity implements ActivityView, MyAdapter.onRecyclerItemClickListener {

    private SharedPreferences settings;
    private MyAdapter myAdapter;

    private boolean firstLaunch = true ;
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCE_FIRST_LAUNCH = "IS_FIRST";

    @InjectPresenter
    MainPresenter mainPresenter;

    @ProvidePresenter
    MainPresenter providePresenter() {
        return new MainPresenter(this);
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        settings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        if (settings.contains(APP_PREFERENCE_FIRST_LAUNCH)){
            firstLaunch = false;
            mainPresenter.setFirstLaunch(firstLaunch);
        } else {
            mainPresenter.setFirstLaunch(firstLaunch);
        }

        RecyclerView recyclerView = findViewById(R.id.recycler_view_activity_three);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        myAdapter = new MyAdapter(mainPresenter.getRecyclerPresenter(),this);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onRecyclerItemClick(int position) {
        mainPresenter.onRecyclerItemClick(this, position);
    }

    @Override
    public void updateRecyclerView() {
        myAdapter.notifyDataSetChanged();
    }

    @Override
    public void setFirstLaunchFalse() {
        firstLaunch = false;
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(APP_PREFERENCE_FIRST_LAUNCH, firstLaunch);
        editor.apply();
    }



}
