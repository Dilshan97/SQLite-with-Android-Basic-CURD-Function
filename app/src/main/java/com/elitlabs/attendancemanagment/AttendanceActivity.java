package com.elitlabs.attendancemanagment;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AttendanceActivity extends AppCompatActivity {

    private Button markBtn,viewBtn;
    private EditText name, Class, subject;
    DatabaseHelper dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        dbHelp = new        markBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a_name = name.getText().toString();
                String a_class = Class.getText().toString();
                String a_sub  = subject.getText().toString();

                if(TextUtils.isEmpty(a_name) || TextUtils.isEmpty(a_class) || TextUtils.isEmpty(a_sub)){
                    Toast.makeText(AttendanceActivity.this, "Feilds  Empty", Toast.LENGTH_SHORT).show();
                    clearAll();
                }
                else{
                    dbHelp.insertAttendance(a_name, a_class, a_sub);
                    Toast.makeText(AttendanceActivity.this, "Attendance Successfully Inserted", Toast.LENGTH_SHORT).show();
                    clearAll();
                }
            }
        }) DatabaseHelper(this);
        markBtn = (Button)findViewById(R.id.markBtn);
        viewBtn = (Button)findViewById(R.id.viewBtn);

        name = (EditText)findViewById(R.id.name);
        Class = (EditText)findViewById(R.id.Class);
        subject = (EditText)findViewById(R.id.sub);

;

        viewAll();
    }


    public void clearAll(){
        name.setText("");
        Class.setText("");
        subject.setText("");
    }


    public void viewAll(){
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor rs = dbHelp.getAllData();

                if(rs.getCount() == 0){
                    showMessage("Error", "No Data Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while(rs.moveToNext()){
                    buffer.append("ID      : " + rs.getString(0) + "\n");
                    buffer.append("Name    : " + rs.getString(1) + "\n");
                    buffer.append("Class   : " + rs.getString(2) + "\n");
                    buffer.append("Subject : " + rs.getString(3) + "\n\n");
                }

                showMessage("Data", buffer.toString());
            }
        });
    }


    public void showMessage(String title, String message){
        AlertDialog.Builder  alert = new AlertDialog.Builder(this);
        alert.setCancelable(true);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.show();
    }
}
