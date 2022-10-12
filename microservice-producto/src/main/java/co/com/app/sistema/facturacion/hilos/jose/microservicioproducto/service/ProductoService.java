package co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.service;

import java.util.Optional;

import co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.models.entity.Producto;

public interface ProductoService {
	
	public Iterable<Producto> findAll();
	
	public Optional<Producto> findById(Long id);	
	
	public Producto save(Producto producto);
	
	public void deleteById(Long id);

}
