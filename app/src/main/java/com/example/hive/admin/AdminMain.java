package com.example.hive.admin;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hive.R;

public class AdminMain extends AppCompatActivity {

    TextView txtMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_main);
        txtMain = findViewById(R.id.txtMain);

        Intent intent = getIntent();
        txtMain.setText(intent.getExtras().getString("TextOut") + "@" + intent.getExtras().getString("catagory"));

    }

}