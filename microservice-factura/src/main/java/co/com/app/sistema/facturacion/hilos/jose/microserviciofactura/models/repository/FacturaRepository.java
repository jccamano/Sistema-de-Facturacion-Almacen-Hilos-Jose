package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.models.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity.Factura;

public interface FacturaRepository extends CrudRepository<Factura, Long>{

}
