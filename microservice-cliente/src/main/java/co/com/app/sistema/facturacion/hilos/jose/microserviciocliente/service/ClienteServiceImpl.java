package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.service;

import java.util.List;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.services.CommonServiceImpl;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.repository.ClienteRepository;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService{

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscarPorNombreOApellido(String term) {		
		return repository.buscarPorNombreOApellido(term);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente buscarClientePorIdFactura(Long id) {		
		return repository.buscarClientePorIdFactura(id);
	}
	


}
