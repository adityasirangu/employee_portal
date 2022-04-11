package com.employee.service;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.model.EmployeeHistory;

public interface EmployeeService {
	public Employee save(EmployeeDto employeeDto);
	public Boolean Auth(String id, String password);
	public Employee getUser(String id);
	public Boolean searchId(String id);
	public Employee update(String id,EmployeeDto employeeDto);
	
	

}
