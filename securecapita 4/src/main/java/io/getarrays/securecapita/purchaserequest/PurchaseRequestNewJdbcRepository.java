/**
 * kunal
 * securecapita 4
 * io.getarrays.securecapita.purchaserequest
 */
package io.getarrays.securecapita.purchaserequest;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

/**
 * Kumar.Kunal
 */
@Repository
@RequiredArgsConstructor
public class PurchaseRequestNewJdbcRepository implements PurchaseRequestNewRepository {

	private static final Logger log = LoggerFactory.getLogger(PurchaseRequestNewJdbcRepository.class);

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public static final String PURCHASE_REQUEST_LIST = "select * from purchaserequestnew";
	public static final String PURCHASE_REQUEST_FIND_BY_ID = "select * from purchaserequestnew where id = :id";
	public static final String UPDATE_PURCHASE_REQUEST = "update purchaserequestnew set product_name = :productName, product_code = :productCode, quantity = :quantity where id = :id";
	public static final String DELETE_PURCHASE_REQUEST = "delete from purchaserequestnew where id = :id";

	@Override
	public int save(PurchaseRequestEntity purchaseRequest) {

		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		String sql = "insert into purchaserequestnew (product_name, purchase_date, product_code, quantity, email_address, profile_image) "
				+ "values (:productName, :purchaseDate, :productCode, :quantity, :emailAddress, :profileImage)";
		SqlParameterSource paramSource = new MapSqlParameterSource()
				.addValue("product_name", purchaseRequest.getProductName())
				.addValue("purchase_date", purchaseRequest.getPurchaseDate())
				.addValue("product_code", purchaseRequest.getProductCode())
				.addValue("quantity", purchaseRequest.getQuantity())
				.addValue("email_address", purchaseRequest.getEmailAddress())
				.addValue("profile_image", purchaseRequest.getQuantity());
		namedParameterJdbcTemplate.update(sql, paramSource, generatedKeyHolder);
		int id = generatedKeyHolder.getKey().intValue();
		log.info("save method value from DAO ---- " + id);
		purchaseRequest.setId(id);
		return id;
	}

	@Override
	public int update(PurchaseRequestEntity purchaseRequest) {

		return namedParameterJdbcTemplate.update(UPDATE_PURCHASE_REQUEST,
				new BeanPropertySqlParameterSource(purchaseRequest));
	}

	@Override
	public Optional<PurchaseRequestEntity> findById(Long id) {

		MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		mapSqlParameterSource.addValue("id", id);
		return namedParameterJdbcTemplate.query(PURCHASE_REQUEST_FIND_BY_ID, mapSqlParameterSource,
				(rs, row) -> PurchaseRequestEntity.builder().id(rs.getLong("id"))
						.productName(rs.getString("productName")).purchaseDate(rs.getString("purchaseDate"))
						.productCode(rs.getString("productCode")).quantity(rs.getString("quantity"))
						.emailAddress(rs.getString("emailAddress")).profileImage(rs.getString("profileImage")).build())
				.stream().findFirst();
	}

	@Override
	public int deleteById(Long id) {

		return namedParameterJdbcTemplate.update(DELETE_PURCHASE_REQUEST, new MapSqlParameterSource("id", id));
	}

	@Override
	public List<PurchaseRequestEntity> findAll() {

		return namedParameterJdbcTemplate.query(PURCHASE_REQUEST_LIST,
				(rs, row) -> PurchaseRequestEntity.builder().id(rs.getLong("id"))
						.productName(rs.getString("productName")).purchaseDate(rs.getString("purchaseDate"))
						.productCode(rs.getString("productCode")).quantity(rs.getString("quantity"))
						.emailAddress(rs.getString("emailAddress")).profileImage(rs.getString("profileImage")).build());
	}

	@Override
	public int deleteAll() {

		return 0;
	}

}
