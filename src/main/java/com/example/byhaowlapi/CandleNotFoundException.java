package com.example.byhaowlapi;

public class CandleNotFoundException extends RuntimeException{
    public CandleNotFoundException() {
        super("Candle not found");
    }
}
