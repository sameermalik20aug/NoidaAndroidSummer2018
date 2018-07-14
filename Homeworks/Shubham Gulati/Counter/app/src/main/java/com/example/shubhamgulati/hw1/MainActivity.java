package com.example.shubhamgulati.hw1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void increment(View view){
        EditText editText = findViewById(R.id.editText);
        TextView lb = findViewById(R.id.lb);
        int num = Integer.parseInt(String.valueOf(editText.getText()));
        num=num+1;

        lb.setText(""+num);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
