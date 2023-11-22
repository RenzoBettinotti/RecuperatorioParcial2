package ar.edu.unlam.test;

public class TarjetaDeDebito implements Pagadora, Comparable<Pagadora> {

	private Integer num;
	private Double saldo;
	private Boolean escaneado;

	public TarjetaDeDebito(Double saldo, Integer num) {
		this.num = num;
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
			return estado = true;

		}
		throw new SaldoInsuficienteException("El saldo es insuficiente para la compra");
	}

	

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Double getSaldo() {
		return saldo;
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
	public int compareTo(Pagadora o) {
		// TODO Auto-generated method stub
		return this.num.compareTo(o.getNumero());
	}

	@Override
	public Integer getNumero() {
		// TODO Auto-generated method stub
		return this.num;
	}

}
