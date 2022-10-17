package co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.services.CommonService;

public class CommonController<E, S extends CommonService<E>> {

	@Autowired
	protected S service;

	@GetMapping
	public ResponseEntity<?> mostrarTodosLosClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> mostrarCliente(@PathVariable Long id) {
		Optional<E> op = service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}

	@PostMapping
	public ResponseEntity<?> registrarCliente(@RequestBody E entity) {
		E entityDb = service.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}	

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
