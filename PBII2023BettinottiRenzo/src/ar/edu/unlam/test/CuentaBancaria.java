package ar.edu.unlam.test;

public class CuentaBancaria implements Transferible, Pagadora, Comparable <Pagadora> {

	private String alias;
	private Integer CBU;
	private Double saldo;
	private Boolean escaneado;

	public CuentaBancaria(String alias, Integer CBU, Double saldo) {
		this.alias = alias;
		this.CBU = CBU;
		this.saldo = saldo;
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
	public Boolean pagar(Persona vendedor, Double importe) throws SaldoInsuficienteException {
		Boolean estado = false;

		if (this.saldo >= importe) {
			
			this.escaneado = true;
			vendedor.cobrar(importe);
			vendedor.escanearQR();
			return estado = true;
		
		}
		throw new SaldoInsuficienteException("El saldo es insuficiente para la compra");
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Integer getCBU() {
		return CBU;
	}

	public void setCBU(Integer cBU) {
		CBU = cBU;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public int compareTo(Pagadora o) {
		// TODO Auto-generated method stub
		return this.CBU.compareTo(o.getNumero());
	}

	@Override
	public Boolean Transferir(Transferible cuenta, Double importe) throws SaldoInsuficienteException{
		Boolean estado = false;
		if(this.saldo >= importe ) {
			this.saldo -= importe;
			cuenta.depositar(importe);
			return estado = true;
		}
		
		throw new SaldoInsuficienteException("El saldo es insuficiente para la transferencia");
		
		
	}

	public Boolean getEscaneado() {
		return escaneado;
	}

	public void setEscaneado(Boolean escaneado) {
		this.escaneado = escaneado;
	}

	@Override
	public Integer getNumero() {
		// TODO Auto-generated method stub
		return this.getCBU();
	}
	
}
