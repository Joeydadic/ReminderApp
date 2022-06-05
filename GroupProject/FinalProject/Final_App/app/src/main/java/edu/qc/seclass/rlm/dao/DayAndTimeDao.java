package edu.qc.seclass.rlm.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.qc.seclass.rlm.entity.DayAndTime;
@Dao
public interface DayAndTimeDao {
    @Query("SELECT * FROM dayAndTime")
    List<DayAndTime> getAll();

    @Query("SELECT * FROM dayAndTime WHERE id = :id")
    DayAndTime getById(long id);

    @Insert
    void insert(DayAndTime dayAndTime);

    @Update
    void update(DayAndTime dayAndTime);

    @Delete
    void delete(DayAndTime dayAndTime);
}