package com.example.androidexamp.example.room;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user where email = :email and password = :password")
    User login(String email, String password);


    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

}