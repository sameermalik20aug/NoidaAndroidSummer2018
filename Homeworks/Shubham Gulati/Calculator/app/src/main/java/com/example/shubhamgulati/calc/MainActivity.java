package com.example.shubhamgulati.calc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText num1;
    EditText num2;
    TextView label;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        label = findViewById(R.id.label);
    }

    public void compute(View view) {
        int n1,n2,n3;
        switch(view.getId()){


            case R.id.btnplus:
                n1=Integer.parseInt(String.valueOf(num1.getText()));
                n2=Integer.parseInt(String.valueOf(num2.getText()));
                n3=n1+n2;
                label.setText(""+n3);
                break;

            case R.id.btnminus:
                n1=Integer.parseInt(String.valueOf(num1.getText()));
                n2=Integer.parseInt(String.valueOf(num2.getText()));
                n3=n1-n2;
                label.setText(""+n3);
                break;

            case R.id.btnmultiply:
                n1=Integer.parseInt(String.valueOf(num1.getText()));
                n2=Integer.parseInt(String.valueOf(num2.getText()));
                n3=n1*n2;
                label.setText(""+n3);
                break;

            case R.id.btndivide:
                n1=Integer.parseInt(String.valueOf(num1.getText()));
                n2=Integer.parseInt(String.valueOf(num2.getText()));
                if(n2==0){
                    label.setText("Cannot divide by 0");
                }
                else {
                n3=n1/n2;
                label.setText(""+n3);}
                break;

            case R.id.clear:
                num1.setText("");
                num2.setText("");
                label.setText("");
                break;
        }
    }
}
