package com.example.workindia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity11 extends AppCompatActivity {
    TextView textView50;
    Button button56;
    String vi,email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);
        final String pos=getIntent().getStringExtra("d");
        final DatabaseReference reff = FirebaseDatabase.getInstance().getReference().child("member");
        reff.child(pos).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                vi = String.valueOf(dataSnapshot.child("job").getValue());
                textView50.setText(vi);
                email = String.valueOf(dataSnapshot.child("email").getValue());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        button56=findViewById(R.id.button56);
        textView50 = findViewById(R.id.textview50);


        button56.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Intent intent= new Intent(MainActivity11.this,MainActivity10.class);
            intent.putExtra("POS",email);
            startActivity(intent);
        }
    });



    }
}