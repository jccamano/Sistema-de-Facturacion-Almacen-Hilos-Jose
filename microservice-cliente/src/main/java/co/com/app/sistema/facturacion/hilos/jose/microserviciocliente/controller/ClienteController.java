package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity.Cliente;
import co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<?> mostrarTodosLosClientes() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> mostrarCliente(@PathVariable Long id) {
		Optional<Cliente> op = service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}

	@PostMapping
	public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente) {
		Cliente clienteBD = service.save(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteBD);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> editarCliente(@RequestBody Cliente cliente, @PathVariable Long id) {

		Optional<Cliente> op = service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteBD = op.get();
		clienteBD.setNombre(cliente.getNombre());
		clienteBD.setApellido(cliente.getApellido());
		clienteBD.setCelular(cliente.getCelular());
		clienteBD.setDireccion(cliente.getDireccion());
		clienteBD.setCorreo(cliente.getCorreo());

		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(clienteBD));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarCliente(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}

}
