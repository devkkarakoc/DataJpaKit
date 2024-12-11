package com.keremk.services;

import com.keremk.dto.DtoHome;

public interface IHomeService {
	
	public DtoHome findHomeById(Long id);
}
