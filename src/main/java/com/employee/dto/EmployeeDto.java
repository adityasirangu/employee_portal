package com.employee.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class EmployeeDto {

	private String empId;
	private String empName;
	private String email;
	private String contactNumber;
	private String designationId;
	private String address;
	private String password;
	private int workingExperienceWithCompany;
	private long baseSalary;
	private long Bonus;
	private long HRA;
	private long travelAllowances;
	private long medicalAllowances;
	public EmployeeDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EmployeeDto(String empId, String empName, String email, String contactNumber, String designationId,
			String address, String password, int workingExperienceWithCompany, long baseSalary, long bonus, long hRA,
			long travelAllowances, long medicalAllowances) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.email = email;
		this.contactNumber = contactNumber;
		this.designationId = designationId;
		this.address = address;
		this.password = password;
		this.workingExperienceWithCompany = workingExperienceWithCompany;
		this.baseSalary = baseSalary;
		Bonus = bonus;
		HRA = hRA;
		this.travelAllowances = travelAllowances;
		this.medicalAllowances = medicalAllowances;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getDesignationId() {
		return designationId;
	}
	public void setDesignationId(String designationId) {
		this.designationId = designationId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getWorkingExperienceWithCompany() {
		return workingExperienceWithCompany;
	}
	public void setWorkingExperienceWithCompany(int workingExperienceWithCompany) {
		this.workingExperienceWithCompany = workingExperienceWithCompany;
	}
	public long getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(long baseSalary) {
		this.baseSalary = baseSalary;
	}
	public long getBonus() {
		return Bonus;
	}
	public void setBonus(long bonus) {
		Bonus = bonus;
	}
	public long getHRA() {
		return HRA;
	}
	public void setHRA(long hRA) {
		HRA = hRA;
	}
	public long getTravelAllowances() {
		return travelAllowances;
	}
	public void setTravelAllowances(long travelAllowances) {
		this.travelAllowances = travelAllowances;
	}
	public long getMedicalAllowances() {
		return medicalAllowances;
	}
	public void setMedicalAllowances(long medicalAllowances) {
		this.medicalAllowances = medicalAllowances;
	}
	@Override
	public String toString() {
		return "EmployeeDto [empId=" + empId + ", empName=" + empName + ", email=" + email + ", contactNumber="
				+ contactNumber + ", designationId=" + designationId + ", address=" + address + ", password=" + password
				+ ", workingExperienceWithCompany=" + workingExperienceWithCompany + ", baseSalary=" + baseSalary
				+ ", Bonus=" + Bonus + ", HRA=" + HRA + ", travelAllowances=" + travelAllowances
				+ ", medicalAllowances=" + medicalAllowances + "]";
	}
	

}
