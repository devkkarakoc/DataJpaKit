package com.keremk.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keremk.configuration.DataSource;
import com.keremk.configuration.GlobalProperties;
import com.keremk.configuration.Server;

@RestController
@RequestMapping("/rest/api/property")
public class PropertySourceController {
	
	@Autowired
	private GlobalProperties globalProperties;
	
	@GetMapping(path = "/datasource")
	public DataSource getPropertyDataSource() {
		
		
		return null;
	}
	
	@GetMapping(path  = "/getServers")
	public List<Server> getServers(){
		System.out.println("Key Değerim =  "+globalProperties.getKey());
		
	 return	globalProperties.getServers();
		
	}
	
}
