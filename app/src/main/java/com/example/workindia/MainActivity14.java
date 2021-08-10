package com.example.workindia;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity14 extends AppCompatActivity {
    RecyclerView recview;
    myadapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main14);
        recview=findViewById(R.id.recview);
        recview.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<model> options = new FirebaseRecyclerOptions.Builder<model>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("member"), model.class)
                .build();
        adapter=new myadapter(options);
        recview.setAdapter(adapter);
        adapter.setOnItemClickListener(new myadapter.OnItemClickListener() {
            @Override
            public void OnItemClick( int position) {


                Intent  intent = new Intent(getApplicationContext(), MainActivity11.class);
                position++;
                intent.putExtra("d",String.valueOf(position));
                startActivity(intent);
            }
        });



    }




    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
        @Override
    protected void onStop()
    {
        super.onStop();
        adapter.stopListening();
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.logout)
        {
            SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
            SharedPreferences.Editor editor =preferences.edit();
            editor.putString("remember","false");
            editor.apply();
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(getApplicationContext() , MainActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }



    }
