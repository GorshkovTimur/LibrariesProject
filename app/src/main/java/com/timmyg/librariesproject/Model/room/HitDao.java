package com.timmyg.librariesproject.model.room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.timmyg.librariesproject.model.entity.Hit;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface HitDao {

    @Query("SELECT * FROM table_hit")
    Single<List<Hit>> getAll();

    @Insert
    Single<List<Long>> insertList(List<Hit> hitList);
}
