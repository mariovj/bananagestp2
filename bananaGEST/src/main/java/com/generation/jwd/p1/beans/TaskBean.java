package com.generation.jwd.p1.beans;

import java.io.Serializable;
import java.util.Date;

public class TaskBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idtasks;
	private String nombretarea;
	private String descripcion;
	private String responsable;
	private Date fechainicio;
	private Date fechafin;
	
	public TaskBean() {};
	
	public TaskBean(int idtasks, String nombretarea, String descripcion, String responsable, 
			Date fechainicio, Date fechafin) {
		
		this.idtasks = idtasks;
		this.nombretarea = nombretarea;
		this.descripcion = descripcion;
		this.responsable = responsable;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
	}

	public TaskBean(String idtasks2, String nombretarea2, String descripcion2, String responsable2,
			String fechainicio2, String fechafin2) {

		this.idtasks = idtasks;
		this.nombretarea = nombretarea;
		this.descripcion = descripcion;
		this.responsable = responsable;
		this.fechainicio = fechainicio;
		this.fechafin = fechafin;
	}

	public int getidtasks() {
		return idtasks;
	}

	public void setidtasks(int idtasks) {
		this.idtasks = idtasks;
	}
	
	public String getnombretarea() {
		return nombretarea;
	}
	
	public void setnombretarea(String nombretarea) {
		this.nombretarea = nombretarea;
	}

	public String getdescripcion() {
		return descripcion;
	}

	public void setdescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getresponsable() {
		return responsable;
	}

	public void setresponsable(String responsable) {
		this.responsable = responsable;
	}

	public Date getfechainicio() {
		return fechainicio;
	}

	public void setfechainicio(Date fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Date getfechafin() {
		return fechafin;
	}

	public void setfechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	
	public boolean validate () {
		return this.nombretarea.equals("Task");
	}
}


