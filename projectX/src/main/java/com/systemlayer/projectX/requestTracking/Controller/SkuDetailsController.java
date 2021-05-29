package com.systemlayer.projectX.requestTracking.Controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.systemlayer.projectX.requestTracking.Responses.BillNumberWiseResponse;
import com.systemlayer.projectX.requestTracking.Responses.DistributorsResponse;
import com.systemlayer.projectX.requestTracking.Responses.SkuDetailsResponse;
import com.systemlayer.projectX.requestTracking.implementation.ImplementationLogic;
import com.systemlayer.projectX.requestTracking.model.Response;

@RestController
@RequestMapping(value="/requestTracking/")
public class SkuDetailsController {
	
	@Autowired
	Response response;
	
	@Autowired
	ImplementationLogic implementation;

	@GetMapping(path="/SKUDetails", produces="application/json")
	public  List<SkuDetailsResponse> skuDetails(@RequestParam(name="companyID",required=true) String companyId) {
		
		return implementation.getCompanySkuDetails(companyId);
	
	}
	

}
