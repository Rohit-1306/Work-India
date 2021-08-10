package com.example.workindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity8 extends AppCompatActivity {
    EditText personname10,textcgpa,textdegree,textjob;
    Button button4;
    DatabaseReference reff;
    Member member;
    long maxid=0;
    Button button79;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);
        personname10=findViewById(R.id.personname10);
        textcgpa=findViewById(R.id.textcgpa);
        textdegree=findViewById(R.id.textdegree);
        textjob=findViewById(R.id.textjob);
        button4=findViewById(R.id.button4);
        member=new Member();
        final String d=getIntent().getStringExtra("email");
        reff= FirebaseDatabase.getInstance().getReference().child("member");


        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                    maxid=  (long) dataSnapshot.getChildrenCount();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Float agea=Float.parseFloat(textcgpa.getText().toString().trim());
                member.setName(personname10.getText().toString().trim());
                member.setEmail(d);
                member.setCgpa(agea);
                member.setName1(textdegree.getText().toString().trim());
                member.setJob(textjob.getText().toString());
                reff.child(String.valueOf(maxid+1)).setValue(member);


                Toast.makeText(MainActivity8.this,"Data pushed Successfully",Toast.LENGTH_LONG).show();
                openActivity89();
            }
        });



    }
    public void openActivity89()
    {
        Intent intent= new Intent(this,MainActivity9.class);
        startActivity(intent);
    }
}