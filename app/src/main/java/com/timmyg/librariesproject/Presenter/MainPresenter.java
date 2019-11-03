package com.timmyg.librariesproject.presenter;

import android.content.Context;
import android.content.Intent;

import com.arellomobile.mvp.InjectViewState;

import com.arellomobile.mvp.MvpPresenter;
import com.timmyg.librariesproject.ActivityView;
import com.timmyg.librariesproject.DetailActivity;
import com.timmyg.librariesproject.model.Model;

import com.timmyg.librariesproject.IViewHolder;

import java.util.List;

@InjectViewState
public class MainPresenter extends MvpPresenter<ActivityView> {

    private static final String TAG = "MAINPRESENTER";

    RecyclerInnerPresenter recyclerPresenter = new RecyclerInnerPresenter();


    private class RecyclerInnerPresenter implements RecyclerPresenter {

        private Model data = new Model();
        private List<Integer> list = data.getList();


        @Override
        public void bindView(IViewHolder viewHolder) {
            viewHolder.setImage(list.get(viewHolder.getPos()));
        }

        @Override
        public int getItemCount() {
            return list.size();
        }
    }

    public RecyclerInnerPresenter getRecyclerPresenter() {
        return recyclerPresenter;
    }

    public void onRecyclerItemClick(Context context, int position){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(TAG, position);
        context.startActivity(intent);
    }

}
