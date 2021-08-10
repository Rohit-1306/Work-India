package com.example.workindia;
import android.app.Dialog;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.workindia.R;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity10 extends AppCompatActivity {

    private EditText mEditTextSubject;
    private EditText mEditTextMessage;
    private String[] value;
    private Dialog dialog;
    private Button okay;
    Button button99;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main10);
        dialog =new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog2);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations= R.style.animation;

        button99=findViewById(R.id.button99);
        value= new String[]{String.valueOf(getIntent().getStringExtra("POS"))};

        mEditTextSubject = findViewById(R.id.edit_text_subject);
        mEditTextMessage = findViewById(R.id.edit_text_message);
        Button okay = dialog.findViewById(R.id.okay);
        Button buttonSend = findViewById(R.id.button_send);
        button99.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor =preferences.edit();
                editor.putString("remember","false");
                editor.apply();
                dialog.show();
            }
        });

        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMail();
            }
        });
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext() , MainActivity.class));
                finish();
            }
        });

    }
        private void sendMail() {


            String subject = mEditTextSubject.getText().toString();
            String message = mEditTextMessage.getText().toString();
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL,value);
            intent.putExtra(Intent.EXTRA_SUBJECT, subject);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            intent.setType("message/rfc822");
            startActivity(Intent.createChooser(intent, "Choose an email client"));
    }


}
