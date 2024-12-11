package com.keremk.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;


@Component
@ConfigurationProperties(prefix = "app")
@Data
public class GlobalProperties {
	
	private  List<Server> servers;
	
	@Value("${key}")
	private String key;
}
