package com.example.shubhamgulati.recyclerview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et;
    Button add;
    ArrayList<data> d ;
    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et = findViewById(R.id.et);
        add = findViewById(R.id.add);
        d = new ArrayList<>(20);
        final customAdapter ca = new customAdapter(this,d);
        rv = findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(ca);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String note = et.getText().toString();
                Log.e("tag", note);
                d.add(new data(note));
                ca.notifyDataSetChanged();
                et.setText("");
            }
        });
    }
}
