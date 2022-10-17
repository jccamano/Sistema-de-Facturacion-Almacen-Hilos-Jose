package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.service;



import java.util.List;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.services.CommonService;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;

public interface ClienteService extends CommonService<Cliente>{
	
	public List<Cliente> buscarPorNombreOApellido(String term);
	
	public Cliente buscarClientePorIdFactura(Long id);
}
