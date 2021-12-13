package pe.com.mila.model.request;


import lombok.Data;

@Data
public class RequestCreateTipoCambio {

	private String monedaOrigen;
	private String monedaDestino;
	private double tipoCambio;

}
