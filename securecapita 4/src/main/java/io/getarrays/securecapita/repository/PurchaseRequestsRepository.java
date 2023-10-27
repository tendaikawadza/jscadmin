package io.getarrays.securecapita.repository;

import io.getarrays.securecapita.domain.PurchaseRequisition;

import java.util.Collection;
import java.util.List;

public interface PurchaseRequestsRepository <T extends PurchaseRequisition>{
     List<T> list();
    T create(T data);
    Collection<T> list(int page, int pageSize);

    T get(Long id);

//
//    void update(T t,Long id);
    boolean delete(Long id);


}
