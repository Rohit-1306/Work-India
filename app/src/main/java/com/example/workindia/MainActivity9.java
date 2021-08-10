package com.example.workindia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity9 extends AppCompatActivity {
    private Dialog dialog;
    private Button okay,cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);
        dialog =new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog2);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations= R.style.animation;
        Toast.makeText(MainActivity9.this,"Please Give Feedback  ",Toast.LENGTH_LONG).show();
        Button button49;
        Button okay =dialog.findViewById(R.id.okay);
        Button cancel = dialog.findViewById(R.id.cancel);
        button49=findViewById(R.id.button49);
        Button button19;
        button19=findViewById(R.id.button19);
        button49.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              dialog.show();
            }
        });
        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity9.this,MainActivity13.class);
                startActivity(intent);

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

}
