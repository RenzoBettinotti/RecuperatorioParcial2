package ar.edu.unlam.test;

import java.util.TreeSet;

public class PersonaJuridica extends Persona {

	private String qr;
	private String cuit;

	public PersonaJuridica(String n, String d, String cuit, String qr) {
		super(n, d);
		this.qr = qr;
		this.cuit = cuit;

	}

	public String getQr() {
		return qr;
	}

	public void setQr(String qr) {
		this.qr = qr;
	}

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}



	@Override
	public String getCuilCuit() {
		// TODO Auto-generated method stub
		return this.cuit;
	}

}
