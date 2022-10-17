package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.service;

import java.util.List;
import java.util.Optional;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.services.CommonService;
import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity.Factura;

public interface FacturaService extends CommonService<Factura>{
	
	public List<Factura> buscarFacturaPorDescripcion(String term);

}
