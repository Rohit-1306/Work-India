package com.example.workindia;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class MainActivity15 extends AppCompatActivity {
TextView jobdes;
     private  String vi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main15);
        jobdes=findViewById(R.id.jobdes);

        final String pos=getIntent().getStringExtra("d");
        Log.d("hello", "onCreate: "+pos);

        final DatabaseReference reff= FirebaseDatabase.getInstance().getReference().child("member");
        reff.child(pos).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                vi = String.valueOf(dataSnapshot.child("job").getValue());
                jobdes.setText(vi);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }

}