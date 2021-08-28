package com.example.cryptindex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    static String lastValue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.text_view_result);
        fetchData receive = new fetchData();
        receive.execute();

        //lastValue = receive.value;
        //textView.setText(lastValue);
        //textView.setText("Anything"); //WORKS
        // textView.setText(receive.value); //DOES NOT WORK

    }

} // MainAct
