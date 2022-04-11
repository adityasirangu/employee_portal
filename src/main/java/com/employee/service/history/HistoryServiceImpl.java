package com.employee.service.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.employee.model.Employee;
import com.employee.model.EmployeeHistory;
import com.employee.repository.EmployeeRepository;
import com.employee.repository.HistoryRepository;

@Service
public class HistoryServiceImpl implements HistoryService {
	
	@Autowired
     private HistoryRepository historyRepository;
	@Override
	public EmployeeHistory save(Employee employee) {
		EmployeeHistory employeeHistory = new EmployeeHistory(employee.getEmpId(), employee.getEmpName(),
				employee.getEmail(), employee.getContactNumber(), employee.getDesignationId(), employee.getAddress(),
				employee.getPassword(), employee.getWorkingExperienceWithCompany(), employee.getBaseSalary(),
				employee.getBonus(), employee.getHRA(), employee.getTravelAllowances(), employee.getMedicalAllowances(),
				"admin");
		return historyRepository.save(employeeHistory) ;
	}
	@Override
	@Cacheable(value = "employeeHistory",key = "#id")
	public List<EmployeeHistory> getHistory(String id) {
		 List<EmployeeHistory> list=historyRepository.getEmployee(id);
		 return list;
		
	}

}
