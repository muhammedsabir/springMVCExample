package com.homework.model;

import java.io.Serializable;

public class Meeting implements Serializable{

	private static final long serialVersionUID = 8360431578980667849L;
	private long meetingId;
	private String name;
	private String description;
	private int departmentId;
	private String departmentAsStr;
	
	public Meeting() {
	}

	public Meeting(long meetingId, String name, String description, int departmentId, String departmentAsStr) {
		this.meetingId = meetingId;
		this.name = name;
		this.description = description;
		this.departmentId = departmentId;
		this.departmentAsStr = departmentAsStr;
	}

	public long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(long meetingId) {
		this.meetingId = meetingId;
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
		return "Meeting [name=" + name + ", description=" + description + ", departmentId=" + departmentId
				+ ", departmentAsStr=" + departmentAsStr + "]";
	}
	 
	 
	
}
