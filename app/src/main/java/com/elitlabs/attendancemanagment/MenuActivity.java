package com.elitlabs.attendancemanagment;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public Button newBtn, updateBtn, deleteBtn, viewBtn;
    DatabaseHelper dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        newBtn = (Button)findViewById(R.id.newBtn);
        updateBtn = (Button)findViewById(R.id.updateBtn);
        viewBtn = (Button)findViewById(R.id.viewBtn);
        deleteBtn = (Button)findViewById(R.id.deleteBtn);

        newBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, AttendanceActivity.class));
            }
        });


        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, UpdateActivity.class));
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuActivity.this, DeleteActivity.class));
            }
        });


    }

}
