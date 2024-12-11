package com.keremk.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keremk.controller.IEmployeeController;
import com.keremk.dto.DtoEmployee;
import com.keremk.services.IEmployeeService;

@RestController
@RequestMapping("/rest/api/employee")
public class EmployeeControllerImpl implements IEmployeeController {

	@Autowired
	IEmployeeService employeeService;

	@GetMapping(path = "/list")
	@Override
	public List<DtoEmployee> getAllEmployes() {

		return employeeService.getAllEmployes();

	}

}
