package com.example.java_room_android;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Person.class},exportSchema = false,version = 1)
public abstract class PersonDatabase extends RoomDatabase {
    public abstract PersonDAO getDao();
}
