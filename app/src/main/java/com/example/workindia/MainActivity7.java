package com.example.workindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ProviderQueryResult;

public class MainActivity7 extends AppCompatActivity {
Button button3;
EditText emailaddress2,textpassword2;
ProgressBar progressbar6;
FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        emailaddress2 = findViewById(R.id.emailaddress2);
        textpassword2 = findViewById(R.id.textpassword2);
        progressbar6 = findViewById(R.id.progressbar6);
        button3=findViewById(R.id.button3);
        fAuth = FirebaseAuth.getInstance();


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
               public void onClick(View v) {
//                String email = emailaddress2.getText().toString().trim();
//                String password = textpassword2.getText().toString().trim();
////                final FirebaseUser user = (FirebaseUser) emailaddress2.getText();
//                if(TextUtils.isEmpty(email)){
//                    emailaddress2.setError("Email is Required.");
//                    return;
//                }
//
//                else if(TextUtils.isEmpty(password)){
//                    textpassword2.setError("Password is Required.");
//                    return;
//                }
//

//                else if(user.isEmailVerified())
//                {
//                    if(password.length() < 6){
//                        textpassword2.setError("Password Must be >= 6 Characters");
//                        return;
//                    }

//                    progressbar6.setVisibility(View.VISIBLE);
//
//                    // authenticate the user
//
//                    fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                        @Override
//                        public void onComplete(@NonNull Task<AuthResult> task) {
//                            if(task.isSuccessful()){
//                                Toast.makeText(MainActivity7.this, "Logged in Successfully", Toast.LENGTH_SHORT).show();
//                                startActivity(new Intent(MainActivity7.this,MainActivity8.class));
//                            }else {
//                                Toast.makeText(MainActivity7.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
//                                progressbar6.setVisibility(View.GONE);
//                            }
//
//                        }
//                    });
//                }
//                else
//                {
//                    Toast.makeText(MainActivity7.this,"Verify email first ",Toast.LENGTH_SHORT).show();
//                    finish();
//                }

                fAuth.fetchProvidersForEmail(emailaddress2.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
                            @Override
                            public void onComplete(@NonNull Task<ProviderQueryResult> task) {
                                boolean check =!task.getResult().getProviders().isEmpty();

                                if(!check)
                                {
                                    Toast.makeText(MainActivity7.this,"Email not found",Toast.LENGTH_LONG).show();
                                }
                                else
                                {
                                    final String email = emailaddress2.getText().toString().trim();
                                    String password = textpassword2.getText().toString().trim();
                                    fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                        @Override
                                        public void onComplete(@NonNull Task<AuthResult> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(MainActivity7.this, "Logged In successfully ", Toast.LENGTH_SHORT).show();
                                                Intent intent = new Intent(MainActivity7.this,MainActivity12.class);
                                                intent.putExtra("Email",email);
                                                startActivity(intent);
                                            }else {
                                                Toast.makeText(MainActivity7.this, "Error ! " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                                progressbar6.setVisibility(View.GONE);
                                            }

                                        }
                                    });
                                }

                            }
                        });
                  }


        });

    }

}