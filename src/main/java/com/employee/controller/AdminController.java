package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.repository.EmployeeRepository;
import com.employee.service.EmployeeService;
import com.employee.service.history.HistoryService;

@Controller
public class AdminController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeRepository repository;
	
	@Autowired
	private HistoryService historyService;

	
	//login page
	@GetMapping("/Adminlogin")
	public ModelAndView loginForm() {
		ModelAndView mav = new ModelAndView("login");
		EmployeeDto newEmployee = new EmployeeDto();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	//login page authorization
	@PostMapping("/authEmployee")
	public String AuthEmployee(@ModelAttribute EmployeeDto dto) {
		//employeeService.save(employee);
		if(dto.getEmpId().equals("admin")&&dto.getPassword().equals("admin")) {
			 return "redirect:/login/employees";
		}
		return "redirect:/login?error";
	}
	
	//admin page list of employees
	@GetMapping("/login/employees")
	public ModelAndView getAllEmployees() {
		ModelAndView mav = new ModelAndView("list-employees");
		mav.addObject("employees", repository.findAll());
		return mav;
	}
	
	//admin add employee option
	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployees() {
		ModelAndView mav = new ModelAndView("adminAddEmployeeForm");
		EmployeeDto newEmployee = new EmployeeDto();
		mav.addObject("employee", newEmployee);
		return mav;
	}
	//save employee
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute EmployeeDto employee) {
		employeeService.update(employee.getEmpId(),employee);
		return "redirect:/login/employees";
	}
	
	//updation by admin and storing in history database
	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam String employeeId) {
		ModelAndView mav = new ModelAndView("adminAddEmployeeForm");
		Employee employee = repository.findById(employeeId).get();
		historyService.save(employee);
		mav.addObject("employee", employee);
		return mav;
	}
	
	
	
	

}



