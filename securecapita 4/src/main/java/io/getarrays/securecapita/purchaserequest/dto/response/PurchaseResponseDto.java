/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
/**
 * Kumar.Kunal
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseResponseDto {
	private long id;
	private String productName;
    private String purchaseDate;
    private String productCode;
    private String quantity;
    private String emailAddress;
}
