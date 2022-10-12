package co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.models.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.models.entity.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{

}
