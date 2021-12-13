package pe.com.mila.model.response;

import lombok.Data;

@Data
public class ResponseTipoCambio {

	private double montoOriginal;
	private double montoFinal;
	private String monedaOrigen;
	private String monedaDestino;
	private double tipoCambio;

}
