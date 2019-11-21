package com.danielanomfueme.danieldating.Util;

import android.net.Uri;

import com.danielanomfueme.danieldating.R;
import com.danielanomfueme.danieldating.models.User;

public class Users {
    public User[] USERS = {
            Daniel, Angel, Curry, p4, p6
    };


    /*
            Men
     */
    public static final User Daniel = new User(Uri.parse("android.resource://com.danielanomfueme.danieldating/" + R.drawable.daniel).toString(),
         "Daniel", "Male","Female", "Looking");

    public static final User Curry = new User(Uri.parse("android.resource://com.danielanomfueme.danieldating/" + R.drawable.curry).toString(),
            "Curry", "Male", "Female", "Looking");

    public static final User p6 = new User(Uri.parse("android.resource://com.danielanomfueme.danieldating/" + R.drawable.p6).toString(),
            "Jiraya", "Male", "Oppai", "Looking for Tsunade");


    /*
            Females
     */


    public static final User Angel = new User(Uri.parse("android.resource://com.danielanomfueme.danieldating/" + R.drawable.angel).toString(),
            "Angel", "Female","Male", "Looking");
    public static final User p4 = new User(Uri.parse("android.resource://com.danielanomfueme.danieldating/" + R.drawable.p4).toString(),
            "Phone", "Binary","Male and Female", "Need an Owner");

}
