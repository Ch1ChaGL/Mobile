package com.example.a17;

import android.app.Application;

public class MyApp extends Application {
    public String str1;
    public String str2;

    public MyApp(){
        super();
        str1 = "";
        str2 = "";
    }

    public String getStr1() {
        return str1;
    }

    public String getStr2() {
        return str2;
    }

    public void setStr1(String str1) {
        this.str1 = str1;
    }

    public void setStr2(String str2) {
        this.str2 = str2;
    }
}
