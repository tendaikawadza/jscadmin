/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import java.io.Serial;

import io.getarrays.securecapita.purchaserequest.PurchaseRequestExceptionEnum;
/**
 * Kumar.Kunal
 */
public class PurchaseRequestNotFoundException extends RuntimeException {
	
	@Serial
    private static final long serialVersionUID = -7541208107922250009L;

	public PurchaseRequestNotFoundException () {
        super(PurchaseRequestExceptionEnum.PURCHASE_REQUEST_NOT_FOUND_EXCEPTION.getMessage());
    }
}
