package com.systemlayer.projectX.requestTracking.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.systemlayer.projectX.requestTracking.Responses.SkuDetailsResponse;

public class SkuDetailsRowMapper implements RowMapper<SkuDetailsResponse> {

	@Override
	public SkuDetailsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		SkuDetailsResponse sample = new SkuDetailsResponse();
		sample.setBalance(rs.getInt("BALANCE"));
		sample.setCompanyId(rs.getString("COMPANY_ID"));
		sample.setSkuId(rs.getString("SKU_ID"));
		sample.setSkuName(rs.getString("SKU_NAME"));
		sample.setSunitCase(rs.getBigDecimal("SELLING_UNIT_COST"));
		sample.setSupCase(rs.getInt("SELLING_UNIT_PER_CASE"));
		sample.setUnitMrp(rs.getInt("UNIT_MRP"));
		sample.setUnitPerSU(rs.getInt("UNITS_PER_SELLING_UNIT"));	
		return sample;
	}


}
