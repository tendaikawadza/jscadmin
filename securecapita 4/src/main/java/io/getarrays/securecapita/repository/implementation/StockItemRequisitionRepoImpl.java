package io.getarrays.securecapita.repository.implementation;



import io.getarrays.securecapita.domain.PurchaseRequisition;
import io.getarrays.securecapita.domain.StockItemRequisition;
import io.getarrays.securecapita.query.StockItemRequisitionQuery;
import io.getarrays.securecapita.repository.StockItemRequisitionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Map.of;

@Repository
@RequiredArgsConstructor
@Slf4j

public class StockItemRequisitionRepoImpl implements StockItemRequisitionRepository<StockItemRequisition> {

    private final NamedParameterJdbcTemplate jdbc;
    private final List<StockItemRequisition> stockItemRequisitions;



    RowMapper<StockItemRequisition> rowMapper = (rs, rowNum) -> {
        StockItemRequisition stockItemRequisition = new StockItemRequisition();
        stockItemRequisition.setRequistingDepartment(rs.getString("requistingDepartment"));
       stockItemRequisition.setDate(rs.getDate("date"));
        stockItemRequisition.setDepartmentCode(rs.getInt("departmentCode"));
       stockItemRequisition.setPurposeOfIssue(rs.getString("PurposeOfIssue"));
       stockItemRequisition.setItemDescription(rs.getString("ItemDescription"));
       stockItemRequisition.setDate(rs.getDate("dateOfPreviousIssue"));
         stockItemRequisition.setPreviousIssueQuantity(rs.getInt("PreviousIssueQuantity"));
       stockItemRequisition.setQuantity(rs.getInt("Quantity"));
        stockItemRequisition.setInitiatedBy(rs.getString("initiatedBy"));

       stockItemRequisition.setSignature(rs.getString("Signature"));


        stockItemRequisition.setReceiverEmail(rs.getString("receiverEmail"));

        return stockItemRequisition;
    };





    @Override
    public Collection<StockItemRequisition> list(int page, int pageSize) {
        int startIndex = (page - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, stockItemRequisitions.size());
        if (startIndex >= endIndex) {
            return Collections.emptyList(); // Return an empty list if the startIndex is greater than or equal to endIndex
        }
        return stockItemRequisitions.subList(startIndex, endIndex);


    }

















    @Override
    public StockItemRequisition create(StockItemRequisition stockItemRequisition) {
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource parameters = getSqlParameterSource(stockItemRequisition);
        jdbc.update(StockItemRequisitionQuery.INSERT_StockItemRequisition_REQUEST_QUERY,parameters, holder);
        return stockItemRequisition;
    }
    private SqlParameterSource getSqlParameterSource(StockItemRequisition stockItemRequisition) {
        return new MapSqlParameterSource()
                .addValue("requestingDepartment", stockItemRequisition.getRequistingDepartment())
                .addValue("date", stockItemRequisition.getDate())
                .addValue("departmentCode", stockItemRequisition.getDepartmentCode())
                .addValue("purposeOfIssue", stockItemRequisition.getPurposeOfIssue())
                .addValue("itemDescription", stockItemRequisition.getItemDescription())
                .addValue("dateOfPreviousIssue", stockItemRequisition.getDateOfPreviousIssue())
                .addValue("previousIssueQuantity", stockItemRequisition.getPreviousIssueQuantity())
                .addValue("initiatedBy", stockItemRequisition.getInitiatedBy())
                .addValue("signature", stockItemRequisition.getSignature())
                .addValue("receiverEmail", stockItemRequisition.getReceiverEmail());
    }

//
//    @Override
//    public PurchaseRequisition get(Long id) {
//        try {
//
//            return jdbc.queryForObject(PurchaseQuery.INSERT_PurchaseRequisition_REQUEST_QUERY, of("id", id),rowMapper);
//
//        } catch (EmptyResultDataAccessException exception) {
//            throw new ApiException("No PURCHASE REQUESTS found by id: " + id);
//        } catch (Exception exception) {
//            log.error(exception.getMessage());
//            throw new ApiException("An error occurred. Please try again.");
//        }
//    }
//
////    @Override
////    public void update(PurchaseRequests purchaseRequests, Long id) {
////
////    }
//
////    @Override
////    public void update(PurchaseRequests purchaseRequests, Long id) {
////        try {
////
////            String UPDATE_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID = "UPDATE PURCHASEREQUEST SET productName=?,Date=?,productCode=? WHERE id = :purchaserequestsId";
////
////            jdbcTemplate.update(UPDATE_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID, purchaseRequests.getProductName(),purchaseRequests.getDate(),purchaseRequests.getProductCode(),id);
////            return;
////
////        }
////        catch (Exception exception) {
////            log.error(exception.getMessage());
////            throw new ApiException("An error occurred. Please try again.");
////        }
////
////    }
//
//
//
//    @Override
//    public boolean delete(Long id) {
//        try {
//            String DELETE_FROM_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID = "DELETE FROM PURCHASEREQUEST WHERE id = :purchaserequestwId";
//            jdbc.update(DELETE_FROM_PURCHASEREQUESTS_BY_PURCHASEREQUEST_ID, Collections.singletonMap("purchaserequestsId", id));
//            return true;
//        }
//        catch (Exception exception) {
//            log.error(exception.getMessage());
//            throw new ApiException("An error occurred. Please try again.");
//        }
//
//    }

}
