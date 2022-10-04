package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteRepository repository;

	@Override
	public Iterable<Cliente> findAll() {		
		return repository.findAll();
	}

	@Override
	public Optional<Cliente> findById(Long id) {		
		return repository.findById(id);
	}

	@Override
	public Cliente save(Cliente cliente) {		
		return repository.save(cliente);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);		
	}

}
