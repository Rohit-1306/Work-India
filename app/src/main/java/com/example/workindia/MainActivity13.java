package com.example.workindia;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity13 extends AppCompatActivity {
private  String[] value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main13);
        final EditText edittextmsg;
        Button button88;
        value= new String[]{"yasharth.singh.cd.mat19@itbhu.ac.in"};
        button88=findViewById(R.id.button88);
        edittextmsg=findViewById(R.id.edittextmsg);
        button88.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = edittextmsg.getText().toString();
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,value);
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback");
                intent.putExtra(Intent.EXTRA_TEXT, message);
                intent.setType("message/rfc822");
                startActivity(Intent.createChooser(intent, "Choose an email client"));
            }
        });
    }
}