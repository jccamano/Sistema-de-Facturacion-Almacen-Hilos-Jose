package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{

}
