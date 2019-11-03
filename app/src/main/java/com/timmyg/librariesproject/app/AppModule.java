package com.timmyg.librariesproject.app;

import android.app.Application;

import com.timmyg.librariesproject.model.picasso.PicassoLoader;
import com.timmyg.librariesproject.model.retrofit.ApiHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class AppModule {

    private final Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Singleton
    @Provides
    PicassoLoader providePicassoLoader() {return new PicassoLoader();}

    @Singleton
    @Provides
    ApiHelper provideApiHelper() {return new ApiHelper();}
}
