package ar.edu.unlam.test;

public class PersonaFisica extends Persona {

	private String cuil;

	public PersonaFisica(String n, String d, String c) {
		super(n, d);
		this.cuil = c;
	}

	public String getCuil() {
		return cuil;
	}

	public void setCuil(String cuil) {
		this.cuil = cuil;
	}

	@Override
	public String getCuilCuit() {

		return this.cuil;
	}

}
