package io.getarrays.securecapita.service.implementation;

import io.getarrays.securecapita.domain.AdminPurchaseAuthorization;
import io.getarrays.securecapita.domain.StockItemRequisition;
import io.getarrays.securecapita.repository.AdminPurchaseAuthorizationRepository;
import io.getarrays.securecapita.repository.PurchaseRequestsRepository;
import io.getarrays.securecapita.service.AdminPurchaseAuthorizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminPurchaseAuthorizationImpl  implements AdminPurchaseAuthorizationService {

    private final AdminPurchaseAuthorizationRepository adminPurchaseAuthorizationRepository;


public AdminPurchaseAuthorization createAdminPurchaseAuthorization (AdminPurchaseAuthorization adminPurchaseAuthorization){
    adminPurchaseAuthorizationRepository.create(adminPurchaseAuthorization);
    return adminPurchaseAuthorization;

}










}
