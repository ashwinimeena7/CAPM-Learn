package com.ashwini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwini.entities.Vendor;

@Component
public class VendorService {
	
	@Autowired
	IVendorPersistence vendor;
	
	public List<Vendor> readAllVendors(){
		return vendor.findAll();
	}
	
	public Vendor getSingleVendor(Long id) {
		Optional<Vendor> searchResult = vendor.findById(id);
		if (!searchResult.isPresent()) {
			return new Vendor((long) 0, "", "", "", "", "", "", null);
		}
		return searchResult.get();
	}
	
	public Vendor createVendor(Vendor vendorObj) {
		return vendor.save(vendorObj);
	}
	
	public Vendor changeVendor(Vendor payload) {
		Optional<Vendor> myVendor = vendor.findById(payload.getId());
		if(!myVendor.isPresent()) {
			return new Vendor((long) 0, "", "", "", "", "", "", null);
		}
		return vendor.save(payload);
	}
	
	public String deleteVendor(Long id) {
		vendor.deleteById(id);
		return "Deleted Successfully";
	}
	
	public List<Vendor> searchByCompanyName(String companyName) {
		return vendor.findByCompanyName(companyName);
	}
	
	public List<Vendor> lookupVendorByGST(String GSTNo){
		return vendor.lookupVendorByGST(GSTNo);
	}
	
}
