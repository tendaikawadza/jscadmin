package io.getarrays.securecapita.query;

public class StockItemRequisitionQuery {

    public static final String INSERT_StockItemRequisition_REQUEST_QUERY = "INSERT INTO StockItemRequisition (requestingDepartment, Date, departmentCode, PurposeOfIssue, ItemDescription, dateOfPreviousIssue, PreviousIssueQuantity, InitiatedBy, Signature, receiverEmail) " +
            "VALUES (:requestingDepartment, :Date, :departmentCode, :PurposeOfIssue, :ItemDescription, :dateOfPreviousIssue, :PreviousIssueQuantity, :InitiatedBy, :Signature, :receiverEmail)";
}
