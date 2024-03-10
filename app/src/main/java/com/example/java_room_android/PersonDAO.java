package com.example.java_room_android;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface PersonDAO {
    @Insert
    void insertData(Person person);

    @Update
    void updateData(Person person);

    @Query("select * from Person")
    List<Person> getData();

}
