/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import java.util.List;
import java.util.Optional;

/**
 * Kumar.Kunal
 */
public interface PurchaseRequestNewRepository {

	int save(PurchaseRequestEntity purchaseRequest);

	int update(PurchaseRequestEntity purchaseRequest);

	Optional<PurchaseRequestEntity> findById(Long id);

	int deleteById(Long id);

	List<PurchaseRequestEntity> findAll();

	int deleteAll();

}
