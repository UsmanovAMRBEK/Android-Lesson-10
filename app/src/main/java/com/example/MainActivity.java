package com.example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android_lesson_10.R;

public class MainActivity extends AppCompatActivity {
    EditText etEmail;
    EditText etPassword;
    AppCompatButton btnLogin;
    TextView tvSingUp;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        onClicks();
    }
    private void initUI() {
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        tvSingUp = findViewById(R.id.tv_singup);
        sharedPreferences = getSharedPreferences("shared1", MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    private void onClicks() {
        btnLogin.setOnClickListener(view -> {

            editor.putString("email", etEmail.getText().toString());
            editor.putString("password", etPassword.getText().toString());
            editor.putBoolean("isLoggedIn", true);
            editor.commit();
            Intent intent = new Intent(MainActivity.this, Dashboard.class);
            startActivity(intent);

        });
        tvSingUp.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SingUp.class);
            startActivity(intent);
            finish();
        });
    }
}