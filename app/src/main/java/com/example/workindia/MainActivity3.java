package com.example.workindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity3 extends AppCompatActivity {
Button button6,button7;
TextView personname1,emailaddress1,textpassword1;
ProgressBar progressbar1;
FirebaseAuth fauth;
private Button okay,cancel;
private Dialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dialog =new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){

            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations= R.style.animation;
        personname1=findViewById(R.id.personame1);
        emailaddress1=findViewById(R.id.emailaddress1);
        textpassword1=findViewById(R.id.textpassword1);
        button6=findViewById(R.id.button6);

        Button okay =dialog.findViewById(R.id.okay);
        Button cancel = dialog.findViewById(R.id.cancel);
        progressbar1=findViewById(R.id.progressbar1);
        fauth= FirebaseAuth.getInstance();


        button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });


        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email=emailaddress1.getText().toString().trim();
                String password =textpassword1.getText().toString().trim();
                if(TextUtils.isEmpty(email)) {
                    emailaddress1.setError("Email is required");
                    return;

                }
                if(TextUtils.isEmpty(password)){
                    textpassword1.setError("Password is required ");
                    return;
                }
                if(password.length()  <6){
                    textpassword1.setError("Password must be greater or equal  to 6 character ");
                    return;
                }

                progressbar1.setVisibility(View.VISIBLE);
                fauth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser fuser=fauth.getCurrentUser();
                            fuser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    Toast.makeText(MainActivity3.this,"Verification Email Has Been Sent ",Toast.LENGTH_SHORT).show();
                                }
                            });
                            Toast.makeText(MainActivity3.this,"User Created",Toast.LENGTH_SHORT).show();


                        }
                        else
                        {
                            Toast.makeText(MainActivity3.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }

                });
                dialog.show();




            }
        });

    }
    public void openActivity5()
    {
        Intent intent= new Intent(MainActivity3.this,MainActivity7.class);
        startActivity(intent);
    }


}