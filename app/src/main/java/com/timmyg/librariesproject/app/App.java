package com.timmyg.librariesproject.app;

import android.app.Application;

import androidx.room.Room;

import com.timmyg.librariesproject.model.room.AppDataBase;

public class App extends Application {

    private static AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();

        appDataBase = Room.databaseBuilder(getApplicationContext(),AppDataBase.class, "room_database").build();
    }

    public static AppDataBase getAppDataBase() {
        return appDataBase;
    }
}
