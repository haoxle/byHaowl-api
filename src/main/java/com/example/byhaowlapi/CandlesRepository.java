package com.example.byhaowlapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CandlesRepository extends JpaRepository<Candle, Long> {

    @Query(value = "SELECT * FROM candle ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Candle getRandomCandle();

    @Query(value = "SELECT DISTINCT name FROM candle ", nativeQuery = true)
    List<String> getCandleNames();

    void deleteCandleById(long id);
}
