package com.example.byhaowlapi;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Candle> getRandomCandle(){
    return ResponseEntity.status(HttpStatus.OK).body(candleService.getRandomCandle());
}

@GetMapping("/candleme")
    public ResponseEntity<String> candle() {
    return ResponseEntity.status(HttpStatus.OK).body("I am a candle");
}
}
