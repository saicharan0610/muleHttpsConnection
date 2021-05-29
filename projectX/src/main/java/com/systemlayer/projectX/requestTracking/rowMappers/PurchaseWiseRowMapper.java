package com.systemlayer.projectX.requestTracking.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.systemlayer.projectX.requestTracking.Responses.PurchaseWiseResponse;

public class PurchaseWiseRowMapper implements RowMapper<PurchaseWiseResponse>{

	@Override
	public PurchaseWiseResponse mapRow(ResultSet rs, int rowNum) throws SQLException {

		PurchaseWiseResponse sample = new PurchaseWiseResponse();
		sample.setTransactionDate(rs.getDate("TRANSACTION_DAT"));
		sample.setDistributor(rs.getString("DISTRIBUTOR_NAME"));
		sample.setAmount(rs.getBigDecimal("AMOUNT"));
		return sample;
	}

}
