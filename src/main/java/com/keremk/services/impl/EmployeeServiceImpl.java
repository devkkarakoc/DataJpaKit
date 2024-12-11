package com.keremk.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.keremk.dto.DtoDepartment;
import com.keremk.dto.DtoEmployee;
import com.keremk.entites.Employee;
import com.keremk.repository.EmployeeRepository;
import com.keremk.services.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService  {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public List<DtoEmployee> getAllEmployes() {
		List<DtoEmployee> dtoEmployeeList = new ArrayList<>();
		
		List<Employee> employeeList = employeeRepository.findAll();
		if(employeeList!=null && !employeeList.isEmpty()) {
			for (Employee employee : employeeList) {
				
				DtoEmployee dtoEmployee = new DtoEmployee();
				BeanUtils.copyProperties(employee, dtoEmployee);
				
				dtoEmployee.setDtoDepartment(new DtoDepartment(employee.getDepartment().getId(),employee.getDepartment().getDepartmentName()));
				dtoEmployeeList.add(dtoEmployee);
				
			}
			
			
		}
		
		return dtoEmployeeList;
		
		
	}

	
}
