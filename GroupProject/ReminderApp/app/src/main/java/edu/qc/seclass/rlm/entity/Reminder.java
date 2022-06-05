package edu.qc.seclass.rlm.entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Reminder {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String reminderType;
    public int reminderList;
    public String reminderName;
}
