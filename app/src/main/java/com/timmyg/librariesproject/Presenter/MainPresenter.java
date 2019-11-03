package com.timmyg.librariesproject.presenter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;

import com.arellomobile.mvp.MvpPresenter;
import com.timmyg.librariesproject.ActivityView;
import com.timmyg.librariesproject.DetailActivity;

import com.timmyg.librariesproject.IViewHolder;
import com.timmyg.librariesproject.app.App;
import com.timmyg.librariesproject.model.entity.Hit;
import com.timmyg.librariesproject.model.entity.Photo;
import com.timmyg.librariesproject.model.retrofit.ApiHelper;
import com.timmyg.librariesproject.model.room.HitDao;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class MainPresenter extends MvpPresenter<ActivityView> {

    private static final String TAG = "MAINPRESENTER";

    private RecyclerInnerPresenter recyclerInnerPresenter;
    private ActivityView activityView;
    private ApiHelper apiHelper;
    private List<Hit> hitList;
    private HitDao hitDao;

    private boolean firstLaunch;

    public MainPresenter(ActivityView activityView) {
        this.activityView = activityView;
        recyclerInnerPresenter = new RecyclerInnerPresenter();
        apiHelper = new ApiHelper();
        hitDao = App.getAppDataBase().hitDao();
    }

    @Override
    protected void onFirstViewAttach() {

        if (firstLaunch) {
            getAllPhotoFromServer();
        }
        getAllPhotoFromDB();
    }


    private void getAllPhotoFromServer() {
        Observable<Photo> single = apiHelper.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photos ->{
            hitList = photos.getHits();
            getViewState().updateRecyclerView();
            putData();
            activityView.setFirstLaunchFalse();
        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }

    private void putData(){
        Disposable disposable = hitDao.insertList(hitList).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(id-> {
                    Log.d(TAG, "putData " + id);
                }, throwable -> {
                    Log.e(TAG, "putData error " + throwable);
                });
    }

    private void getAllPhotoFromDB() {
        Disposable disposable = hitDao.getAll().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(photos -> {
                    hitList = photos;
                    getViewState().updateRecyclerView();
                }, throwable -> {
                    Log.d(TAG, "getData: " + throwable);
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

    public void setFirstLaunch(boolean firstLaunch) {
        this.firstLaunch = firstLaunch;
    }
}
