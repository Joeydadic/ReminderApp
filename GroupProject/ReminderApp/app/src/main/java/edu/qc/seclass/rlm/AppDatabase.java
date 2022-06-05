package edu.qc.seclass.rlm;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import edu.qc.seclass.rlm.dao.DayAndTimeDao;
import edu.qc.seclass.rlm.dao.ReminderDao;
import edu.qc.seclass.rlm.dao.ReminderListDao;
import edu.qc.seclass.rlm.dao.UserDao;
import edu.qc.seclass.rlm.entity.DayAndTime;
import edu.qc.seclass.rlm.entity.Reminder;
import edu.qc.seclass.rlm.entity.ReminderList;
import edu.qc.seclass.rlm.entity.User;

@Database(entities = {DayAndTime.class, Reminder.class, ReminderList.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract DayAndTimeDao dayAndTimeDao();

    public abstract ReminderDao reminderDao();

    public abstract ReminderListDao reminderListDao();

    public abstract UserDao userDao();
}