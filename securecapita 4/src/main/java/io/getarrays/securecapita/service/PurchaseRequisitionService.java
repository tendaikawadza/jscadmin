package io.getarrays.securecapita.service;

import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.StockItemRequisition;

import java.util.Collection;
import java.util.List;

public interface PurchaseRequisitionService {

    PurchaseRequisition createPurchaseRequest(PurchaseRequisition purchaseRequisition);



    PurchaseRequisition getPurchaseRequestById(Long id);

    Collection<PurchaseRequisition> list (int page, int pageSize);

    boolean deletePurchaseRequests(Long id);
}