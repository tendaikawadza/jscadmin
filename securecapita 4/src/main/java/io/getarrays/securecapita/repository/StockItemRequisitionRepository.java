package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.StockItemRequisition;

import java.util.Collection;

public interface StockItemRequisitionRepository <T extends StockItemRequisition>{

    T create(T data);

    Collection<T> list(int page, int pageSize);


}
