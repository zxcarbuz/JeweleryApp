package com.example.jeweleryapp.repository.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.jeweleryapp.repository.database.dao.ProductDao;
import com.example.jeweleryapp.repository.database.entity.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
}