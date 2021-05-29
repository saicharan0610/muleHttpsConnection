package com.systemlayer.projectX.requestTracking.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.systemlayer.projectX.requestTracking.Responses.BillNumberWiseResponse;
import com.systemlayer.projectX.requestTracking.Responses.DistributorsResponse;

public class DistributorsRowMapper implements RowMapper<DistributorsResponse> {

	@Override
	public DistributorsResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		DistributorsResponse sample = new DistributorsResponse();
		sample.setDistributorId(rs.getString("DISTRIBUTOR_ID"));
		sample.setDistributorName(rs.getString("DISTRIBUTOR_NAME"));
		sample.setCompaniesList(rs.getString("COMPANIES_LIST"));
		return sample;
	}
}