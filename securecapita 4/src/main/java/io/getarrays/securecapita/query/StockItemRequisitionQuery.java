package io.getarrays.securecapita.query;

public class StockItemRequisitionQuery {
    public static final String  INSERT_StockItemRequisition_REQUEST_QUERY= "INSERT INTO StockItemRequisition (requestingDepartment,date, departmentCode,purposeOfIssue, itemDescription, dateOfPreviousIssue, previousIssueQuantity,  initiatedBy, signature, receiverEmail ) " +

            "VALUES (:requestingDepartment,:date, :departmentCode, :purposeOfIssue, :itemDescription, :dateOfPreviousIssue, :previousIssueQuantity, :signature, :receiverEmail)";


}
