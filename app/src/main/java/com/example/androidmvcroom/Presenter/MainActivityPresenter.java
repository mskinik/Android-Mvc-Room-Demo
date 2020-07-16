package com.example.androidmvcroom.Presenter;

import android.content.Context;

import com.example.androidmvcroom.Contract.MainActivityContract;
import com.example.androidmvcroom.Database.MyDatabase;
import com.example.androidmvcroom.Model.User;
import com.example.androidmvcroom.Database.UserDao;

public class MainActivityPresenter implements MainActivityContract.Presenter {
    MainActivityContract.View view;
    private User user;
    MyDatabase myDatabase;
    UserDao userDao;
    public MainActivityPresenter(MainActivityContract.View view) {
        this.view=view;
    }

    @Override
    public void start(Context context) {
        myDatabase=MyDatabase.getInstance(context);
        view.define();
        view.click();
    }

    @Override
    public void setModel(User user) {
        this.user=user;
    }

    @Override
    public void add(String name,int number) {
        userDao=myDatabase.userDao();
        user.setName(name);
        user.setUserNo(number);
        userDao.addUser(user);



    }

    @Override
    public void delete(String name) {
        userDao.deleteUser(name);

    }

    @Override
    public void list() {
        userDao=myDatabase.userDao();
        view.getAllUser(userDao.getAllUser());


    }
}
