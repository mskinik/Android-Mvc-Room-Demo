package com.example.androidmvcroom.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.androidmvcroom.Model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void addUser(User user);


    @Query("SELECT * FROM user_table")
    List<User> getAllUser();

    @Query("DELETE FROM user_table WHERE name=:userName")
    void deleteUser(String userName);

}
