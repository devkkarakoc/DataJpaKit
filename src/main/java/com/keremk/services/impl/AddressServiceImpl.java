package com.keremk.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keremk.dto.DtoAddress;
import com.keremk.dto.DtoCustomer;
import com.keremk.entites.Address;
import com.keremk.repository.AddressRepository;
import com.keremk.services.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public DtoAddress findAddressByIDtoAddress(Long id) {

		DtoAddress dtoAddress = new DtoAddress();

		Optional<Address> dbAddress = addressRepository.findById(id);

		if (dbAddress.isEmpty()) {
			return null;
		} else {
			Address address = dbAddress.get();
			BeanUtils.copyProperties(address, dtoAddress);

			DtoCustomer dtoCustomer = new DtoCustomer();

			dtoCustomer.setId(address.getCustomer().getId());
		//	dtoCustomer.setAddress(dtoAddress);
			dtoCustomer.setName(address.getCustomer().getName());

			dtoAddress.setDtoCustomer(dtoCustomer);

			return dtoAddress;

		}

	}

}
