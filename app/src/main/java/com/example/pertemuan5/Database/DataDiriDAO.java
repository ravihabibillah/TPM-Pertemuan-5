package com.example.pertemuan5.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DataDiriDAO {
    @Insert
    Long insert(DataDiri dataDiri);

    @Query("Select * from data_db")
    List<DataDiri> getData();

    @Update
    int update(DataDiri item);

    @Delete
    void delete(DataDiri item);
}
