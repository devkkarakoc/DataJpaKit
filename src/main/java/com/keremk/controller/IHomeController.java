package com.keremk.controller;

import com.keremk.dto.DtoHome;

public interface IHomeController {

	public DtoHome findHomeById(Long id);
}
