package com.homework.controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.homework.model.Department;
import com.homework.service.DepartmentService;

@Controller
public class DepartmentController {

	private DepartmentService departmentService;
	
	/**
	 * ADD FORM
	 * @param model
	 * @return
	 */
	@RequestMapping("/departmentAddForm")
	public String departmentAddForm(Model model) {
		model.addAttribute("department", new Department());
		return "/department/departmentAddForm";
	}
	
	/**
	 * ADD ACTION
	 * @param employee
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
	public String addDepartment(@ModelAttribute("department")  @Validated Department department, BindingResult result, ModelMap model) {
	    
		if (result.hasErrors()) {
	        return "error";
	    }
	     
		//departmentService.getDepartmentMap().put(department.getDepartmentId(), department);
		departmentService.getAllDepartments().add(department);
		departmentService.populateDepartmentValues();
        model.addAttribute("allDepartments", departmentService.getAllDepartments());
	        
	    return "/department/departmentList";
	}
	
	/**
	 * UPDATE FORM
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/department/{id}/update", method = RequestMethod.GET)
	public String showUpdateDepartmentForm(@PathVariable("id") Integer id, Model model) {
		Department selectedDepartment = departmentService.getDepartmentMap().get(id);
		model.addAttribute("departmentForUpdate", selectedDepartment);
		return "/department/departmentUpdateForm";
	}
	
	/**
	 * UPDATE ACTION
	 * @param employee
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateDepartment", method = RequestMethod.POST)
	public String updateDepartment(@ModelAttribute("departmentForUpdate")  @Validated Department department, BindingResult result, ModelMap model) {
	    
		if (result.hasErrors()) {
	        return "error";
	    }
	     
		//departmentService.getDepartmentMap().put(department.getDepartmentId(), department);
		removeOldElement(departmentService.getAllDepartments(), department.getDepartmentId());
		
		departmentService.getAllDepartments().add(department);
        departmentService.populateDepartmentValues();
        model.addAttribute("allDepartments", departmentService.getAllDepartments());
	        
	    return "/department/departmentList";
	}
	
	
	/**
	 * DELETE ACTION
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/department/{id}/delete", method = RequestMethod.POST)
	public String deleteDepartment(@PathVariable("id") Integer id, final RedirectAttributes redirectAttributes) {
		removeOldElement(departmentService.getAllDepartments(), id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Department is deleted!");
		return "redirect:/departmentList";
	}
	
	/**
	 * LIST
	 * @param model
	 * @return
	 */
	@RequestMapping("/departmentList")
	public String departmentList(Model model) {
		model.addAttribute("allDepartments", departmentService.getAllDepartments());
		return "/department/departmentList";
	}
	
	/**
	 * REMOVE OLD ARRAY ELEMENT
	 * @param allEmployees
	 * @param employeeId
	 */
	private void removeOldElement(List<Department> allDepartments, Integer departmentId){
		for (Iterator<Department> iter = allDepartments.listIterator(); iter.hasNext(); ) {
			Department dep = iter.next();
		    if (departmentId.longValue() == dep.getDepartmentId()) {
		        iter.remove();
		    }
		}
	}
	
	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
}
