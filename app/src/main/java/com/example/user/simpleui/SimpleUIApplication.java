package com.example.user.simpleui;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by user on 2016/6/23.
 */
public class SimpleUIApplication extends Application {
    //輸入小寫on選Create
    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Order.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                        .applicationId("Hw9aA6CM8oj9GhLBVhs0gVu3Ok6QaWMHHy3L5uzE")
                        .server("https://parseapi.back4app.com/")
                        .clientKey("IuAnsRIkrNLy0cVRDJ87eEtKpcleTIqpdG2XNVgQ")
                        .enableLocalDataStore()
                        .build()
        );
    }
}
