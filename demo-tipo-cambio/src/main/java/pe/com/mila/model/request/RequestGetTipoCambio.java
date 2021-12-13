package pe.com.mila.model.request;

import lombok.Data;

@Data
public class RequestGetTipoCambio {

	private double monto;
	private String monedaOrigen;
	private String monedaDestino;
}
