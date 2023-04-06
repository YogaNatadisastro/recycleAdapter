package com.example.tugas_3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ProfileActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        TextView nameText = findViewById(R.id.nameTextView);

        String username = "Username not set";

        Bundle extras = getIntent().getExtras();
        if (extras != null){
            username = extras.getString("username");
        }
        nameText.setText(username);
    }
}
