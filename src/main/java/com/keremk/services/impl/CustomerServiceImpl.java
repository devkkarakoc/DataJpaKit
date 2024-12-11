package com.keremk.services.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keremk.dto.DtoAddress;
import com.keremk.dto.DtoCustomer;
import com.keremk.entites.Address;
import com.keremk.entites.Customer;
import com.keremk.repository.CustomerRepository;
import com.keremk.services.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public DtoCustomer findCustomerById(Long id) {
		
		DtoCustomer dtoCustomer = new DtoCustomer();
		DtoAddress dtoAddress = new DtoAddress();
		Optional<Customer> customerOptional =  customerRepository.findById(id);
		
		if(customerOptional.isEmpty()) {
			return null;
		}else {
			Customer dbCustomer = customerOptional.get();
			Address dbAddress = customerOptional.get().getAddress();
			
			
			BeanUtils.copyProperties(dbCustomer,dtoCustomer);
			BeanUtils.copyProperties(dbAddress, dtoAddress);
			
			dtoCustomer.setAddress(dtoAddress);
			return dtoCustomer;
			
		}
		
	}

}
