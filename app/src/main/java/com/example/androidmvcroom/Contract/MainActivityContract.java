package com.example.androidmvcroom.Contract;

import android.content.Context;

import com.example.androidmvcroom.Model.User;

import java.util.List;

public interface MainActivityContract {
    interface View{
        void define();
        void click();
        void getAllUser(List<User> userList);
    }
    interface Presenter{
        void start(Context context);
        void setModel(User user);
        void add(String name,int number);
        void delete(String name);
        void list();
    }
}
