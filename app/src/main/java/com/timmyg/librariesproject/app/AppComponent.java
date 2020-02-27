package com.timmyg.librariesproject.app;

import com.timmyg.librariesproject.DetailActivity;
import com.timmyg.librariesproject.MyAdapter;
import com.timmyg.librariesproject.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component (modules = AppModule.class)
public interface AppComponent {

    void inject(DetailActivity detailActivity);

    void inject(MainPresenter mainPresenter);

    void inject(MyAdapter myAdapter);

}
