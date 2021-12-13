package pe.com.mila.expose.web;

import javax.inject.Inject;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.reactivex.Observable;
import lombok.RequiredArgsConstructor;
import pe.com.mila.business.TipoCambioService;
import pe.com.mila.model.entity.DataTipoCambioEntity;
import pe.com.mila.model.request.RequestCreateTipoCambio;
import pe.com.mila.model.request.RequestGetTipoCambio;
import pe.com.mila.model.response.ResponseTipoCambio;


/**
 * <br/> Controlador que administrar todas las operaciones sobre el recurso tipo de cambio.<br/>
 * <b>enum</b>: TipoCambioController<br/>
 *
 * @author Roger Huamani <br/>
 * <u>Developed by</u>: <br/>
 * <ul>
 * <li>Roger Huamani</li>
 * </ul>
 * <u>Changes</u>:<br/>
 * <ul>
 * <li>Dec 13, 2021 Creaci&oacute;n de Clase.</li>
 * </ul>
 * @version 1.0
 */

@CrossOrigin("http://localhost:4700")
@RestController
@RequestMapping("/api-tipo-cambio")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class TipoCambioController {
	private final TipoCambioService tipocambioService;

	@GetMapping("/consultar")
	public Observable<DataTipoCambioEntity> getTipoCambios() {
		return tipocambioService.getTipoCambios();
	}

	@PostMapping("/calcular")
	public Observable<ResponseTipoCambio> getTipoCambio(@RequestBody @Validated RequestGetTipoCambio request) {
		return tipocambioService.getTipoCambio(request);
	}

	@PostMapping("/crear")
	public Observable<DataTipoCambioEntity> createTipoCambio(
			@RequestBody @Validated RequestCreateTipoCambio requestModel) {
		return tipocambioService
				.crearTipoCambio(DataTipoCambioEntity.builder().monedaDestino(requestModel.getMonedaDestino())
						.monedaOrigen(requestModel.getMonedaOrigen())
						.tipoCambio(requestModel.getTipoCambio()).build());
	}

}
