package ar.edu.unlam.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

public class testMercado {

	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDePersonas() {

		String nombre = "Renzo";
		String dni = "45318159";
		String cuit = "123";
		String qr = "jhjfhjhfs";
		Persona vendedor = new PersonaJuridica(nombre, dni, cuit, qr);

		String nombre2 = "Alberto";
		String dni2 = "45318159";
		String cuit2 = "456";
		String qr2 = "jhjfhjhfs";
		Persona vendedor2 = new PersonaJuridica(nombre2, dni2, cuit2, qr);

		String nombre3 = "R";
		String dni3 = "45318159";
		String cuil = "789";
		Persona comprador = new PersonaFisica(nombre3, dni3, cuil);

		Personas personas = new Personas();

		personas.añadirPersona(comprador);
		personas.añadirPersona(vendedor);
		personas.añadirPersona(vendedor2);

		TreeSet<Persona> orden = new TreeSet<Persona>(personas.getPersonas());
		int i = 1;
		for (Persona persona : orden) {
			switch (i) {
			case 1:
				assertTrue(persona.getCuilCuit().equals(vendedor.getCuilCuit()));
				break;

			case 2:
				assertTrue(persona.getCuilCuit().equals(vendedor2.getCuilCuit()));
				break;

			case 3:
				assertTrue(persona.getCuilCuit().equals(comprador.getCuilCuit()));
				break;
			default:
				break;
			}
			i++;
		}

	}

	@Test
	public void queSePuedanAlmacenarLosDistintosTiposDeTransacciones() {

		Double saldo = 50000.0;
		Integer numD = 12;

		TarjetaDeDebito tarjetaDebito = new TarjetaDeDebito(saldo, numD);

		Double limite = 50000.0;
		Integer numC = 34;

		TarjetaDeCredito tarjetaCredito = new TarjetaDeCredito(limite, numC);

		Integer CVU = 56;

		CuentaVirtual cuentaVirtual = new CuentaVirtual(saldo, CVU);

		String alias = "renzo.b.222";
		Integer CBU = 78;
		Double saldoCuenta = 100000.0;

		CuentaBancaria cuentaBancaria = new CuentaBancaria(alias, CBU, saldoCuenta);
		
		
		Billetera billetera = new Billetera();
	
		billetera.agregarMedio(tarjetaDebito);
		billetera.agregarMedio(tarjetaCredito);
		billetera.agregarMedio(cuentaVirtual);
		billetera.agregarMedio(cuentaBancaria);
		
		TreeSet<Pagadora> medios = new TreeSet<Pagadora>(billetera.getMedios());
		
		int i = 1;
		for (Pagadora pagadora : medios) {
			switch (i) {
			case 1:
				assertTrue(pagadora.getNumero().equals(tarjetaDebito.getNum()));
				break;

			case 2:
				assertTrue(pagadora.getNumero().equals(tarjetaCredito.getNum()));
				break;

			case 3:
				assertTrue(pagadora.getNumero().equals(cuentaVirtual.getCVU()));
				break;
			case 4:
				assertTrue(pagadora.getNumero().equals(cuentaBancaria.getCBU()));
				break;	
			default:
				break;
			}
			i++;
		}
		
		
	}

	@Test
	public void queSePuedanRealizarCompras() throws SaldoInsuficienteException, ExcedeLimiteDeCompraException {
		String nombre = "R";
		String dni = "45318159";
		String cuit = "2045318159";
		String qr = "jhjfhjhfs";
		Persona vendedor = new PersonaJuridica(nombre, dni, cuit, qr);

		Double saldo = 50000.0;
		Integer numD = 202020;

		TarjetaDeDebito tarjetaDebito = new TarjetaDeDebito(saldo, numD);

		Boolean v1 = tarjetaDebito.pagar(vendedor, saldo);

		Double limite = 50000.0;
		Integer numC = 101010;

		TarjetaDeCredito tarjetaCredito = new TarjetaDeCredito(limite, numC);

		Boolean v2 = tarjetaCredito.pagar(vendedor, saldo);

		Integer CVU = 987654321;

		CuentaVirtual cuentaVirtual = new CuentaVirtual(saldo, CVU);

		Boolean v3 = cuentaVirtual.pagar(vendedor, saldo);

		String alias = "renzo.b.222";
		Integer CBU = 123456789;
		Double saldoCuenta = 100000.0;

		CuentaBancaria cuentaBancaria = new CuentaBancaria(alias, CBU, saldoCuenta);
		Boolean v4 = cuentaBancaria.pagar(vendedor, saldoCuenta);

		assertTrue(v1);
		assertTrue(v2);
		assertTrue(v3);
		assertTrue(v4);

	}

	@Test
	public void queSePuedanRealizarTransferencias() throws SaldoInsuficienteException {

		Integer CVU = 987654321;
		Double saldo = 5000000.0;

		CuentaVirtual cuentaVirtual = new CuentaVirtual(saldo, CVU);

		String alias = "renzo.b.22";
		Integer CBU = 123456789;
		Double saldoCuenta = 100000.0;

		CuentaBancaria cuentaBancaria = new CuentaBancaria(alias, CBU, saldoCuenta);

		Boolean valor = cuentaVirtual.Transferir(cuentaBancaria, 20000.0);

		assertTrue(valor);
	}

	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaTarjetaEsInsuficienteParaHacerUnaCompra()
			throws SaldoInsuficienteException {
		String nombre = "R";
		String dni = "45318159";
		String cuit = "2045318159";
		String qr = "jhjfhjhfs";
		Persona vendedor = new PersonaJuridica(nombre, dni, cuit, qr);

		Double saldo = 50000.0;
		Integer numD = 202020;

		TarjetaDeDebito tarjetaDebito = new TarjetaDeDebito(saldo, numD);

		tarjetaDebito.pagar(vendedor, 60000.0);
	}

	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaVirtualEsInsuficienteParaHacerUnaCompra()
			throws SaldoInsuficienteException {
		String nombre = "R";
		String dni = "45318159";
		String cuit = "2045318159";
		String qr = "jhjfhjhfs";
		Persona vendedor = new PersonaJuridica(nombre, dni, cuit, qr);

		Integer CVU = 987654321;
		Double saldo = 50000.0;

		CuentaVirtual cuentaVirtual = new CuentaVirtual(saldo, CVU);

		cuentaVirtual.pagar(vendedor, 60000.0);
	}

	@Test(expected = ExcedeLimiteDeCompraException.class)
	public void queSeLanceUnaExcepcionSiElLimiteDeCompraDeLaTarjetaEsInsuficienteParaHacerUnaCompra()
			throws ExcedeLimiteDeCompraException {

		String nombre = "R";
		String dni = "45318159";
		String cuit = "2045318159";
		String qr = "jhjfhjhfs";
		Persona vendedor = new PersonaJuridica(nombre, dni, cuit, qr);

		Double limite = 50000.0;
		Integer numC = 101010;

		TarjetaDeCredito tarjetaCredito = new TarjetaDeCredito(limite, numC);

		tarjetaCredito.pagar(vendedor, 60000.0);
	}

	@Test(expected = SaldoInsuficienteException.class)
	public void queSeLanceUnaExcepcionSiElSaldoDeLaCuentaEsInsuficienteParaHacerUnaTransferencia()
			throws SaldoInsuficienteException {
		String nombre = "R";
		String dni = "45318159";
		String cuit = "2045318159";
		String qr = "jhjfhjhfs";
		Persona vendedor = new PersonaJuridica(nombre, dni, cuit, qr);

		Integer CVU = 987654321;
		Double saldo = 50000.0;

		CuentaVirtual cuentaVirtual = new CuentaVirtual(saldo, CVU);
		cuentaVirtual.pagar(vendedor, 60000.0);

	}
}
