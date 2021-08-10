package com.example.workindia;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private EditText personname ,emailaddress,textpassword;
     private  Button button5;

    ProgressBar proggressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        personname=findViewById(R.id.personname);
        emailaddress=findViewById(R.id.emailaddress);
        textpassword=findViewById(R.id.textpassword);
        button5=findViewById(R.id.button5);
        personname.addTextChangedListener(loginTextWatcher);
        emailaddress.addTextChangedListener(loginTextWatcher);
        button5.setEnabled(false);

//        textpassword.addTextChangedListener(loginTextWatcher);


        proggressbar=findViewById(R.id.progressbar);

        SharedPreferences preferences = getSharedPreferences("checkbox",MODE_PRIVATE);
        String checkbox = preferences.getString("remember","false");
        if(checkbox.equals("true")){
            Intent intent = new Intent(MainActivity2.this,MainActivity14.class);
            startActivity(intent);
        }
        else if (checkbox.equals("false"))
        {
            Toast.makeText(MainActivity2.this,"Please Sign In",Toast.LENGTH_LONG).show();


        }

button5.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        openActivity3();

    }
});

    }
    private TextWatcher loginTextWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        String username=personname.getText().toString().trim();
        String email =emailaddress.getText().toString().trim();

        button5.setEnabled(!username.isEmpty() && !email.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void openActivity3()
    {

        Intent intent= new Intent(MainActivity2.this,MainActivity4.class);
        startActivity(intent);
    }


}