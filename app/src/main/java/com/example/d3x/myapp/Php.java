package com.example.d3x.myapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Php extends AppCompatActivity implements View.OnClickListener {
    public static final String LOGIN_URL = "https://dexhost.000webhostapp.com/000login.php";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    EditText etuser, etpass;
    TextView txtlogin;
    TextView etText;
    TextView reset;
    private String username, password;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_php);
        etuser = findViewById(R.id.etuser);
        etpass = findViewById(R.id.etpass);
        txtlogin = findViewById(R.id.txt_login);
        progressDialog = new ProgressDialog(this);
        txtlogin.setOnClickListener(this);
    }

    private void userlogin() {
        progressDialog.setTitle("Logging In...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        username = etuser.getText().toString().trim();
        password = etpass.getText().toString().trim();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, LOGIN_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response.trim().equals("success")) {
                            progressDialog.dismiss();
                            openProfile();

                        } else {
                            progressDialog.dismiss();
                            Toast.makeText(Php.this, "Wrong Credentials", Toast.LENGTH_SHORT).show();

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Toast.makeText(Php.this, "Error Logging in, Please check your internet connection.", Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put(KEY_USERNAME, username);
                map.put(KEY_PASSWORD, password);
                return map;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void openProfile() {
        Intent intent = new Intent(Php.this, Devless.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.txt_login:
                userlogin();
                break;
        }
    }
}
