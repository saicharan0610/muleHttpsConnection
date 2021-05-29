package com.systemlayer.projectX.requestTracking.implementation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.systemlayer.projectX.requestTracking.Requests.DistributorRequest;
import com.systemlayer.projectX.requestTracking.Requests.NewPurchaseRequest;
import com.systemlayer.projectX.requestTracking.Responses.BillNumberWiseResponse;
import com.systemlayer.projectX.requestTracking.Responses.CompaniesResponse;
import com.systemlayer.projectX.requestTracking.Responses.DistributorsResponse;
import com.systemlayer.projectX.requestTracking.Responses.PurchaseWiseResponse;
import com.systemlayer.projectX.requestTracking.Responses.SkuDetailsResponse;
import com.systemlayer.projectX.requestTracking.model.Companies;
import com.systemlayer.projectX.requestTracking.model.Response;
import com.systemlayer.projectX.requestTracking.model.SkuDetails;
import com.systemlayer.projectX.requestTracking.rowMappers.BillNumberWiseRowMapper;
import com.systemlayer.projectX.requestTracking.rowMappers.CompaniesRowMapper;
import com.systemlayer.projectX.requestTracking.rowMappers.DistributorsRowMapper;
import com.systemlayer.projectX.requestTracking.rowMappers.PurchaseWiseRowMapper;
import com.systemlayer.projectX.requestTracking.rowMappers.SkuDetailsRowMapper;

@Component
public class ImplementationLogic {

	@Autowired
	JdbcTemplate jdbc;

	SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
	SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

	public List<BillNumberWiseResponse> getBillNumberWiseData(String fromDate, String toDate) throws ParseException {
		Date fromdate = inputFormat.parse(fromDate);
		Date todate = inputFormat.parse(toDate);
		String sFromDate = outputFormat.format(fromdate);
		String sToDate = outputFormat.format(todate);

		String sql = "SELECT P.TRANSACTION_DAT \n" + "	, D.DISTRIBUTOR_NAME\n"
				+ "	, sum(P.SELLING_UNIT_COST*P.SELLING_UNIT_QUANTITY) as AMOUNT\n" + "	, P.BILL_NUM\n"
				+ "FROM PURCHASES P\n" + "	INNER JOIN DISTRIBUTORS D on P.DISTRIBUTOR_ID = D.DISTRIBUTOR_ID\n"
				+ "	INNER JOIN SKUDETAILS SD on P.SKU_ID = SD.SKU_ID\n" + "WHERE P.TRANSACTION_DAT BETWEEN '"
				+ sFromDate + "' AND '" + sToDate + "'\n" + "GROUP BY P.TRANSACTION_DAT \n" + "	, P.BILL_NUM\n"
				+ "	, D.DISTRIBUTOR_NAME";

		return jdbc.query(sql, new BillNumberWiseRowMapper());
	}

	public List<PurchaseWiseResponse> getPurchaseWise(String fromDate, String toDate) throws ParseException {
		Date fromdate = inputFormat.parse(fromDate);
		Date todate = inputFormat.parse(toDate);
		String sFromDate = outputFormat.format(fromdate);
		String sToDate = outputFormat.format(todate);
		String sql = "SELECT P.TRANSACTION_DAT \n" + "	, D.DISTRIBUTOR_NAME\n"
				+ "	, sum(P.SELLING_UNIT_COST*P.SELLING_UNIT_QUANTITY) as AMOUNT\n" + "FROM PURCHASES P\n"
				+ "	INNER JOIN DISTRIBUTORS D on P.DISTRIBUTOR_ID = D.DISTRIBUTOR_ID\n"
				+ "	INNER JOIN SKUDETAILS SD on P.SKU_ID = SD.SKU_ID\n" + "WHERE P.TRANSACTION_DAT BETWEEN '"
				+ sFromDate + "' AND '" + sToDate + "'\n" + "GROUP BY P.TRANSACTION_DAT \n" + "	, D.DISTRIBUTOR_NAME";
		return jdbc.query(sql, new PurchaseWiseRowMapper());
	}

	public List<DistributorsResponse> getDistributors() {
		String sql = "select * from DISTRIBUTORS";
		List<DistributorsResponse> dQueryResult = jdbc.query(sql, new DistributorsRowMapper());
		for (DistributorsResponse s : dQueryResult) {
			List<CompaniesResponse> finalCompanies = new ArrayList();
			for (String s1 : s.getCompaniesList().split(",")) {
				String query = "select * from COMPANIES where COMPANY_NAME = " + "'" + s1.trim() + "'";
				List<CompaniesResponse> result = jdbc.query(query, new CompaniesRowMapper());
				finalCompanies.add(result.get(0));
			}
			s.setCompanies(finalCompanies);
		}
		return dQueryResult;
	}

	public boolean setDistributor(DistributorRequest distributor) {
		boolean flag = false;
		try {
			String sql = "INSERT INTO DISTRIBUTORS(DISTRIBUTOR_ID,DISTRIBUTOR_NAME,PHONE_NUMBER,COMPANIES_LIST,ISACTIVE) \n"
					+ "VALUES ('" + distributor.getDistributorName().split(" ")[0] + "','"
					+ distributor.getDistributorName() + "','" + distributor.getPhoneNumber() + "','"
					+ distributor.getCompaniesList() + "',1)";
			jdbc.update(sql);
			flag = true;
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<SkuDetailsResponse> getCompanySkuDetails(String companyId) {

		String sql = "SELECT * FROM SKUDETAILS WHERE COMPANY_ID ='" + companyId + "'";
		List<SkuDetailsResponse> skuQueryResult = jdbc.query(sql, new SkuDetailsRowMapper());
		String cSql = "SELECT * FROM COMPANIES WHERE COMPANY_ID = '" + skuQueryResult.get(0).getCompanyId().trim()
				+ "'";
		List<CompaniesResponse> cResponse = jdbc.query(cSql, new CompaniesRowMapper());
		for (SkuDetailsResponse s : skuQueryResult) {
			s.setCompanyName(cResponse.get(0).getCompanyName());
		}
		return skuQueryResult;
	}

	@Transactional
	public Response setNewPurchase(NewPurchaseRequest newPurchase) {
		Response response = new Response();
		List<SkuDetails> finalNewSkuDetails = new ArrayList();
		List<SkuDetails> finalSkuDetails = new ArrayList();

		for (Companies s : newPurchase.getSelectedDistributor().getCompanies()) {
			if (s.getsKuDetails() != null) {
				finalSkuDetails.addAll(s.getsKuDetails());
			}
			if (s.getNewSkuDetails() != null) {
				finalNewSkuDetails.addAll(s.getNewSkuDetails());
			}
		}
			List<String> skuSql = new ArrayList<>();
			for (SkuDetails s : finalNewSkuDetails) {
				String temp = "INSERT INTO SKUDETAILS\n"
						+ "(SKU_ID,SKU_NAME,COMPANY_ID,UNIT_MRP,UNITS_PER_SELLING_UNIT,SELLING_UNIT_PER_CASE,SELLING_UNIT_COST,BALANCE)\n"
						+ "VALUES ('" + s.getSkuId().trim() + "','" + s.getSkuName().trim() + "','"
						+ s.getCompanyId().trim() + "'," + s.getUnitMrp() + "," + s.getUnitPerSU() + ","
						+ s.getSupCase() + "," + s.getSunitCase() + "," + s.getBalance() + ")";
				skuSql.add(temp);
			}
			String[] finalSql = skuSql.toArray(new String[0]);

				jdbc.batchUpdate(finalSql);
			response.setSuccess(true);
/////////////////
		List<SkuDetails> finalList = new ArrayList<>();
		if (finalSkuDetails.size()>0)
			finalList.addAll(finalSkuDetails);
		if (finalNewSkuDetails.size()>0)
			finalList.addAll(finalNewSkuDetails);
		///
		///
		List<String> pSql = new ArrayList<>();
		for (SkuDetails s: finalList) {	
			String temp="INSERT INTO PURCHASES\n" + 
					"(DISTRIBUTOR_ID,SKU_ID,SELLING_UNIT_COST,SELLING_UNIT_QUANTITY,TRANSACTION_DAT,BILL_NUM)\n" + 
					"VALUES ('"+ newPurchase.getSelectedDistributor().getDistributorId()+"','"+s.getSkuId().trim() +"',"+ s.getSunitCase()+","+ s.getQuantitySU()+",'"+newPurchase.getTransactionDate()+"',"+newPurchase.getBillNumber()+")";
			pSql.add(temp);
		}
		String[] finalPsql = pSql.toArray(new String[0]);
		jdbc.batchUpdate(finalPsql);
		return response;
	}

}
