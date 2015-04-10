package model.account;

import java.math.BigDecimal;

public abstract class Cuenta implements ICuenta{

	private BigDecimal saldo;

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		if(saldo.compareTo(BigDecimal.ZERO) == -1){
			saldo = BigDecimal.ZERO;
		}
		this.saldo = saldo;
	}
	
}
