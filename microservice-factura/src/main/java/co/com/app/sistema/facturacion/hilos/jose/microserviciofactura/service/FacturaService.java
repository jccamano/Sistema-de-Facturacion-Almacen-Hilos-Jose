package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.service;

import java.util.Optional;

import co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.models.entity.Factura;

public interface FacturaService {

	public Iterable<Factura> findAll();
	
	public Optional<Factura> findById(Long id);
	
	public Factura save (Factura factura);
	
	public void deleteById(Long id);
}
