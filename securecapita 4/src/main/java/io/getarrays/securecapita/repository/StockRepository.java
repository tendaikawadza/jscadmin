package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository  extends JpaRepository <Stock,Long>{
    //Product findByProductCode(String productCode);
  Stock findByProductCode(String productCode);
}
