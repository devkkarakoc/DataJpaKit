package com.keremk.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keremk.controller.IAddressController;
import com.keremk.dto.DtoAddress;
import com.keremk.services.IAddressService;

@RestController
@RequestMapping("/rest/api/address")
public class AddressControllerImpl  implements IAddressController{
	
	@Autowired
	IAddressService addressService;
	
	@GetMapping(path = "/list/{id}")
	@Override
	public DtoAddress findAddressByIDtoAddress(@PathVariable(name ="id") Long id) {
		return addressService.findAddressByIDtoAddress(id);
		
	}
	
	

}
