package com.systemlayer.projectX.requestTracking.Controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.systemlayer.projectX.requestTracking.Requests.NewPurchaseRequest;
import com.systemlayer.projectX.requestTracking.Responses.BillNumberWiseResponse;
import com.systemlayer.projectX.requestTracking.Responses.NewPurchaseResponse;
import com.systemlayer.projectX.requestTracking.Responses.PurchaseWiseResponse;
import com.systemlayer.projectX.requestTracking.implementation.ImplementationLogic;
import com.systemlayer.projectX.requestTracking.model.Response;
import com.systemlayer.projectX.requestTracking.rowMappers.BillNumberWiseRowMapper;

@RestController
@RequestMapping(value ="/resquestTracking/purchase")
public class PurchaseController{
	


	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	ImplementationLogic implementation;
	

	
	@GetMapping(path="/BillNumWise", produces="application/json")
	public @ResponseBody List<BillNumberWiseResponse> billNumberWise(@RequestParam(name="fromDate",required=true) String fromDate,@RequestParam(name="toDate",required=true) String toDate) throws ParseException{
		return implementation.getBillNumberWiseData(fromDate,toDate);
	
	}
	
	@GetMapping(path="/PurchaseWise", produces="application/json")
	public @ResponseBody List<PurchaseWiseResponse> purchaseWise(@RequestParam(name="fromDate",required=true) String fromDate,@RequestParam(name="toDate",required=true) String toDate) throws ParseException{
		return implementation.getPurchaseWise(fromDate,toDate);
	
	}
	
	@PostMapping(path = "/NewPurchase",produces = "application/json")
	public NewPurchaseResponse newPurchase(@RequestBody NewPurchaseRequest newPurchase) {
		Response result =implementation.setNewPurchase(newPurchase);
		
		System.out.println(getClass().getMethods());
		
		return null;
	}
	
}
