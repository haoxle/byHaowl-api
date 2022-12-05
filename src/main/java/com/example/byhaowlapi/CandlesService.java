package com.example.byhaowlapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandlesService {
    @Autowired
    CandlesRepository candlesRepository;

    public void addCandle(Candle candle) {
        candlesRepository.save(candle);
    }

    public Candle getCandleById(long id){
        Optional<Candle> candle = candlesRepository.findById(id);
        if(candle.isEmpty()) {
            throw new CandleNotFoundException();
        }
        return candle.get();
    }

    public Candle getRandomCandle(){
        return candlesRepository.getRandomCandle();
    }


}
