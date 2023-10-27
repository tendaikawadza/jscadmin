/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
/**
 * Kumar.Kunal
 */
@Getter
@RequiredArgsConstructor
public enum PurchaseRequestExceptionEnum {
    PURCHASE_REQUEST_NOT_FOUND_EXCEPTION(HttpStatus.NOT_FOUND, "Purchase Request not found!");

    private final HttpStatus status;
    private final String message;
}
