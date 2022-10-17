package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.controllers.CommonController;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends CommonController<Cliente, ClienteService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {

		Optional<Cliente> op = this.service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDb = op.get();
		clienteDb.setNombre(cliente.getNombre());
		clienteDb.setApellido(cliente.getApellido());
		clienteDb.setCelular(cliente.getCelular());
		clienteDb.setDireccion(cliente.getDireccion());
		clienteDb.setCorreo(cliente.getCorreo());

		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(clienteDb));

	}


}
