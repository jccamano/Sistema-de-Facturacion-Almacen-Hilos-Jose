package co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.models.entity.Producto;
import co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.models.repository.ProductoRepository;

@Service
public class ProductoServiceImplement implements ProductoService {

	@Autowired
	private ProductoRepository repository;
	
	@Override
	public Iterable<Producto> findAll() {		
		return repository.findAll();
	}

	@Override
	public Optional<Producto> findById(Long id) {		
		return repository.findById(id);
	}

	@Override
	public Producto save(Producto producto) {		
		return repository.save(producto);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

}
