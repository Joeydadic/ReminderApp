package edu.qc.seclass.rlm;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import edu.qc.seclass.rlm.dao.DB;
import edu.qc.seclass.rlm.entity.DayAndTime;
import edu.qc.seclass.rlm.entity.Reminder;

public class ReminderActivity extends AppCompatActivity {
    TextView date;
    TextView time;
    Calendar dateAndTime = Calendar.getInstance();
    int reminderListid;
    int OwnId;
    Reminder rem;
    DayAndTime dat;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        date = findViewById(R.id.textView9);
        time = findViewById(R.id.textView10);
        Intent intent = getIntent();
        db = DB.getDB(this);
        reminderListid = intent.getIntExtra("reminderList", -1);
        if (reminderListid == -1) {
            OwnId = intent.getIntExtra("reminderId", -1);
            rem = db.reminderDao().getById(OwnId);
            dat = db.dayAndTimeDao().getById(rem.reminderTime);
            date.setText(dat.date);
            time.setText(dat.time);
        }
    }

    public void setDate(View view) {
        new DatePickerDialog(ReminderActivity.this, d, dateAndTime.get(Calendar.YEAR), dateAndTime.get(Calendar.MONTH), dateAndTime.get(Calendar.DAY_OF_MONTH)).show();
    }

    public void setTime(View v) {
        new TimePickerDialog(ReminderActivity.this, t, dateAndTime.get(Calendar.HOUR_OF_DAY), dateAndTime.get(Calendar.MINUTE), true).show();
    }

    // установка начальных даты и времени
    private void setInitialDateTime() {
        date.setText(new SimpleDateFormat("MM/dd/yyyy").format(dateAndTime.getTime()));
        time.setText(new SimpleDateFormat("hh:mm").format(dateAndTime.getTime()));
    }

    TimePickerDialog.OnTimeSetListener t = (view, hourOfDay, minute) -> {
        dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
        dateAndTime.set(Calendar.MINUTE, minute);
        setInitialDateTime();
    };
    DatePickerDialog.OnDateSetListener d = (view, year, monthOfYear, dayOfMonth) -> {
        dateAndTime.set(Calendar.YEAR, year);
        dateAndTime.set(Calendar.MONTH, monthOfYear);
        dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        setInitialDateTime();
    };

    public void process(View view) {
        EditText tx = findViewById(R.id.editTextTextPersonName);
        if (rem == null) {
            Reminder reminder = new Reminder();
            reminder.reminderName = tx.getText().toString();
            reminder.reminderList = reminderListid;
            DayAndTime dt = new DayAndTime();
            dt.time = time.getText().toString();
            dt.date = date.getText().toString();
            db.dayAndTimeDao().insert(dt);
            for (DayAndTime dayAndTime2 : db.dayAndTimeDao().getAll()) {
                if (dayAndTime2.date.equals(dt.date) && (dayAndTime2.time.equals(dt.time))) {
                    reminder.reminderTime = dayAndTime2.id;
                }
            }
            db.reminderDao().insert(reminder);
        } else {
            rem.reminderName = tx.getText().toString();
            db.reminderDao().update(rem);
            dat.time = time.getText().toString();
            dat.date = date.getText().toString();
            db.dayAndTimeDao().update(dat);
        }
        finish();
    }
}