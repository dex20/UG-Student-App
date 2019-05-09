package com.example.d3x.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText username,password;
    final String userString ="prince";
    final String passString ="1111";
    String userVer,passVer;
    Button login,button2, button3;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username =findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        login = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        txt = findViewById(R.id.textview);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Devless.class);
                startActivity(intent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Php.class);
                startActivity(intent);
            }
        });
    }



    public void VerifyLogin(View view){
        userVer = username.getText().toString().trim();
        passVer = password.getText().toString().trim();
     if (userVer.trim().equals("prince") && passVer.trim().equals("1111")){
            Toast.makeText(this, "User Verified", Toast.LENGTH_SHORT).show();
            txt.setText("Username is: "+ userString + "\n" + " Password is : " + passString);
        }
        else {
            Toast.makeText(this, "User not verified", Toast.LENGTH_SHORT).show();
            txt.setText("Wrong Credential");
        }
    }
}
