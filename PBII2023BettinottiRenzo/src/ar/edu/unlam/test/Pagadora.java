package ar.edu.unlam.test;

public interface Pagadora {

	public Boolean pagar(Persona vendedor, Double importe) throws SaldoInsuficienteException, ExcedeLimiteDeCompraException;
	public Integer getNumero();
	
}
