package com.homework.model;

import java.io.Serializable;

public class Department implements Serializable{
	private static final long serialVersionUID = 183655628093865673L;
	
	private int departmentId;
	private String name;
	private String description;
	
	
	public Department() {
	}
	
	public Department(int departmentId, String name, String description) {
		this.departmentId = departmentId;
		this.name = name;
		this.description = description;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", name=" + name + ", description=" + description + "]";
	}

	
}
