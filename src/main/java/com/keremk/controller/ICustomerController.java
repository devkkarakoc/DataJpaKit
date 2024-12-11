package com.keremk.controller;

import com.keremk.dto.DtoCustomer;

public interface ICustomerController {

	public DtoCustomer findCustomerById(Long id);
	
}
