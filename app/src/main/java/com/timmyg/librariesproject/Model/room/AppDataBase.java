package com.timmyg.librariesproject.model.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.timmyg.librariesproject.model.entity.Hit;

@Database(entities = {Hit.class}, version = 1, exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    public abstract HitDao hitDao();
}
