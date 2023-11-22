package ar.edu.unlam.test;

public interface Transferible {

	Double getSaldo();

	void depositar(Double importe);

	Boolean extraer(Double importe) throws SaldoInsuficienteException;

	Boolean Transferir(Transferible cuenta, Double Importe) throws SaldoInsuficienteException;

}
