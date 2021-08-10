package com.example.workindia;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
private Button button,button2;
 private  Dialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








        ConnectivityManager manager=(ConnectivityManager)
            getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetwork=manager.getActiveNetworkInfo();
        if (null!=activenetwork)
        {
            if(activenetwork.getType()==ConnectivityManager.TYPE_WIFI)
            {
                Toast.makeText(this,"Wifi Enabled",Toast.LENGTH_LONG).show();
            }
            if (activenetwork.getType() == ConnectivityManager.TYPE_MOBILE)
            {
                Toast.makeText(this,"Data Network Enabled",Toast.LENGTH_LONG).show();
            }
        }
        else
        {
            Toast.makeText(this,"No Internet Connection",Toast.LENGTH_LONG).show();

        }


        Button button=findViewById(R.id.button);
        Button button2=findViewById(R.id.button2);






        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity1();

            }
        });


    }




    public  void openActivity1()
    {
        Intent intent= new Intent(this,MainActivity2.class);
        startActivity(intent);
    }
    public  void openActivity2()
    {
        Intent intent= new Intent(this,MainActivity3.class);
        startActivity(intent);
    }


}