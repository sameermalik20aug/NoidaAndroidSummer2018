package com.example.shubhamgulati.githubapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv;
    Button btnSearch;
    EditText et ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.rv);
        et = findViewById(R.id.et);
        btnSearch = findViewById(R.id.btnSearch);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et.getText().toString();
                String url = "https://api.github.com/search/users?q="+name;
                makeNetworkCall(url);
            }
        });
    }

    private void makeNetworkCall(String url) {
        //make the network call here
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {

            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                final String result = response.body().string();
                Gson gson = new Gson();
                final APIResponse apiResponse = gson.fromJson(result,APIResponse.class);
                MainActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ArrayList<Users> users = apiResponse.getItems();
                        Adapter adapter = new Adapter(users,getBaseContext());
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
                        rv.setLayoutManager(linearLayoutManager);
                        rv.setAdapter(adapter);
                    }
                });

            }
        });
    }
}
