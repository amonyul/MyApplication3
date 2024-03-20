package com.example.myapplication.DataBase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.myapplication.Models.Notes;

@Database(entities = Notes.class, version = 1, exportSchema = false)
public abstract class RoomDB extends RoomDatabase {

    private static RoomDB database;
    private static String Database_Name = "NoteApp";

    public synchronized static RoomDB getInstance(Context context){
        if (database==null){
            database= Room.databaseBuilder(context.getApplicationContext(), RoomDB.class, Database_Name)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return database;
    }
    public abstract mainDao mainDao();
}
