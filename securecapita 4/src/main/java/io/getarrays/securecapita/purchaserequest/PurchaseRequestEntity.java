/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Kumar.Kunal
 */
@Data
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseRequestEntity {
	
	private long id;
	private String productName;
    private String purchaseDate;
    private String productCode;
    private String quantity;
    private String emailAddress;
    
    //@Lob
    private String profileImage;
    
    public PurchaseRequestEntity(long id, String purchaseDate, String productCode, String quantity, String emailAddress, String profileImage) {
        this.id = id;
        this.purchaseDate = purchaseDate;
        this.productCode = productCode;
        this.quantity = quantity;
        this.emailAddress = emailAddress;
        this.profileImage = profileImage;
      }

    public PurchaseRequestEntity(String purchaseDate, String productCode, String quantity, String emailAddress, String profileImage) {
        this.purchaseDate = purchaseDate;
        this.productCode = productCode;
        this.quantity = quantity;
        this.emailAddress = emailAddress;
        this.profileImage = profileImage;
      }

}
