package com.example.myapplication.DataBase;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.myapplication.Models.Notes;

import java.util.List;

@Dao
public interface mainDao {
    @Insert(onConflict = REPLACE)
    void insert (Notes notes);

    @Query("select * from notes order by pinned desc, id desc")
    List<Notes> getAll();

    @Query("update notes set title = :title, notes = :notes where id = :id")
    void update (int id, String title, String notes);

    @Delete
    void delete (Notes notes);

    @Query("update notes set pinned = :pin where id = :id")
    void pin(int id, boolean pin);
}
