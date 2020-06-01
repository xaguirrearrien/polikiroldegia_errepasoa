package modelo.bean;

import java.util.ArrayList;
import java.util.Date;

public class Actividad {
	
	private int id;
	private String nombre;
	private Date fechaInicio;
	private String diasSemana;
	private int horas;
	private int maxParticipantes;
	private double precio;
	
	private ArrayList<Inscripcion> inscripciones;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getDiasSemana() {
		return diasSemana;
	}

	public void setDiasSemana(String diasSemana) {
		this.diasSemana = diasSemana;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

	public int getMaxParticipantes() {
		return maxParticipantes;
	}

	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public ArrayList<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	@Override
	public String toString() {
		return "Actividad [id=" + id + ", nombre=" + nombre + ", fechaInicio=" + fechaInicio + ", diasSemana="
				+ diasSemana + ", horas=" + horas + ", maxParticipantes=" + maxParticipantes + ", precio=" + precio
				+ "]";
	}

	
	
	

}
