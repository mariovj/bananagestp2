package com.generation.jwd.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="projects")
public class Projects {
	
	@Id
	@Column(name = "idprojects")
	private int idprojects;
	
	@Id
	@Column(name = "title")
	private String title;
	
	@Id
	@Column(name = "responsible")
	private String responsible;
	
	@Id
	@Column(name = "startdate")
	private Date startdate;
	
	@Id
	@Column(name = "finishdate")
	private Date finishdate;
	
	@Id
	@Column(name = "status")
	private String status ;
	
	@Id
	@Column(name = "description")
	private String description;
	
	@Id
	@Column(name = "notes")
	private String notes;

	public int getIdprojects() {
		return idprojects;
	}

	public void setIdprojects(int idprojects) {
		this.idprojects = idprojects;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public Date getStartdate() {
		return startdate;
	}

	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}

	public Date getFinishdate() {
		return finishdate;
	}

	public void setFinishdate(Date finishdate) {
		this.finishdate = finishdate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	
}
