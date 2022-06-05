package edu.qc.seclass.rlm.dao;
import android.content.Context;

import androidx.room.Room;

import edu.qc.seclass.rlm.AppDatabase;

public class DB {
    private static AppDatabase database;

    private DB() {
    }

    public static AppDatabase getDB(Context context) {
        if (database == null) {
            database = Room.databaseBuilder(context, AppDatabase.class, "databaseTemp5").allowMainThreadQueries().build();
        }
        return database;
    }
}
