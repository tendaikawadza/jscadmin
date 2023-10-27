/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import java.util.List;

import io.getarrays.securecapita.purchaserequest.dto.request.PurchaseRequestDto;
import io.getarrays.securecapita.purchaserequest.dto.request.PurchaseRequestDtoId;
import io.getarrays.securecapita.purchaserequest.dto.response.PurchaseResponseDto;
import io.getarrays.securecapita.purchaserequest.dto.response.ResponseDto;

/**
 * Kumar.Kunal
 */
public interface PurchaseRequestNewService {
	
	List<PurchaseResponseDto> findAll();
	PurchaseResponseDto findById(Long id);
	ResponseDto insert(PurchaseRequestDto purchaseRequest);
	ResponseDto update(PurchaseRequestDtoId purchaseRequest);
	ResponseDto delete(Long id);

}