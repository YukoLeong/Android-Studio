package com.example.kanon.kanonmoon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by kanon on 2/1/2016.
 */
public class SQL_DataProvider extends AppCompatActivity {

    private String name;
    private String mob;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SQL_DataProvider(String name, String mob, String email) {
        this.name = name;
        this.mob = mob;
        this.email = email;
    }


}
