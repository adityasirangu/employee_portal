package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dto.EmployeeDto;
import com.employee.service.EmployeeService;
import com.employee.service.history.HistoryService;
@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private HistoryService historyService;
	
	@GetMapping("/Employeelogin")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("employee-login");
		EmployeeDto newEmployee = new EmployeeDto();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	
	@PostMapping("/authEmployees")
	public String AuthEmployee(@ModelAttribute EmployeeDto dto) {
		
		if(employeeService.Auth(dto.getEmpId(), dto.getPassword()))
		{
			System.out.println("done");
			return "redirect:/login/employeeDetails/"+dto.getEmpId();
		}
		
		return "redirect:/Employeelogin?error";
	}
	
	@GetMapping("/login/employeeDetails/{id}")
	public ModelAndView getUser(@PathVariable String id){
		ModelAndView mav = new ModelAndView("employee-details");
		mav.addObject("employees",employeeService.getUser(id));
		return mav;
        
    
    }
	
	@GetMapping("/showSalary")
	public ModelAndView showUpdateForm(@RequestParam String employeeId) {
		ModelAndView mav = new ModelAndView("SalaryHistory");
		System.out.println( historyService.getHistory(employeeId));
		mav.addObject("employees", historyService.getHistory(employeeId));
		return mav;
	}
	

}
