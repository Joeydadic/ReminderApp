package edu.qc.seclass.rlm;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Consumer;

import edu.qc.seclass.rlm.dao.DB;
import edu.qc.seclass.rlm.dao.MyListAdapter;
import edu.qc.seclass.rlm.entity.Reminder;
import edu.qc.seclass.rlm.entity.ReminderList;
import edu.qc.seclass.rlm.entity.User;

public class ListAllActivity extends AppCompatActivity {
    AppDatabase db;
    Spinner spinner;
    int userID = -1;
    List<ReminderList> lists;
    List<Reminder> rvList;
    ReminderList reminderList;
    RecyclerView recyclerView;
    MyListAdapter adapter;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_all);
        Intent intent = getIntent();
        userID = intent.getIntExtra("id", 0);
        db = DB.getDB(this);
        User user = db.userDao().getById(userID);
        TextView tv = findViewById(R.id.textView4);
        TextView dateTimeDisplay = findViewById(R.id.textView3);
        tv.setText(user.username);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(Calendar.getInstance().getTime());
        dateTimeDisplay.setText(date);
        spinner = findViewById(R.id.spinner);
        RecyclerView recyclerView = findViewById(R.id.rvView);
        rvList = new ArrayList<>();
        adapter = new MyListAdapter(rvList, integer -> {
            adapter.notifyDataSetChanged();
        }, integer -> {
            Intent in = new Intent(ListAllActivity.this, ReminderActivity.class);
            in.putExtra("reminderId", integer.intValue());
            startActivity(in);
            finish();
        }, db, this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        populateSpinner();
    }

    private void populateRecycleList() {
        rvList.clear();
        if (reminderList != null) {
            for (Reminder reminder : db.reminderDao().getAll()) {
                if (reminder.reminderList == reminderList.id) {
                    rvList.add(reminder);
                }
            }
        }
        adapter.notifyDataSetChanged();
    }

    private void populateSpinner() {
        List<ReminderList> aa = db.reminderListDao().getAll();
        lists = new ArrayList<>();
        for (ReminderList reminderList : aa) {
            if (reminderList.user == userID) {
                lists.add(reminderList);
            }
        }
        String[] ab = new String[lists.size()];
        for (int i = 0; i < lists.size(); i++) {
            ab[i] = lists.get(i).listName;
        }
        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ab);
        spinner.setAdapter(ad);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                reminderList = lists.get(position);
                populateRecycleList();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                reminderList = null;
                populateRecycleList();
            }
        });
        if (lists.size() > 0) {
            populateRecycleList();
        }
    }

    public void addList(View view) {
        LayoutInflater layoutInflaterAndroid = LayoutInflater.from(this);
        View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box, null);
        TextView tv1 = mView.findViewById(R.id.dialogTitle);
        tv1.setText("Enter name of new list");
        AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(this);
        alertDialogBuilderUserInput.setView(mView);
        final EditText userInputDialogEditText = mView.findViewById(R.id.userInputDialog);
        alertDialogBuilderUserInput.setCancelable(false).setPositiveButton("Send", (dialogBox, id) -> {
            createNewList(userInputDialogEditText.getText().toString());
        }).setNegativeButton("Cancel", (dialogBox, id) -> dialogBox.cancel());
        AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
        alertDialogAndroid.show();
    }

    private void createNewList(String listName) {
        ReminderList list = new ReminderList();
        list.user = userID;
        list.listName = listName;
        db.reminderListDao().insert(list);
        populateSpinner();
    }

    public void deleteList(View view) {
        int y = spinner.getSelectedItemPosition();
        db.reminderListDao().delete(lists.get(y));
        populateSpinner();
    }

    public void addReminder(View view) {
        Intent in = new Intent(ListAllActivity.this, ReminderActivity.class);
        in.putExtra("reminderList", reminderList.id);
        startActivity(in);

    }
}