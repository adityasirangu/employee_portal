package com.employee.service.history;

import java.util.List;

import com.employee.model.Employee;
import com.employee.model.EmployeeHistory;


public interface HistoryService {
	
	public EmployeeHistory save(Employee employee);
	
	 public List<EmployeeHistory> getHistory(String id);

}
