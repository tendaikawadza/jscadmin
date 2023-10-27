package io.getarrays.securecapita.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Date;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Data
@Setter
@Getter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
public class StockItemRequisition {

    private  String requistingDepartment;
    private Date date;
    private  int departmentCode;
    private  String PurposeOfIssue;
    private String ItemDescription;
    private Date  dateOfPreviousIssue;

    private  int PreviousIssueQuantity;
    private int Quantity;

    private String InitiatedBy;
     private String Signature;
    private  String receiverEmail;




}
