package ar.edu.unlam.test;

public class CuentaVirtual implements Pagadora, Comparable<Pagadora>, Transferible {

	private Integer CVU;
	private Double saldo;
	private Boolean escaneado;

	public CuentaVirtual(Double saldo, Integer CVU) {
		this.CVU = CVU;
		this.saldo = saldo;
		this.escaneado = false;
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws SaldoInsuficienteException {
		Boolean estado = false;
		if (this.saldo >= importe) {
			this.escaneado = true;
			vendedor.cobrar(importe);
			vendedor.escanearQR();
			this.saldo -= importe;
			return estado = true;

		}
		throw new SaldoInsuficienteException("El saldo es insuficiente para la compra");
	}

	public Integer getCVU() {
		return CVU;
	}

	public void setCVU(Integer cVU) {
		CVU = cVU;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Boolean getEscaneado() {
		return escaneado;
	}

	public void setEscaneado(Boolean escaneado) {
		this.escaneado = escaneado;
	}

	@Override
	public Double getSaldo() {

		return this.saldo;
	}

	@Override
	public void depositar(Double importe) {
		this.saldo += importe;

	}

	@Override
	public Boolean extraer(Double importe) throws SaldoInsuficienteException {
		Boolean estado = false;
		if (importe <= this.saldo) {
			this.saldo -= importe;
			return estado = true;
		}

		throw new SaldoInsuficienteException("El saldo es insuficiente para la transferencia");

	}

	@Override
	public Boolean Transferir(Transferible cuenta, Double importe) throws SaldoInsuficienteException {
		Boolean estado = false;
		if (this.saldo >= importe) {
			this.saldo -= importe;
			cuenta.depositar(importe);
			return estado = true;
		}

		throw new SaldoInsuficienteException("El saldo es insuficiente para la transferencia");

	}

	@Override
	public int compareTo(Pagadora o) {
		// TODO Auto-generated method stub
		return this.CVU.compareTo(o.getNumero());
	}

	@Override
	public Integer getNumero() {
		// TODO Auto-generated method stub
		return this.CVU;
	}

}
