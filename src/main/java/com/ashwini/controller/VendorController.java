package com.ashwini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ashwini.entities.Vendor;
import com.ashwini.service.VendorService;

@RestController
public class VendorController {

	@Autowired
	VendorService vendorService;

	// ES_GET_ENTITYSET
	// Test using https://localhost:8080/vendor
	@RequestMapping("/vendor")
	public List<Vendor> getVendors() {
		return vendorService.readAllVendors();
	}

	// ES_GET_ENTITY
	// Test using https://localhost:8080/vendor/1
	@RequestMapping("/vendor/{id}")
	public Vendor getVendorById(@PathVariable("id") String id) {
		return vendorService.getSingleVendor(id);
	}

	// ES_CREATE_ENTITY
	// Test using https://localhost:8080/vendor and payoad => {"companyName": "IBM","firstName": "Amit","lastName": "Meena","website": "www.amitmeena.com","email": "contactamitmeena.com","status": "A","gstNo": "GST987"}
	@PostMapping("/vendor")
	public Vendor createVendor(@RequestBody Vendor myPostBody) {
		return vendorService.createVendor(myPostBody);
	}

	// ES_UPDATE_ENTITY
	// Test using https://localhost:8080/vendor and payoad => {"id": 1,"companyName": "IBM","firstName": "Amit","lastName": "Meena","website": "www.amitmeena.com","email": "contactamitmeena.com","status": "A","gstNo": "GST987"}
	@RequestMapping(method = RequestMethod.PUT, value = "/vendor")
	public Vendor updateVendor(@RequestBody Vendor myPutBody) {
		return vendorService.changeVendor(myPutBody);
	}

	// ES_DELETE_ENTITY
	// Test using https://localhost:8080/vendor/1
	@RequestMapping(method = RequestMethod.DELETE, value = "/vendor/{id}")
	public String deleteVendor(@PathVariable("id") String id) {
		return vendorService.deleteVendor(id);
	}

	// Search
	// Test using https://localhost:8080/vendor/search?company=SAP
	@RequestMapping("/vendor/search")
	public List<Vendor> searchByCompany(@RequestParam String company) {
		return vendorService.searchByCompanyName(company);
	}

	// Custom Query
	// Way 1: Test using https://localhost:8080/vendor/lookup?GstNo=12
	@RequestMapping("/vendor/lookup")
	public List<Vendor> searchVendorByGST(@RequestParam String GstNo) {
		return vendorService.lookupVendorByGST(GstNo);
	}

	/*
	 * //Custom Query 2 //Way 2: Test using https://localhost:8080/vendor/lookup/12
	 * 
	 * @RequestMapping("/vendor/lookup/{gstNo}") public List<Vendor>
	 * searchVendorByGST(@PathVariable("gstNo") String GstNo) { return
	 * vendorService.lookupVendorByGST(GstNo); }
	 */

}
