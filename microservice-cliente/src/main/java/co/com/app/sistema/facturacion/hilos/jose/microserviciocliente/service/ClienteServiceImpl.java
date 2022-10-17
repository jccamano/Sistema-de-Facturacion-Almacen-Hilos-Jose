package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.service;

import org.springframework.stereotype.Service;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.services.CommonServiceImpl;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.repository.ClienteRepository;

@Service
public class ClienteServiceImpl extends CommonServiceImpl<Cliente, ClienteRepository> implements ClienteService{
	


}
