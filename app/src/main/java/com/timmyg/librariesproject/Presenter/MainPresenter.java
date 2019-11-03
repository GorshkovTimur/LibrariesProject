package com.timmyg.librariesproject.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import com.arellomobile.mvp.MvpPresenter;
import com.timmyg.librariesproject.ActivityView;
import com.timmyg.librariesproject.DetailActivity;
import com.timmyg.librariesproject.model.Model;

import com.timmyg.librariesproject.IViewHolder;
import com.timmyg.librariesproject.model.entity.Hit;
import com.timmyg.librariesproject.model.entity.Photo;
import com.timmyg.librariesproject.model.retrofit.ApiHelper;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class MainPresenter extends MvpPresenter<ActivityView> {

    private static final String TAG = "MAINPRESENTER";

    private RecyclerInnerPresenter recyclerInnerPresenter;
    private ApiHelper apiHelper;
    private List<Hit> hitList;

    public MainPresenter() {
        recyclerInnerPresenter = new RecyclerInnerPresenter();
        apiHelper = new ApiHelper();
    }

    @Override
    protected void onFirstViewAttach() {
        getAllPhoto();
    }

    private void getAllPhoto() {
        Observable<Photo> single = apiHelper.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photos ->{
            hitList = photos.getHits();
            getViewState().updateRecyclerView();

        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }

    private class RecyclerInnerPresenter implements RecyclerPresenter {


        @Override
        public void bindView(IViewHolder viewHolder) {
            viewHolder.setImage(hitList.get(viewHolder.getPos()).getWebformatURL());
        }

        @Override
        public int getItemCount() {
            if (hitList != null){
                return hitList.size();
            }
            return 0;
        }
    }

    public RecyclerInnerPresenter getRecyclerPresenter() {
        return recyclerInnerPresenter;
    }

    public void onRecyclerItemClick(Context context, int position){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(TAG, hitList.get(position).getLargeImageURL());
        context.startActivity(intent);
    }

}
