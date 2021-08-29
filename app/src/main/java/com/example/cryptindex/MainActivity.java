package com.example.cryptindex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {
    public static TextView data;
    public static TextView price;

    public static float oldPrice;
    public static float newPrice;


    private int mInterval = 3000; // 5 seconds by default, can be changed later
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        data = (TextView)findViewById(R.id.text_view_result);
        price = (TextView)findViewById(R.id.textViewPrice);
        /* runs only once
        fetchData receive = new fetchData();
        receive.execute();
        */

        mHandler = new Handler();
        startRepeatingTask();


        //lastValue = receive.value;
        //textView.setText(lastValue);
        //textView.setText("Anything"); //WORKS
        //textView.setText(receive.value); //DOES NOT WORK

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        stopRepeatingTask();
    }
    Runnable mStatusChecker = new Runnable() {
        @Override
        public void run() {
            try {
                updateStatus(); //this function can change value of mInterval.
            } finally {
                // 100% guarantee that this always happens, even if
                // your update method throws an exception
                mHandler.postDelayed(mStatusChecker, mInterval);
            }
        }
    };

    void startRepeatingTask() {
        mStatusChecker.run();
    }
    void stopRepeatingTask() {
        mHandler.removeCallbacks(mStatusChecker);
    }
    void updateStatus(){
        //mInterval = 3000;
        fetchData receive = new fetchData();
        receive.execute();


    }

} // MainAct
