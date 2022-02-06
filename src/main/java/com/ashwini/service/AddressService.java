package com.ashwini.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashwini.entities.Address;

@Component
public class AddressService {

	@Autowired
	IAddressPersistence address;
	
	public List<Address> readAddresses(){
		return address.findAll();
	}
	
	public Address createAddress(Address payload){
		return address.save(payload);
	}
}
