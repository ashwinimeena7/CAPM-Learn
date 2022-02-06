package com.ashwini.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashwini.entities.Address;

public interface IAddressPersistence  extends JpaRepository<Address, Long>{
	
}
