package com.example.byhaowlapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CandlesRepository extends JpaRepository<Candle, Long> {

    @Query(value="SELECT * FROM candle ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Candle getRandomCandle();
}
