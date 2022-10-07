package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.models.entity.Factura;
import co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.models.repository.FacturaRepository;

@Service
public class FacturaServiceImpl implements FacturaService {

	@Autowired
	private FacturaRepository repository;
	
	@Override
	public Iterable<Factura> findAll() {		
		return repository.findAll();
	}

	@Override
	public Optional<Factura> findById(Long id) {		
		return repository.findById(id);
	}

	@Override
	public Factura save(Factura factura) {		
		return repository.save(factura);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);

	}

}
