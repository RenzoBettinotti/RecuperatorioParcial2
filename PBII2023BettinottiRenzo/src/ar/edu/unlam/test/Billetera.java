package ar.edu.unlam.test;

import java.util.TreeSet;

public class Billetera {

	private TreeSet<Pagadora> medios;

	public Billetera() {
		this.medios = new TreeSet<Pagadora>();
	}

	public void agregarMedio(Pagadora medio) {
		this.medios.add(medio);
	}

	public TreeSet<Pagadora> getMedios() {
		return medios;
	}

	public void setMedios(TreeSet<Pagadora> medios) {
		this.medios = medios;
	}

}
