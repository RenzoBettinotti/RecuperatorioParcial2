package ar.edu.unlam.test;

import java.util.TreeSet;

public class Personas {

	private TreeSet<Persona> personas;

	public Personas() {
		this.personas = new TreeSet<Persona>();
	}

	public void añadirPersona(Persona persona) {
		this.personas.add(persona);
	}

	public TreeSet<Persona> getPersonas() {
		return personas;
	}

	public void setPersonas(TreeSet<Persona> personas) {
		this.personas = personas;
	}

}
