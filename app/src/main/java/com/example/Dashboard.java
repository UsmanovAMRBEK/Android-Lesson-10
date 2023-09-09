package com.example;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.android_lesson_10.R;

public class Dashboard extends AppCompatActivity {

    TextView tvResult;
    Button btnLogOut;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initUI();
        getTextIntents();
    }
    private void initUI() {
        tvResult = findViewById(R.id.tv_result);
        btnLogOut = findViewById(R.id.btn_logout);
        sharedPreferences = getSharedPreferences("shared1", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        onClicks();
    }
    private void getTextIntents() {
        Intent intent = getIntent();
//        String email = intent.getStringExtra("user_email");
//        String password = intent.getStringExtra("user_password");
//        String firstName = intent.getExtras().get("user_fname").toString();
//        String lastName = intent.getStringExtra("user_fname");
        String email = sharedPreferences.getString("email", "");
        String password = sharedPreferences.getString("password", "");
        String res = "\nEmail: " + email + "\nPassword: " + password;
        tvResult.setText(res);
    }
    private void onClicks() {
        btnLogOut.setOnClickListener(view -> {
            editor.putBoolean("isLoggedIn", false);
            editor.commit();
            Intent intent = new Intent(Dashboard.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

}