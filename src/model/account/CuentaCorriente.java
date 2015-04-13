package model.account;

import java.math.BigDecimal;

public class CuentaCorriente extends Cuenta{

	private BigDecimal sobreGiro;
	
	public BigDecimal getSobreGiro() {
		return sobreGiro;
	}

	public void setSobreGiro(BigDecimal sobreGiro) {
		this.sobreGiro = sobreGiro;
	}

	@Override
	public Boolean validarExtraccionDeSaldo(BigDecimal monto) {
		if(monto.compareTo(calcularCapacidadTotalDeExtraccion()) == 1){
			return false;
		}
		return true;
	}
	
	@Override
	public void extraerSaldo(BigDecimal monto) {
		BigDecimal resultado = null;
		if(validarExtraccionDeSaldo(monto)){
			resultado = getSaldo().subtract(monto);
			setSaldo(resultado);
			descontarAlSobregiro(resultado);
			System.out.println("TEST");
		}
		
	}
	
	public void descontarAlSobregiro(BigDecimal montoADescontar){
		if(montoADescontar.compareTo(BigDecimal.ZERO) == -1){
			sobreGiro.subtract(montoADescontar.negate());
		}
	}
	
	public BigDecimal calcularCapacidadTotalDeExtraccion(){
		return getSaldo().add(sobreGiro);
	}
}
