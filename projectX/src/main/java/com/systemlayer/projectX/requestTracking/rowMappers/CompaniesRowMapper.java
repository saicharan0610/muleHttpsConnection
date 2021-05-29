package com.systemlayer.projectX.requestTracking.rowMappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.systemlayer.projectX.requestTracking.Responses.CompaniesResponse;

public class CompaniesRowMapper implements RowMapper<CompaniesResponse> {

	@Override
	public CompaniesResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		CompaniesResponse sample = new CompaniesResponse();
		sample.setCompanyId(rs.getString("COMPANY_ID"));
		sample.setCompanyName(rs.getString("COMPANY_NAME"));
		return sample;
	}



}
