package edu.qc.seclass.rlm.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import edu.qc.seclass.rlm.entity.ReminderList;
@Dao
public interface ReminderListDao {
    @Query("SELECT * FROM reminderList")
    List<ReminderList> getAll();

    @Query("SELECT * FROM reminderList WHERE id = :id")
    ReminderList getById(long id);

    @Insert
    void insert(ReminderList reminderList);

    @Update
    void update(ReminderList reminderList);

    @Delete
    void delete(ReminderList reminderList);
}