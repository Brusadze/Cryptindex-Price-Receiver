package com.example.cryptindex;

public class Getters {

    public float setPrice;

    public void start() {
        fetchData _fetchData = new fetchData();
        setPrice = _fetchData.x;
        System.out.println("SETPRICE " + setPrice); // Btc price 
    }


}
