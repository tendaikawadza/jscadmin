package io.getarrays.securecapita.service.implementation;

import io.getarrays.securecapita.domain.StockItemRequisition;
import io.getarrays.securecapita.dto.UserDTO;
import io.getarrays.securecapita.repository.PurchaseRequestsRepository;
import io.getarrays.securecapita.repository.StockItemRequisitionRepository;
import io.getarrays.securecapita.service.StockItemRequisitionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockItemRequisitionImpl implements StockItemRequisitionService {
    private final StockItemRequisitionRepository stockItemRequisitionRepository;


    public StockItemRequisition createStockItemRequisition (StockItemRequisition stockItemRequisition) {
        stockItemRequisitionRepository.create(stockItemRequisition);
        return stockItemRequisition;
    }


    @Override
    public Collection<StockItemRequisition> list(int page, int pageSize) {
        return stockItemRequisitionRepository.list(page, pageSize);
    }






}
