package com.keremk.controller;

import com.keremk.dto.DtoAddress;

public interface IAddressController {
	
	DtoAddress findAddressByIDtoAddress(Long id);

}
