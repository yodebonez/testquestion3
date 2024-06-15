package com.example.mytest.Controllers;

import com.example.mytest.Models.Stock;
import com.example.mytest.Services.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/stocks")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Stock> getStockById(@PathVariable Long id) {
        Optional<Stock> stock = stockRepository.findById(id);
        return stock.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Stock> createStock(@RequestBody Stock stock) {
        stock.setCreateDate(new Timestamp(System.currentTimeMillis()));
        stock.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        Stock createdStock = stockRepository.save(stock);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Stock> updateStockPrice(@PathVariable Long id, @RequestBody BigDecimal newPrice) {
        Stock updatedStock = stockRepository.update(id, newPrice);
        if (updatedStock != null) {
            return ResponseEntity.ok(updatedStock);
        }
        return ResponseEntity.notFound().build();
    }
}