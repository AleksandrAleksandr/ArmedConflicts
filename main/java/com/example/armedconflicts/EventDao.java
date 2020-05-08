package com.example.armedconflicts;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface EventDao {

    @Insert
    void insertAll(EventData... eventData);

    @Delete
    void delete(EventData eventData);

    @Query("SELECT * FROM eventdata")
    List<EventData> getAllEvents();
}
