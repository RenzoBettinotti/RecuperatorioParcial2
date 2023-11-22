package ar.edu.unlam.test;

import java.util.TreeSet;

public abstract class Persona implements Comparable<Persona>{

	private Double fondos;
	private Boolean escaneado;
	private String dni;
	private String nombre;

	public Persona(String n, String d) {
		this.nombre = n;
		this.dni = d;
		this.fondos = 0.0;
		this.escaneado = false;

	}

	public void cobrar(Double importe) {
		this.fondos += importe;
	}

	public Boolean escanearQR() {
		return this.escaneado = true;
	}

	public Double getFondos() {
		return fondos;
	}

	public void setFondos(Double fondos) {
		this.fondos = fondos;
	}

	public Boolean getEscaneado() {
		return escaneado;
	}

	public void setEscaneado(Boolean escaneado) {
		this.escaneado = escaneado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public abstract String getCuilCuit();
	
	@Override
	public int compareTo(Persona o) {
		// TODO Auto-generated method stub
		return this.getCuilCuit().compareTo(o.getCuilCuit());
	}
	
}
