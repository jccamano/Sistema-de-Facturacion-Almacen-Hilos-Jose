package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long>{

	
	@Query("select f from Factura f where f.descripcion like %?1%")
	public List<Factura> buscarFacturaPorDescripcion(String term);
	
}
