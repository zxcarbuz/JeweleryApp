package com.example.jeweleryapp.repository.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey(autoGenerate = true)
    public int pid;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "full_Name")
    public String fullName;

    @ColumnInfo(name = "price")
    public double price;

    @ColumnInfo(name = "sale")
    public double sale;

    @ColumnInfo(name = "info")
    public String info;

    @ColumnInfo(name = "identity")
    public String identity;
    public String url;
}