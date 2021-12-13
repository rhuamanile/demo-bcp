package pe.com.mila.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pe.com.mila.model.entity.DataTipoCambioEntity;

@Repository
public interface ObtenerDataTipoCambioDao extends CrudRepository<DataTipoCambioEntity, Long>{
}
