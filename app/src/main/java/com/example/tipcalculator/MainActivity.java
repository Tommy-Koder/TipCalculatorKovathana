package com.example.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText subTotal;
    EditText text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        subTotal = (EditText) findViewById(R.id.num1EditText);
        text2 = (EditText) findViewById(R.id.num2EditText);
        //https://www.youtube.com/watch?v=jxoG_Y6dvU8
        //https://developer.android.com/training/graphics/opengl/touch#listener
        subTotal.setOnClickListener(
                new EditText.OnClickListener(){
                    public void onClick(View v){
                        if(subTotal.length() != 0 && text2.length() != 0)
                            calculate(v);
                    }
                }


        );
    }


    public void calculate(View v) {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");

        //Get references to all elements on app screen
        EditText num1EditText = (EditText) findViewById(R.id.num1EditText);
        EditText num2EditText = (EditText) findViewById(R.id.num2EditText);
        TextView ansTextView = (TextView) findViewById(R.id.ansTextView);
        TextView ans2TextView = (TextView) findViewById(R.id.ans2TextView);


        //Get the values from the EditText boxes and convert them to int data types
        double bill = Double.parseDouble(num1EditText.getText().toString());
        double tip = Double.parseDouble(num2EditText.getText().toString());
        tip /= 100;

        //Add the text for the answer
        double tipAmount = bill * tip;
        double totalBill = bill + tipAmount;

        ansTextView.setText("Tip: $" + df.format(tipAmount));
        ans2TextView.setText("Total Bill: $" + df.format(totalBill));
    }

    // https://stackoverflow.com/questions/11690504/how-to-use-view-ontouchlistener-instead-of-onclick
    /*
    subTotal.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if(event.getAction() == MotionEvent.ACTION_UP){

                // Do what you want
                return true;
            }
            return false;
        }
    });
*/

    /*
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_UP){
            calculate(v);

            return true;
        }
        return false;
    }
   */
}