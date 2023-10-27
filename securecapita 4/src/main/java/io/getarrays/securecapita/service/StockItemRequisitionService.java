package io.getarrays.securecapita.service;


import io.getarrays.securecapita.domain.StockItemRequisition;
import io.getarrays.securecapita.dto.UserDTO;

import java.util.Collection;

public interface StockItemRequisitionService {
    StockItemRequisition createStockItemRequisition    (StockItemRequisition stockItemRequisition);


    Collection<StockItemRequisition> list (int page, int pageSize);



}
