package com.homework.controller;

import java.util.ArrayList;
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

import com.homework.model.Employee;
import com.homework.service.DepartmentService;


/**
 * 1- Sadece Map tutulsa, Map to List fonksiyonu olsa !
 * 2- Hardcoded kisimlari constant yap
 * 3- Null control vs de yapilmali
 * 4- auto validasyon
 * 5- auto inc id
 * @author a557854
 *
 */

@Controller
public class EmployeeController {

	private DepartmentService departmentService;
	Map<Long, Employee> employeeMap = new HashMap<>();
	List<Employee> allEmployees = new ArrayList<Employee>(); 
	
	/**
	 * ADD FORM
	 * @param model
	 * @return
	 */
	@RequestMapping("/employeeAddForm")
	public String employeeAddForm(Model model) {
		model.addAttribute("employee", new Employee());
		populateDefaultModel(model);
		return "/employee/employeeAddForm";
	}
	
	/**
	 * ADD ACTION
	 * @param employee
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("employee")  @Validated Employee employee, BindingResult result, ModelMap model) {
	    
		if (result.hasErrors()) {
	        return "error";
	    }
	     
		employeeMap.put(employee.getEmployeeId(), employee);
        allEmployees.add(employee);
        setDepartmentValueAsStr(allEmployees);
        model.addAttribute("allEmployees", allEmployees);
	        
	    return "/employee/employeeList";
	}
	
	/**
	 * UPDATE FORM
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/employee/{id}/update", method = RequestMethod.GET)
	public String showUpdateEmployeeForm(@PathVariable("id") Long id, Model model) {
		Employee selectedEmployee = employeeMap.get(id);
		model.addAttribute("employeeForUpdate", selectedEmployee);
		populateDefaultModel(model);
		return "/employee/employeeUpdateForm";
	}
	
	/**
	 * UPDATE ACTION
	 * @param employee
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("employeeForUpdate")  @Validated Employee employee, BindingResult result, ModelMap model) {
	    
		if (result.hasErrors()) {
	        return "error";
	    }
	     
		employeeMap.put(employee.getEmployeeId(), employee);
		removeOldElement(allEmployees, employee.getEmployeeId());
		
        allEmployees.add(employee);
        setDepartmentValueAsStr(allEmployees);
        model.addAttribute("allEmployees", allEmployees);
	        
	    return "/employee/employeeList";
	}
	
	/**
	 * LIST
	 * @param model
	 * @return
	 */
	@RequestMapping("/employeeList")
	public String employeeList(Model model) {
		setDepartmentValueAsStr(allEmployees);
		model.addAttribute("allEmployees", allEmployees);
		return "/employee/employeeList";
	}
	
	/**
	 * DELETE ACTION
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/employee/{id}/delete", method = RequestMethod.POST)
	public String deleteEmployee(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
		removeOldElement(allEmployees, id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Employee is deleted!");
		return "redirect:/employeeList";
	}
	
	/**
	 * REMOVE OLD ARRAY ELEMENT
	 * @param allEmployees
	 * @param employeeId
	 */
	private void removeOldElement(List<Employee> allEmployees, Long employeeId){
		for (Iterator<Employee> iter = allEmployees.listIterator(); iter.hasNext(); ) {
			Employee emp = iter.next();
		    if (employeeId.longValue() == emp.getEmployeeId()) {
		        iter.remove();
		    }
		}
	}
	

	/**
	 * SET DEPARTMENT VALUE FOR LIST 
	 * @param allEmployees
	 * @param employeeId
	 */
	private void setDepartmentValueAsStr(List<Employee> allEmployees){
		for (Iterator<Employee> iter = allEmployees.listIterator(); iter.hasNext(); ) {
			Employee emp = iter.next();
		    if (emp.getDepartmentId() != 0) {
		        emp.setDepartmentAsStr(departmentService.getDepartments().get(new Integer(emp.getDepartmentId()) ));
		    }
		}
	}
	
	
	private void populateDefaultModel(Model model) {
		model.addAttribute("departmentList", departmentService.getDepartments());
	}
	
	@Autowired
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
}
