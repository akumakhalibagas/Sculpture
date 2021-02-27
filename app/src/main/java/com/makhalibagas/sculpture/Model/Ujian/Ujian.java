package com.makhalibagas.sculpture.Model.Ujian;

import android.os.Parcel;
import android.os.Parcelable;

public class Ujian implements Parcelable {
    private String title, time;

    public Ujian(String title, String time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.time);
    }

    protected Ujian(Parcel in) {
        this.title = in.readString();
        this.time = in.readString();
    }

    public static final Parcelable.Creator<Ujian> CREATOR = new Parcelable.Creator<Ujian>() {
        @Override
        public Ujian createFromParcel(Parcel source) {
            return new Ujian(source);
        }

        @Override
        public Ujian[] newArray(int size) {
            return new Ujian[size];
        }
    };
}
