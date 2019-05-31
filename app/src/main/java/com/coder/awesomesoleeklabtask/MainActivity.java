package com.coder.awesomesoleeklabtask;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    ListView listView;
    Button signUpBUt;
    TextView componnetTV;

    public static ArrayList<String> contryNames = new ArrayList<>();
    String url = "https://restcountries.eu/rest/v2/all";
    private com.android.volley.RequestQueue RequestQueue;
    private StringRequest StringRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_View);
                   signUpBUt=findViewById(R.id.btn_signout);
                   componnetTV=findViewById(R.id.componnentTV);
        sendAndRequestResponse()        ;
        signUpBUt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                LoginManager.getInstance();
                   Intent i = new Intent(MainActivity.this , SignInActivity.class);
                startActivity(i);
                 finish();

            }

        });
    }





    private void sendAndRequestResponse() {

        RequestQueue = Volley.newRequestQueue(this);

        StringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                json parser = new json(MainActivity.this);
                contryNames = parser.JSONParser(response.toString());
                ArrayAdapter<String> items = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, contryNames);
                 listView.setAdapter(items);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Volley Request Error", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue.add(StringRequest);
    }

    @Override
    public void onClick(View view) {

    }
}
