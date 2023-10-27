/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.getarrays.securecapita.purchaserequest.dto.request.PurchaseRequestDto;
import io.getarrays.securecapita.purchaserequest.dto.request.PurchaseRequestDtoId;
import io.getarrays.securecapita.purchaserequest.dto.response.PurchaseResponseDto;
import io.getarrays.securecapita.purchaserequest.dto.response.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Kumar.Kunal
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/purchaserequest") // giving a different name as purchase request name might be existing, please change to specific
@Slf4j
public class PurchaseRequestNewController {
	
	private final PurchaseRequestNewService purchaseRequestService;
	
	@GetMapping
    public List<PurchaseResponseDto> purchaserequest() {
        log.info("GET - /purchase request -> request none");
        List<PurchaseResponseDto> purchaseResponse = purchaseRequestService.findAll();
        log.info("GET - /purchase request - response -> {}", purchaseResponse);
        return purchaseResponse;
    }
	
	@GetMapping("/{id}")
    public PurchaseResponseDto employeeById(@PathVariable Long id) {
        log.info("GET - /purchase request/{} -> request", id);
        PurchaseResponseDto purchaseResponse = purchaseRequestService.findById(id);
        log.info("GET - /purchase request/{} - response -> {}", id, purchaseResponse);
        return purchaseResponse;
    }
	
	@PostMapping
    public ResponseDto insert(@RequestBody PurchaseRequestDto purchaseRequestDto) {
        log.info("POST - /purchase request - request -> {}", purchaseRequestDto);
        ResponseDto request =  purchaseRequestService.insert(purchaseRequestDto);
        log.info("POST - /purchase request -> response none");
        return request;
    }
	
	@PutMapping
    public ResponseDto update(@RequestBody PurchaseRequestDtoId purchaseRequestDto) {
        log.info("PUT - /purchase request - request -> {}", purchaseRequestDto);
        ResponseDto response =  purchaseRequestService.update(purchaseRequestDto);
        log.info("PUT - /purchase request -> response none");
        return response;
    }
	
	@DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable Long id) {
        log.info("DELETE - /purchase request/{} -> request", id);
        ResponseDto response =  purchaseRequestService.delete(id);
        log.info("DELETE - /purchase request -> response none");
        return response;
    }

}
