package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.Stock;
import io.getarrays.securecapita.service.StockService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class StockController {
    private StockService stockService;

    @PostMapping("/add")
    public ResponseEntity<Stock> createProduct(@RequestBody Stock stock){

        Stock createProduct = stockService.createProduct(stock);
        return new ResponseEntity<>(createProduct, HttpStatus.OK);
    }


    @GetMapping("/totalQuantity")
    public int getTotalQuantityByProductCode(@RequestParam String productCode) {
        return stockService.getTotalQuantityByProductCode(productCode);
    }





}
