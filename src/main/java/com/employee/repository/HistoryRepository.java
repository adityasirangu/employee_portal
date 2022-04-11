package com.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.model.EmployeeHistory;

@Repository
public interface HistoryRepository extends JpaRepository<EmployeeHistory, Long> {
	
	@Query("SELECT  emp FROM EmployeeHistory emp WHERE emp.empId=:eid")
	public List<EmployeeHistory> getEmployee(@Param("eid") String id);

}
