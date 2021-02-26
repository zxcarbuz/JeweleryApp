package com.example.jeweleryapp.repository.database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Product {
    @PrimaryKey
    public int pid;

    @ColumnInfo(name = "name")
    public String Name;

    @ColumnInfo(name = "full_Name")
    public String fullName;

    @ColumnInfo(name = "price")
    public String price;

    @ColumnInfo(name = "sale")
    public String sale;

    @ColumnInfo(name = "info")
    public String info;

    @ColumnInfo(name = "identity")
    public String identity;
}