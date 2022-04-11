package com.employee.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDto;
import com.employee.model.Employee;
import com.employee.model.EmployeeHistory;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	 private EmployeeRepository employeeRepository;

	@Override
	public Employee save(EmployeeDto employeeDto) {
		Employee employee = new Employee(employeeDto.getEmpId(), employeeDto.getEmpName(), employeeDto.getEmail(),
				employeeDto.getContactNumber(), employeeDto.getDesignationId(), employeeDto.getAddress(),
				employeeDto.getPassword(), employeeDto.getWorkingExperienceWithCompany(), employeeDto.getBaseSalary(),
				employeeDto.getBonus(), employeeDto.getHRA(), employeeDto.getTravelAllowances(),
				employeeDto.getMedicalAllowances());
		return employeeRepository.save(employee);
		
	}

	@Override
	public Boolean Auth(String id, String password) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee != null && (employee.get().getPassword().equals(password))) {
			return true;
		}
		return false;
	}

	
	@Override
	@Cacheable(value = "employees",key = "#id")
	public Employee getUser(String id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee != null) {
			return employee.get();
		}
		return null;
	}

	@Override
	public Boolean searchId(String id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee==null)
		{
			return true;
		}
		return false;
		
	}

	@Override
	@CachePut(value = "employees",key = "#id")
	public Employee update(String id,EmployeeDto employeeDto) {
		//Employee employeeDto = employeeRepository.getById(id);
		Employee employee = new Employee(employeeDto.getEmpId(), employeeDto.getEmpName(), employeeDto.getEmail(),
				employeeDto.getContactNumber(), employeeDto.getDesignationId(), employeeDto.getAddress(),
				employeeDto.getPassword(), employeeDto.getWorkingExperienceWithCompany(), employeeDto.getBaseSalary(),
				employeeDto.getBonus(), employeeDto.getHRA(), employeeDto.getTravelAllowances(),
				employeeDto.getMedicalAllowances());
		return employeeRepository.save(employee);
	}

	
}
