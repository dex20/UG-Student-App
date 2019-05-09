package com.example.d3x.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Devless extends AppCompatActivity {
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devless);
    }
    public void exit(View view){
        Intent intent = new Intent(Devless.this, Php.class);
        startActivity(intent);
    }
}
