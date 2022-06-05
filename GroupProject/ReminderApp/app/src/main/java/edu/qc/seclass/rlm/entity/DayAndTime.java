package edu.qc.seclass.rlm.entity;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class DayAndTime {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String date;
    public long time;
}
