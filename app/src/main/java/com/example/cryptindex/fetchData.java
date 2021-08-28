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



public  class fetchData extends AsyncTask<Void,Void,Void> {
    public String value = "";
    public float x;
    public String symbol;
    public String price;


    @Override
    protected Void doInBackground(Void... voids) {
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
            this.price = object.get("price").toString();
            System.out.println(object.get("symbol"));
            this.symbol = object.get("symbol").toString();
            System.out.println(x);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;
    }
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);
        MainActivity.data.setText(this.symbol);
        MainActivity.price.setText(this.price);
    }
}