package pe.com.mila.business.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import pe.com.mila.business.TipoCambioService;
import pe.com.mila.model.entity.DataTipoCambioEntity;
import pe.com.mila.model.request.RequestGetTipoCambio;
import pe.com.mila.model.response.ResponseTipoCambio;
import pe.com.mila.repository.ObtenerDataTipoCambioDao;

@Named
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class TipoCambioServiceImpl implements TipoCambioService {

	private final ObtenerDataTipoCambioDao tipocambioRepository;

	@Override
	public Observable<ResponseTipoCambio> getTipoCambio(RequestGetTipoCambio input) {
		ResponseTipoCambio response = new ResponseTipoCambio();
		double tipoCambio = 0;
		double montoFinal = 0.0;

		List<DataTipoCambioEntity> lst = (List<DataTipoCambioEntity>) tipocambioRepository.findAll();
		tipoCambio = obtenerTipoCambio(lst, input.getMonedaOrigen(), input.getMonedaDestino());

		montoFinal = input.getMonto() * tipoCambio;

		response.setMontoOriginal(input.getMonto());
		response.setMontoFinal(montoFinal);
		response.setMonedaOrigen(input.getMonedaOrigen());
		response.setMonedaDestino(input.getMonedaDestino());
		response.setTipoCambio(tipoCambio);
		
		return Observable.just(response);
	}

	@Override
	public Observable<DataTipoCambioEntity> crearTipoCambio(DataTipoCambioEntity input) {
		return Observable.just(tipocambioRepository.save(input));
	}
	
	public double obtenerTipoCambio(List<DataTipoCambioEntity> lst, String monedaOrigen, String monedaDestino) {
		double tipoCambio;
		
		tipoCambio = lst.stream()
				.filter(x -> x.getMonedaOrigen().equalsIgnoreCase(monedaOrigen) && x.getMonedaDestino().equalsIgnoreCase(monedaDestino))
				.findFirst()
				.map(DataTipoCambioEntity::getTipoCambio)
				.orElse(0.0); 
		
		return tipoCambio;	 
	}

	@Override
	public Observable<DataTipoCambioEntity> getTipoCambios() {
		
		return Observable.fromIterable(tipocambioRepository.findAll());
	}

}
