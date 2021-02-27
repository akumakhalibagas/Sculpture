package com.makhalibagas.sculpture.Model.Materi;

import android.os.Parcel;
import android.os.Parcelable;

public class Materi implements Parcelable {

    private String title, pengertian;
    private int gambar;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPengertian() {
        return pengertian;
    }

    public void setPengertian(String pengertian) {
        this.pengertian = pengertian;
    }

    public int getGambar() {
        return gambar;
    }

    public void setGambar(int gambar) {
        this.gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.pengertian);
        dest.writeInt(this.gambar);
    }

    public Materi() {
    }

    protected Materi(Parcel in) {
        this.title = in.readString();
        this.pengertian = in.readString();
        this.gambar = in.readInt();
    }

    public static final Parcelable.Creator<Materi> CREATOR = new Parcelable.Creator<Materi>() {
        @Override
        public Materi createFromParcel(Parcel source) {
            return new Materi(source);
        }

        @Override
        public Materi[] newArray(int size) {
            return new Materi[size];
        }
    };
}
