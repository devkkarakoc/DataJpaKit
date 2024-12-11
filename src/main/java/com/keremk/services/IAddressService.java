package com.keremk.services;

import com.keremk.dto.DtoAddress;

public interface IAddressService {

	public DtoAddress findAddressByIDtoAddress(Long id);
}
