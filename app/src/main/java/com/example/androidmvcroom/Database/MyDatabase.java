package com.example.androidmvcroom.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.androidmvcroom.Model.User;

@Database(entities = {User.class} ,version = 1)
public abstract class MyDatabase extends RoomDatabase {
    private final static String DB_NAME="my_db";
    private static MyDatabase INSTANCE;
    public abstract UserDao userDao();

    public static MyDatabase getInstance(Context context)
    {
        if(INSTANCE==null)
        {
            INSTANCE= Room.databaseBuilder(context,MyDatabase.class,DB_NAME).allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
}
