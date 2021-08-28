package com.example.cryptindex;


import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



public  class fetchData extends AsyncTask {
    public String value = "";
    public float x;


    @Override
    public Object doInBackground(Object[] objects) {
        String data = "";


        try {

            URL url = new URL("https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }

            JSONObject object = new JSONObject(data);
            //GETTING FLOAT FROM JSON OBJECT
            float x = BigDecimal.valueOf(object.getDouble("price")).floatValue();

            System.out.println(object.get("symbol"));
            System.out.println(x);

            Getters getters = new Getters();
            getters.start();




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }

    public String getValue(String values) {
        return values;
    }
}