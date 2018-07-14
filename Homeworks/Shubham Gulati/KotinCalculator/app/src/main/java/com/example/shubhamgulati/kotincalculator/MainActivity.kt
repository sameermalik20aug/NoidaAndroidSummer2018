package com.example.shubhamgulati.kotincalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var num3=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val plus = btnplus
        val minus = btnminus
        val mult = btnmult
        val div = btndiv
        val n1 = n1
        val n2 = n2
        val result = result

        plus.setOnClickListener {
            var num1 = n1.getText().toString()
            var num3 = num1.toInt()
            Log.e("TAG",""+num3)
            var num2 = n2.getText().toString()
            var num4=num2.toInt()
            var num5 = num3+num4
            Log.e("TAG","RESULT"+num5)
            result.setText(""+num5)

        }
        minus.setOnClickListener {
            var num1 = n1.getText().toString()
            var num3 = num1.toInt()
            var num2 = n2.getText().toString()
            var num4=num2.toInt()
            var num5 = num3-num4
            result.setText(""+num5)

        }
        mult.setOnClickListener {
            var num1 = n1.getText().toString()
            var num3 = num1.toInt()
            var num2 = n2.getText().toString()
            var num4=num2.toInt()
            var num5 = num3*num4
            result.setText(""+num5)

        }
        div.setOnClickListener {
            var num1 = n1.getText().toString()
            var num3 = num1.toInt()
            var num2 = n2.getText().toString()
            var num4=num2.toInt()
            var num5 = num3/num4
            result.setText(""+num5)

        }


    }
}
