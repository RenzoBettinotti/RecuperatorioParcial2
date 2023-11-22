package ar.edu.unlam.test;

public class TarjetaDeCredito implements Pagadora, Comparable<Pagadora> {

	private Integer num;
	private Boolean limiteAlcanzado;
	private Double limiteCompra;
	private Boolean escaneado;

	public TarjetaDeCredito(Double limite, Integer num) {

		this.num = num;
		this.limiteCompra = limite;
		this.limiteAlcanzado = false;
		this.escaneado = false;
	}

	@Override
	public Boolean pagar(Persona vendedor, Double importe) throws ExcedeLimiteDeCompraException {
		Boolean estado = false;
		if (this.limiteCompra >= importe) {
			
			this.escaneado = true;
			vendedor.cobrar(importe);
			vendedor.escanearQR();
			return estado = true;

		} else if (this.limiteCompra < importe) {
			this.limiteAlcanzado = true;
		}
		throw new ExcedeLimiteDeCompraException("El movimiento excede el limite de la tarjeta");
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public Boolean getLimiteAlcanzado() {
		return limiteAlcanzado;
	}

	public void setLimiteAlcanzado(Boolean limiteAlcanzado) {
		this.limiteAlcanzado = limiteAlcanzado;
	}

	public Double getLimiteCompra() {
		return limiteCompra;
	}

	public void setLimiteCompra(Double limiteCompra) {
		this.limiteCompra = limiteCompra;
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
