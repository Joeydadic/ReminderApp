package edu.qc.seclass.rlm;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import edu.qc.seclass.rlm.dao.DB;
import edu.qc.seclass.rlm.entity.User;

public class MainActivity extends AppCompatActivity {
    EditText name;
    EditText pass;
    EditText pass2;
    TextView textViewPass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.etUsername);
        pass = findViewById(R.id.editTextTextPassword);
        pass2 = findViewById(R.id.editTextTextPassword2);
        textViewPass2 = findViewById(R.id.ConfirmpasswordTextView);
    }

    public void logIn(View view) {
        String login = name.getText().toString();
        if (login.length() < 2) {
            Toast.makeText(this, "Login must be presented", Toast.LENGTH_SHORT).show();
            return;
        }
        String passS = pass.getText().toString();
        if (passS.length() < 2) {
            Toast.makeText(this, "Password must be presented", Toast.LENGTH_SHORT).show();
            return;
        }
        int id = check(login, passS);
        if (id != -1) {
            Intent intent = new Intent(MainActivity.this, ListAllActivity.class);
            intent.putExtra("id", id);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Loginr or pass is invalid", Toast.LENGTH_SHORT).show();
        }
    }

    public void create(View view) {
        String login = name.getText().toString();
        if (login.length() < 2) {
            Toast.makeText(this, "Login must be presented", Toast.LENGTH_SHORT).show();
            return;
        }
        String passS = pass.getText().toString();
        if (passS.length() < 2) {
            Toast.makeText(this, "Password must be presented", Toast.LENGTH_SHORT).show();
            return;
        }
        String passS2 = pass2.getText().toString();
        if (passS2.length() < 2) {
            Toast.makeText(this, "Password must be presented", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!passS2.equals(passS)) {
            Toast.makeText(this, "Passwords must be equal", Toast.LENGTH_SHORT).show();
            return;
        }
        int id = createUser(login, passS);
        Intent intent = new Intent(MainActivity.this, ListAllActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    private int createUser(String login, String pass) {
        User user = new User();
        user.username = login;
        user.password = pass;
        DB.getDB(this).userDao().insert(user);
        List<User> all = DB.getDB(this).userDao().getAll();
        for (User user2 : all) {
            if (user2.username.equals(login) && user2.password.equals(pass)) {
                return user2.id;
            }
        }
        return 1;
    }

    private int check(String login, String pass) {
        List<User> all = DB.getDB(this).userDao().getAll();
        for (User user : all) {
            if (user.username.equals(login) && user.password.equals(pass)) {
                return user.id;
            }
        }
        return -1;
    }

    public void signIn(View view) {
        pass2.setVisibility(View.VISIBLE);
        textViewPass2.setVisibility(View.VISIBLE);
        Button logIn = findViewById(R.id.button);
        logIn.setVisibility(View.GONE);
        Button create = findViewById(R.id.button2);
        create.setVisibility(View.VISIBLE);
        Button signIn = findViewById(R.id.button3);
        signIn.setVisibility(View.GONE);
    }
}