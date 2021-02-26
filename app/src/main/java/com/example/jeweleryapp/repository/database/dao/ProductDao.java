package com.example.jeweleryapp.repository.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.jeweleryapp.repository.database.entity.Product;

import java.util.List;

@Dao
public interface ProductDao {
    @Query("SELECT * FROM product")
    LiveData<List<Product>> getAll();

    @Query("SELECT * FROM product WHERE pid == :productId")
    LiveData<Product> findViewById(int productId);

    @Insert
    void insertAll(Product... products);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product product);

    @Delete
    void delete(Product product);
}
