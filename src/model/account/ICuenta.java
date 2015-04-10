package model.account;

import java.math.BigDecimal;

public interface ICuenta {
	public void extraerSaldo(BigDecimal monto);
	public Boolean validarExtraccionDeSaldo(BigDecimal monto);
}
