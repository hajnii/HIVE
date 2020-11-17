package com.example.hive.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hive.R;

public class AdminJoinActivity extends AppCompatActivity {

    EditText adminJoinEmail;
    Button btnCertified;

    String TAG = "AAA";

    Spinner emailCategory;
    ArrayAdapter arrayAdapter; // spinner 셋팅용
    String category; // spinnercategory


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_join);
        emailCategory = findViewById(R.id.emailCategory);
        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_email, android.R.layout.simple_spinner_dropdown_item);
        emailCategory.setAdapter(arrayAdapter);

//        AdapterView.OnItemSelectedListener()
        emailCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int categoryType, long l) {
                switch (categoryType) {
                    case 0:
                        Log.i(TAG, Integer.toString(categoryType));
                        category = null;
                        break;
                    case 1:
                        Log.i(TAG, Integer.toString(categoryType));
                        category = "naver.com";
                        break;
                    case 2:
                        Log.i(TAG, Integer.toString(categoryType));
                        category = "gmail.com";
                        break;
                    case 3:
                        Log.i(TAG, Integer.toString(categoryType));
                        category = "hanmail.com";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}