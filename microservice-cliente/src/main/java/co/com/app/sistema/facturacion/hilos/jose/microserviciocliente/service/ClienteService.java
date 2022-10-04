package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.service;

import java.util.Optional;

import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;

public interface ClienteService {
	
	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(Long id);
	
	public Cliente save (Cliente cliente);
	
	public void deleteById (Long id);

}
