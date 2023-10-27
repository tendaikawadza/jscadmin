/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import io.getarrays.securecapita.purchaserequest.dto.request.PurchaseRequestDto;
import io.getarrays.securecapita.purchaserequest.dto.request.PurchaseRequestDtoId;
import io.getarrays.securecapita.purchaserequest.dto.response.PurchaseResponseDto;
import io.getarrays.securecapita.purchaserequest.dto.response.ResponseDto;
import lombok.RequiredArgsConstructor;

/**
 * Kumar.Kunal
 */
@Service
@RequiredArgsConstructor
public class PurchaseRequestNewServiceImpl implements PurchaseRequestNewService {
	
	private final PurchaseRequestNewRepository purchaseRequestRepository;
    private final ModelMapper modelMapper;

	@Override
	public List<PurchaseResponseDto> findAll() {
		
		return purchaseRequestRepository.findAll().stream()
                .map(purchase -> modelMapper.map(purchase, PurchaseResponseDto.class))
                .collect(Collectors.toList());
	}

	@Override
	public PurchaseResponseDto findById(Long id) {
		
		return modelMapper.map(purchaseRequestRepository.findById(id).orElseThrow(PurchaseRequestNotFoundException::new),
                PurchaseResponseDto.class);
	}

	@Override
	public ResponseDto insert(PurchaseRequestDto purchaseRequest) {
		
		return purchaseRequestRepository.save(modelMapper.map(purchaseRequest, PurchaseRequestEntity.class)) > 0
                ? new ResponseDto("Purchase Request Created Successfully!") :
                new ResponseDto("Purchase Request Created Failed!");
	}

	@Override
	public ResponseDto update(PurchaseRequestDtoId purchaseRequest) {
		
		return purchaseRequestRepository.update(modelMapper.map(purchaseRequest, PurchaseRequestEntity.class)) > 0
                ? new ResponseDto("Purchase Request Updated Successfully!") :
                new ResponseDto("Purchase Request Updated Failed!");
	}

	@Override
	public ResponseDto delete(Long id) {
		
		return purchaseRequestRepository.deleteById(id) > 0
                ? new ResponseDto("Purchase Request Deleted Successfully!") :
                new ResponseDto("Purchase Request Deleted Failed!");
	}

}
