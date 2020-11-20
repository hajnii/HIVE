package com.example.hive.admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.hive.R;

public class AdminJoin extends AppCompatActivity {

    EditText adminJoinEmail;
    Button btnCertified;
    Button btnAdminJoin;

    String TAG = "AAA";

    Spinner emailCategory;
    ArrayAdapter arrayAdapter; // spinner 셋팅용
    String category; // spinnercategory


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_join);
        emailCategory = findViewById(R.id.emailCategory);
        btnAdminJoin = findViewById(R.id.btnAdminJoin);
        adminJoinEmail = findViewById(R.id.adminJoinEmail);

        arrayAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_email, android.R.layout.simple_spinner_dropdown_item);
        emailCategory.setAdapter(arrayAdapter);


        // 이메일Text 영문 키보드로 키우기
        adminJoinEmail.setPrivateImeOptions("defaultInputmode=english;");



        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(adminJoinEmail, 0); // 키보드 보이기
//        imm.hideSoftInputFromWindow(adminJoinEmail.getWindowToken(),0); 키보드 숨기기 ex)검색버튼 눌릴 시 사용

//        AdapterView.OnItemSelectedListener()
        emailCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int categoryType, long l) {
                switch (categoryType) {
                    case 0:
                        Log.i(TAG, Integer.toString(categoryType));
                        category = "naver.com";
                        break;
                    case 1:
                        Log.i(TAG, Integer.toString(categoryType));
                        category = "gmail.com";
                        break;
                    case 2:
                        Log.i(TAG, Integer.toString(categoryType));
                        category = "hanmail.com";
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//        btnCertified.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });



        btnAdminJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i = new Intent(AdminJoin.this,AdminMain.class);

                i.putExtra("TextOut", adminJoinEmail.getText().toString());
                i.putExtra("catagory", category);
                startActivity(i);
            }
        });



    }
}