package com.danielanomfueme.danieldating.models;


import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 1/21/2018.
 */

public class Messages implements Parcelable{

    private User user;
    private String message;

    public Messages(User user, String message) {
        this.user = user;
        this.message = message;
    }

    public Messages() {

    }

    protected Messages(Parcel in) {
        user = in.readParcelable(User.class.getClassLoader());
        message = in.readString();
    }

    public static final Creator<Messages> CREATOR = new Creator<Messages>() {
        @Override
        public Messages createFromParcel(Parcel in) {
            return new Messages(in);
        }

        @Override
        public Messages[] newArray(int size) {
            return new Messages[size];
        }
    };

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "user=" + user +
                ", message='" + message + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(user, i);
        parcel.writeString(message);
    }
}