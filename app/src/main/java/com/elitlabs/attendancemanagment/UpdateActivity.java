package com.elitlabs.attendancemanagment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {

    private EditText id, name, Class, sub;
    private Button updateBtn;

    DatabaseHelper dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        dbHelp = new DatabaseHelper(this);

        id = (EditText)findViewById(R.id.id);
        name = (EditText)findViewById(R.id.name);
        Class = (EditText)findViewById(R.id.Class);
        sub = (EditText)findViewById(R.id.sub);

        updateBtn = (Button)findViewById(R.id.updateBtn);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a_id = id.getText().toString();
                String a_name = name.getText().toString();
                String a_Class = Class.getText().toString();
                String a_sub = sub.getText().toString();

                if(TextUtils.isEmpty(a_id) || TextUtils.isEmpty(a_name) || TextUtils.isEmpty(a_Class) || TextUtils.isEmpty(a_sub)){
                    Toast.makeText(UpdateActivity.this, "Please Fill the Text Feilds", Toast.LENGTH_SHORT).show();
                    clearAll();
                }
                else{
                    dbHelp.updateAttendance(a_id, a_name, a_Class, a_sub);
                    Toast.makeText(UpdateActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                    clearAll();
                }
            }
        });

    }

    public void clearAll(){
        id.setText("");
        name.setText("");
        Class.setText("");
        sub.setText("");
    }
}
