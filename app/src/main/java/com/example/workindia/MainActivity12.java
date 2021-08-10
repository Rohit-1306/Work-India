package com.example.workindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity12 extends AppCompatActivity {

    Button btn;
    TextView txt;
    FirebaseUser user;
    FirebaseAuth fauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main12);
        btn =findViewById(R.id.buttonyash);
        fauth = FirebaseAuth.getInstance();
        String s= getIntent().getStringExtra("Email");
        user=fauth.getCurrentUser();
        txt= findViewById(R.id.textView6);
        if(user.isEmailVerified())
        {
            Toast.makeText(MainActivity12.this,"You have logged in successfully ",Toast.LENGTH_LONG).show();
            Intent intent =new Intent(MainActivity12.this,MainActivity8.class);
            intent.putExtra("email",s);
            startActivity(intent);
        }
        else
        {
            txt.setText("Please verify your email");
        }

            btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity12.this,"Please verify Your email first",Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MainActivity12.this,MainActivity7.class);
                startActivity(intent);
            }
        });
    }
}