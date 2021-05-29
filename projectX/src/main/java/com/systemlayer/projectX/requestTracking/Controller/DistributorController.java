package com.systemlayer.projectX.requestTracking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.systemlayer.projectX.requestTracking.Requests.DistributorRequest;
import com.systemlayer.projectX.requestTracking.Responses.DistributorsResponse;
import com.systemlayer.projectX.requestTracking.implementation.ImplementationLogic;
import com.systemlayer.projectX.requestTracking.model.Response;

@RestController
@RequestMapping(value="/requestTracking/")
public class DistributorController {
	
@Autowired
ImplementationLogic imp;

@Autowired
Response response;

	@GetMapping(path="/Distributors", produces="application/json")
	public List<DistributorsResponse> distributors(){
		return imp.getDistributors();	
	}
	
	@PostMapping(path="/NewDistributor", produces="application/json")
	public @ResponseBody Response insertDistributor(@RequestBody DistributorRequest distributor) {
		response.setSuccess(imp.setDistributor(distributor));
		return response;
		
	}
}


