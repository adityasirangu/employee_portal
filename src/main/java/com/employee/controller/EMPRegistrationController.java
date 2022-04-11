package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;

@Controller
@RequestMapping("/empRegistration")
public class EMPRegistrationController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@ModelAttribute("employee")
	public EmployeeDto employeeDto() {
		return new EmployeeDto();
	}
	
	@PostMapping
	public String registerEmployee(@ModelAttribute("employee") EmployeeDto dto) {
		
		if(employeeService.searchId(dto.getEmpId()))
		{
			return "redirect:/empRegistration?error";
		}
		employeeService.save(dto);
		return "redirect:/empRegistration?success";

	}
	
	@GetMapping
	public String form()
	{
		return "form";
	}

}
