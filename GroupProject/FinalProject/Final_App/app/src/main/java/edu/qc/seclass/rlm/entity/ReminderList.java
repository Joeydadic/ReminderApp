package edu.qc.seclass.rlm.entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ReminderList {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public int user;
    public String reminderList;
    public String listName;
    public String reminderListType;


}
