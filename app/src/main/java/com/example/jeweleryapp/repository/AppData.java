package com.example.jeweleryapp.repository;

import android.content.Context;
import android.widget.ImageView;

import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.jeweleryapp.R;
import com.example.jeweleryapp.repository.database.AppDatabase;

public class AppData {
    public static final String ID = "id";

    private static AppData instance;

    public AppDatabase db;

    public RequestManager glide;
    private AppData(Context context) {
        db = Room.databaseBuilder(context, AppDatabase.class, "database-name")
                .allowMainThreadQueries().build();
        glide = Glide.with(context);
    }

    public static AppData getInstance(Context context) {
     if (instance == null)
         instance = new AppData(context);
     return instance;
    }

    public void loadImage(String url, ImageView imageView)
    {
        glide.load(url).diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(imageView);
    }
}
