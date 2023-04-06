package com.example.tugas_3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private recycleAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recylerView);
        usersList = new ArrayList<>();
        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListner();
        recycleAdapter adapter = new recycleAdapter (usersList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListner() {
        listener = new  recycleAdapter.RecyclerViewClickListener(){
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("username", usersList.get(position).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        usersList.add(new User("Firly"));
        usersList.add(new User("Yoga"));
        usersList.add(new User("Najem"));
        usersList.add(new User("Nanda"));
        usersList.add(new User("Ucul"));
    }
}