package com.keremk.dto;

import java.sql.Date;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoStudentIU {
	
	private String firstName;
	@Size(min = 3,max = 5,message = "Yazı Boyutu 3 ile 30 arasında olmalı")
	private String lastName;
	private Date birthOfDate;
}
