package com.example.byhaowlapi;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@CrossOrigin
public class CandlesController {

    @Autowired
    CandlesService candleService;

    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(CandleNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }



    @PostMapping("/candle")
    public ResponseEntity<Candle> createCandle(@RequestBody Candle candle) {
        candleService.addCandle(candle);
        return ResponseEntity.status(HttpStatus.CREATED).body(candle);
    }

    @GetMapping("/candle/random")
    public ResponseEntity<Candle> getRandomCandle() {
        return ResponseEntity.status(HttpStatus.OK).body(candleService.getRandomCandle());
    }
    @GetMapping("/candles")
    public ResponseEntity<List<Candle>> getCandles(@RequestParam(required = false) String candleName, @RequestParam(defaultValue = "100") int limit) {
        return ResponseEntity.status(HttpStatus.OK).body(candleService.getAllCandles(limit));

    }
    @GetMapping("/candleme")
    public ResponseEntity<String> candle() {
        return ResponseEntity.status(HttpStatus.OK).body("I am a candle");
    }

    @GetMapping("/candle/names")
    public ResponseEntity<List<String>> getCandleNames() {
        return ResponseEntity.status(HttpStatus.OK).body(candleService.getCandleNames());
    }

    @PutMapping("/candle/{id}")
    public ResponseEntity<Candle> updateGreeting(@RequestBody Candle newCandle, @PathVariable long id) {
        newCandle.setId(id);
        candleService.updateCandle(newCandle, id);
        return ResponseEntity.status(HttpStatus.OK).body(newCandle);
    }

    @DeleteMapping("/candle/{id}")
    @Transactional
    public ResponseEntity<Void> deleteCandleById(@PathVariable long id) {
        candleService.deleteCandleById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
