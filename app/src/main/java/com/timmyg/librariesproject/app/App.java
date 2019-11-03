package com.timmyg.librariesproject.app;

import android.app.Application;

import androidx.room.Room;

import com.timmyg.librariesproject.model.room.AppDataBase;

public class App extends Application {

    private static AppDataBase appDataBase;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = generateAppComponent();
        appDataBase = Room.databaseBuilder(getApplicationContext(),AppDataBase.class, "room_database").build();
    }

    private AppComponent generateAppComponent() {
        return DaggerAppComponent
                .builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppDataBase getAppDataBase() {
        return appDataBase;
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
