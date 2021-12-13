package pe.com.mila.business;


import io.reactivex.Observable;
import pe.com.mila.model.entity.DataTipoCambioEntity;
import pe.com.mila.model.request.RequestGetTipoCambio;
import pe.com.mila.model.response.ResponseTipoCambio;


public interface TipoCambioService {
	
	public Observable<ResponseTipoCambio> getTipoCambio(RequestGetTipoCambio input);
	
	public Observable<DataTipoCambioEntity> crearTipoCambio(DataTipoCambioEntity input);
	
	public Observable<DataTipoCambioEntity> getTipoCambios();

}
