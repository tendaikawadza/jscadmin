package io.getarrays.securecapita.resource;

import io.getarrays.securecapita.domain.HttpResponse;
import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.StockItemRequisition;
import io.getarrays.securecapita.service.PurchaseRequisitionService;
import io.getarrays.securecapita.service.StockItemRequisitionService;
import io.getarrays.securecapita.service.implementation.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;

@RestController
@RequestMapping(path = "/StockItemRequisition")
@RequiredArgsConstructor
public class StockItemRequisitionResource {



    private final StockItemRequisitionService stockItemRequisitionService;

    @Autowired
    private EmailService emailService;



    @PostMapping("/create")
    public ResponseEntity<List<StockItemRequisition>> createPurchase(@RequestBody List<StockItemRequisition> stockItemRequisitions) {
        List<StockItemRequisition> createdStockItemRequisition = new ArrayList<>();

        for (StockItemRequisition   stockItemRequisition : stockItemRequisitions) {
            String email = stockItemRequisition.getReceiverEmail();
            String subject = "Purchase Request Email Verification Sent By Kumar Kunal";
            String message = "Hello " + stockItemRequisition.getItemDescription() + " for Product Name " + stockItemRequisition.getItemDescription() + ", " +
                    "\n A Purchase Request Email Verification Was Sent To \n" + stockItemRequisition.getReceiverEmail();
            emailService.sendEmail(email, subject, message);

            StockItemRequisition createdPurchaseRequisition = stockItemRequisitionService.createStockItemRequisition(stockItemRequisition);
            createdStockItemRequisition.add(createdPurchaseRequisition);
        }

        return ResponseEntity.ok(createdStockItemRequisition);


    }


    @GetMapping("/list")
    public ResponseEntity<Collection<StockItemRequisition>> listStockItemRequisition(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int pageSize) {

        // Call the appropriate service method to retrieve the paginated list of stock item requisitions
        Collection<StockItemRequisition> stockItemRequisitions = stockItemRequisitionService.list(page, pageSize);

        // Return the paginated list of stock item requisitions in the response body
        return ResponseEntity.ok(stockItemRequisitions);
    }

//    @GetMapping("/list")
//    public ResponseEntity<List<StockItemRequisition>> listStockItemRequisition(Authentication authentication) {
//        // Get the authenticated user's email
//        String userEmail = authentication.getName();
//
//        // Call the appropriate service method to retrieve the requisitions for the authenticated user
//        List<StockItemRequisition> userRequisitions = stockItemRequisitionService.getByUserEmail(userEmail);
//
//        // Return the requisitions in the response body
//        return ResponseEntity.ok(userRequisitions);
//    }
//






}
