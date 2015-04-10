package model.account;

import java.math.BigDecimal;

public class CajaDeAhorro extends Cuenta{

	private Double tasaInteres;

	public Double getTasaInteres() {
		return tasaInteres;
	}

	public void setTasaInteres(Double tasaInteres) {
		this.tasaInteres = tasaInteres;
	}
	
	@Override
	public Boolean validarExtraccionDeSaldo(BigDecimal saldoAExtraer) {
		if(saldoAExtraer.compareTo(getSaldo()) == 1){
			return false;
		}
		return true;
	}
	
	@Override
	public void extraerSaldo(BigDecimal saldoAExtraer) {
		if(validarExtraccionDeSaldo(saldoAExtraer)){
			setSaldo(getSaldo().subtract(saldoAExtraer));
		}
	}
}
