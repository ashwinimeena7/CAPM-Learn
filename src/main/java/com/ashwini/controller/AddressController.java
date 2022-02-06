package com.ashwini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ashwini.entities.Address;
import com.ashwini.service.AddressService;

@RestController
public class AddressController {

	@Autowired
	AddressService addSrv;
	
	@RequestMapping("/addresses")
	public List<Address> readAddresses(){
		return addSrv.readAddresses();
	}
	
	@PostMapping("/addresses")
	public Address createAddress(@RequestBody Address payload){
		return addSrv.createAddress(payload);
	}
}
