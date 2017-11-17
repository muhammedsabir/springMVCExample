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
import com.homework.model.Meeting;
import com.homework.service.DepartmentService;

@Controller
public class MeetingController {

	private DepartmentService departmentService;
	Map<Long, Meeting> meetingMap = new HashMap<>();
	List<Meeting> allMeetings = new ArrayList<Meeting>(); 
	
	/**
	 * ADD FORM
	 * @param model
	 * @return
	 */
	@RequestMapping("/meetingAddForm")
	public String meetingAddForm(Model model) {
		model.addAttribute("meeting", new Meeting());
		populateDefaultModel(model);
		return "/meeting/meetingAddForm";
	}
	

	/**
	 * ADD ACTION
	 * @param employee
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addMeeting", method = RequestMethod.POST)
	public String addMeeting(@ModelAttribute("meeting")  @Validated Meeting meeting, BindingResult result, ModelMap model) {
	    
		if (result.hasErrors()) {
	        return "error";
	    }
	     
		meetingMap.put(meeting.getMeetingId(), meeting);
        allMeetings.add(meeting);
        setDepartmentValueAsStr(allMeetings);
        model.addAttribute("allMeetings", allMeetings);
	        
	    return "/meeting/meetingList";
	}
	
	
	/**
	 * LIST
	 * @param model
	 * @return
	 */
	@RequestMapping("/meetingList")
	public String meetingList(Model model) {
		setDepartmentValueAsStr(allMeetings);
		model.addAttribute("allMeetings", allMeetings);
		return "/meeting/meetingList";
	}
	
	
	/**
	 * SET DEPARTMENT VALUE FOR LIST 
	 * @param allMeetings
	 * @param employeeId
	 */
	private void setDepartmentValueAsStr(List<Meeting> allMeetings){
		for (Iterator<Meeting> iter = allMeetings.listIterator(); iter.hasNext(); ) {
			Meeting meeting = iter.next();
		    if (meeting.getDepartmentId() != 0) {
		    	meeting.setDepartmentAsStr(departmentService.getDepartments().get(new Integer(meeting.getDepartmentId()) ));
		    }
		}
	}
	
	
	/**
	 * DELETE ACTION
	 * @param id
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "/meeting/{id}/delete", method = RequestMethod.POST)
	public String deleteMeeting(@PathVariable("id") Long id, final RedirectAttributes redirectAttributes) {
		removeOldElement(allMeetings, id);
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Meeting is deleted!");
		return "redirect:/meetingList";
	}
	
	
	/**
	 * UPDATE FORM
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/meeting/{id}/update", method = RequestMethod.GET)
	public String showUpdateMeetingForm(@PathVariable("id") Long id, Model model) {
		Meeting selectedMeeting = meetingMap.get(id);
		model.addAttribute("meetingForUpdate", selectedMeeting);
		populateDefaultModel(model);
		return "/meeting/meetingUpdateForm";
	}
	
	/**
	 * UPDATE ACTION
	 * @param meeting
	 * @param result
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateMeeting", method = RequestMethod.POST)
	public String updateMeeting(@ModelAttribute("meetingForUpdate")  @Validated Meeting meeting, 
			BindingResult result, ModelMap model) {
	    
		if (result.hasErrors()) {
	        return "error";
	    }
	     
		meetingMap.put(meeting.getMeetingId(), meeting);
		removeOldElement(allMeetings, meeting.getMeetingId());
		
		allMeetings.add(meeting);
        setDepartmentValueAsStr(allMeetings);
        model.addAttribute("allMeetings", allMeetings);
	        
	    return "/meeting/meetingList";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * REMOVE OLD ARRAY ELEMENT
	 * @param allEmployees
	 * @param employeeId
	 */
	private void removeOldElement(List<Meeting> allEmployees, Long meetingId){
		for (Iterator<Meeting> iter = allMeetings.listIterator(); iter.hasNext(); ) {
			Meeting meeting = iter.next();
		    if (meetingId.longValue() == meeting.getMeetingId()) {
		        iter.remove();
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
