package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long>{
	
	@Query("select c from Cliente c where c.nombre like %?1% or c.apellido like %?1%")
	public List<Cliente> buscarPorNombreOApellido(String term);
	
	@Query("select c from Cliente c join fetch c.facturas f where f.id=?1")
	public Cliente buscarClientePorIdFactura(Long id);

}
