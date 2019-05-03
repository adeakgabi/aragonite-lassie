package com.example.lassie;

import android.app.DownloadManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue;
    private StringRequest stringRequest;
    Button registerBtn;
    String url = "https://boiling-ravine-27273.herokuapp.com/register";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        registerBtn = (Button) findViewById(R.id.registerButton);

//        FloatingActionButton fab = findViewById(R.id.fab);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               sendRegisterRequest();
            }
        });
    }

    private void sendRegisterRequest(){
        mRequestQueue = Volley.newRequestQueue(this);
        EditText username = (EditText) findViewById(R.id.username);
        EditText password = (EditText) findViewById(R.id.username);
        final String usernameData = username.getText().toString();
        final String passwordData = password.getText().toString();
        stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("Response", response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error" , error.toString());
            }
        }) {
            @Override
            public  Map<String, String> getParams(){
                Map<String, String> params = new HashMap<>();
                params.put("username", usernameData);
                params.put("password", passwordData);
                return params;
            }

            @Override
            public  Map<String, String> getHeaders(){
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                return params;
            }
        };
        mRequestQueue.add(stringRequest);
    }

}
