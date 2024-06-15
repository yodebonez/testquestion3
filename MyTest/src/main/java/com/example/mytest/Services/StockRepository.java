package com.example.mytest.Services;


import com.example.mytest.Models.Stock;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class StockRepository {

    private List<Stock> stocks = new ArrayList<>();
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());

    public StockRepository() {
        // Initialize with some dummy data
        stocks.add(new Stock(1L, "AAPL", new BigDecimal("150.00"),   timestamp, timestamp2 ));
        stocks.add(new Stock(2L, "GOOGL", new BigDecimal("2800.00"), new Timestamp(System.currentTimeMillis()), new Timestamp(System.currentTimeMillis())));
    }



    public List<Stock> findAll() {
        return stocks;
    }

    public Optional<Stock> findById(Long id) {
        return stocks.stream().filter(stock -> stock.getId().equals(id)).findFirst();
    }

    public Stock save(Stock stock) {
        stocks.add(stock);
        return stock;
    }

    public Stock update(Long id, BigDecimal newPrice) {
        Optional<Stock> stockOpt = findById(id);
        if (stockOpt.isPresent()) {
            Stock stock = stockOpt.get();
            stock.setCurrentPrice(newPrice);
            stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
            return stock;
        }
        return null;
    }
}
