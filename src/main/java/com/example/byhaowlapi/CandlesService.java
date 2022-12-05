package com.example.byhaowlapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandlesService {
    @Autowired
    CandlesRepository candlesRepository;

    public void addCandle(Candle candle) {
        candlesRepository.save(candle);
    }

    public Candle getCandleById(long id) {
        Optional<Candle> candle = candlesRepository.findById(id);
        if (candle.isEmpty()) {
            throw new CandleNotFoundException();
        }
        return candle.get();
    }

    public Candle getRandomCandle() {
        return candlesRepository.getRandomCandle();
    }

    public List<String> getCandleNames() {
        return candlesRepository.getCandleNames();
    }

    public List<Candle> getAllCandles(int limit) {
        return candlesRepository.findAll().stream().limit(limit).collect(Collectors.toList());
    }

    public void updateCandle(Candle newCandle, long id) {
        if (!candlesRepository.existsById(id)) {
            throw new CandleNotFoundException();
        }
        newCandle.setId(id);
        candlesRepository.save(newCandle);
    }

    @Transactional
    public void deleteCandleById(long id) {
        if (!candlesRepository.existsById(id)) {
            throw new CandleNotFoundException();
        }
        candlesRepository.deleteCandleById(id);
    }
}
