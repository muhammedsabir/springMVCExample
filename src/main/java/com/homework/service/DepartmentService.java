package com.homework.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.homework.model.Department;

@Service
public class DepartmentService {

	Map<Integer, String> departments;
	Map<Integer, Department> departmentMap;
	List<Department> allDepartments = new ArrayList<Department>();
	
	
	@PostConstruct
	private void init(){
		Department dep1 = new Department(1, "IT", "IT Section");
		Department dep2 = new Department(2, "Finance", "Finance Section");
		Department dep3 = new Department(3, "Other", "Other Section");
		allDepartments.add(dep1);
		allDepartments.add(dep2);
		allDepartments.add(dep3);
		populateDepartmentValues();
	}
	
	public void populateDepartmentValues(){
		departments = new LinkedHashMap<Integer, String>();
		departmentMap = new HashMap<>();
		
		for (Iterator iterator = allDepartments.iterator(); iterator.hasNext();) {
			Department dep = (Department) iterator.next();
			departments.put(dep.getDepartmentId(), dep.getName());
			departmentMap.put(dep.getDepartmentId(), dep);
		}
	}

	
	public Map<Integer, String> getDepartments() {
		return departments;
	}

	public void setDepartments(Map<Integer, String> departments) {
		this.departments = departments;
	}
	
	public List<Department> getAllDepartments() {
		return allDepartments;
	}

	public void setAllDepartments(List<Department> allDepartments) {
		this.allDepartments = allDepartments;
	}

	public Map<Integer, Department> getDepartmentMap() {
		return departmentMap;
	}

	public void setDepartmentMap(Map<Integer, Department> departmentMap) {
		this.departmentMap = departmentMap;
	}
	
}
