package com.systemlayer.projectX.requestTracking.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.systemlayer.projectX.requestTracking.Responses.BillNumberWiseResponse;

public class BillNumberWiseRowMapper implements RowMapper<BillNumberWiseResponse> {
	
	 @Override
	 public BillNumberWiseResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		 BillNumberWiseResponse sample = new BillNumberWiseResponse();
		 	sample.setTransactionDate(rs.getDate("TRANSACTION_DAT"));
			sample.setAmount(rs.getDouble("AMOUNT"));
	        sample.setBillNumber(rs.getInt("BILL_NUM"));
	        sample.setDistributor(rs.getString("DISTRIBUTOR_NAME"));
	        return sample;
	    }
}
