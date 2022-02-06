package com.ashwini.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ashwini.entities.Vendor;

@RepositoryRestResource(collectionResourceRel = "vendor", path = "newVendor")
public interface IVendorControllerNew extends JpaRepository<Vendor, Long>{

}
