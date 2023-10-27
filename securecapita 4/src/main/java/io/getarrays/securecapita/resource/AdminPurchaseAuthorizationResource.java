package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.AdminPurchaseAuthorization;
import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.service.AdminPurchaseAuthorizationService;
import io.getarrays.securecapita.service.implementation.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/adminPurchaseAuthorization")
@RequiredArgsConstructor
public class AdminPurchaseAuthorizationResource {
    public static AdminPurchaseAuthorizationService adminPurchaseAuthorizationService;
    @Autowired
    private EmailService emailService;

    @PostMapping("/create")
    public ResponseEntity<List<AdminPurchaseAuthorization>> createPurchase(@RequestBody List<AdminPurchaseAuthorization> adminPurchaseAuthorizations) {
        List<AdminPurchaseAuthorization> createdAdminPurchaseAuthorizations = new ArrayList<>();

        for (AdminPurchaseAuthorization adminPurchaseAuthorization : adminPurchaseAuthorizations) {
            String email = adminPurchaseAuthorization.getReceiverEmail();
            String subject = "Purchase Request Email Verification Sent By Kumar Kunal";
            String message = "Hello " + adminPurchaseAuthorization.getId() + " for Product Name " + adminPurchaseAuthorization.getQuantity() + ", " +
                    "\nA Purchase Request Email Verification Was Sent To\n" + adminPurchaseAuthorization.getReceiverEmail();
            emailService.sendEmail(email, subject, message);

            AdminPurchaseAuthorization createdAdminPurchaseAuthorization = adminPurchaseAuthorizationService.createAdminPurchaseAuthorization(adminPurchaseAuthorization);
            createdAdminPurchaseAuthorizations.add(createdAdminPurchaseAuthorization);
        }
        return ResponseEntity.ok(adminPurchaseAuthorizations);






};}
