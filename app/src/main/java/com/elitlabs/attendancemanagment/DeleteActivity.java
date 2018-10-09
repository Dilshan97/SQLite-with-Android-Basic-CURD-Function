package com.elitlabs.attendancemanagment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteActivity extends AppCompatActivity {

    private EditText id;
    private Button deleteBtn;
    DatabaseHelper dbHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        dbHelp = new DatabaseHelper(this);

        id = (EditText) findViewById(R.id.id);
        deleteBtn = (Button) findViewById(R.id.deleteBtn);


        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a_id = id.getText().toString();

                if(TextUtils.isEmpty(a_id)){
                    Toast.makeText(DeleteActivity.this, "Please Fill the ID", Toast.LENGTH_SHORT).show();
                    clearAll();
                }else{
                    dbHelp.deleteAttendance(a_id);
                    Toast.makeText(DeleteActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
                    clearAll();
                }
            }
        });
    }

    public void clearAll(){
        id.setText("");
    }
}
