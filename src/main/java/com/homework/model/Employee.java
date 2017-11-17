package com.homework.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Employee implements Serializable{

	private static final long serialVersionUID = 6374742178668667162L;
	
	private long employeeId;
	private String name;
    private String surname;
    private BigDecimal salary;
    private int departmentId;
    private String departmentAsStr;
     
	public Employee() {
		
	}
	
	public Employee(long employeeId, String name, String surname, BigDecimal salary, int departmentId) {
		this.employeeId = employeeId;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.departmentId = departmentId;
	}


	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentAsStr() {
		return departmentAsStr;
	}
	public void setDepartmentAsStr(String departmentAsStr) {
		this.departmentAsStr = departmentAsStr;
	}
	
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", departmentId=" + departmentId + "]";
	}
    
    
}
