package com.example.armedconflicts;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EventData.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract EventDao eventDao();
}
