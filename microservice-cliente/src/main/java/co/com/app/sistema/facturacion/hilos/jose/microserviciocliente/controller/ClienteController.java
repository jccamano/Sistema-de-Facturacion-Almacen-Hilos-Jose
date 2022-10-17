package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.controllers.CommonController;
import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity.Factura;
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
	
	@PutMapping("/{id}/agregar-facturas")
	public ResponseEntity<?> agregarFactura(@RequestBody List<Factura> facturas,@PathVariable long id){
		Optional<Cliente> op = this.service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDb = op.get();
		
		facturas.forEach(f -> {
			clienteDb.addFacturas(f);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(clienteDb));
	}
	
	@PutMapping("/{id}/eliminar-factura")
	public ResponseEntity<?> eliminarFactura(@RequestBody Factura factura,@PathVariable long id){
		Optional<Cliente> op = this.service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Cliente clienteDb = op.get();
		
		clienteDb.removeFacturas(factura);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(clienteDb));
	}
	
	@GetMapping("/buscar/{term}")
	public ResponseEntity<?> buscarPorNombreOApellido(@PathVariable String term){
		return ResponseEntity.ok(service.buscarPorNombreOApellido(term));
	}
	
	@GetMapping("/factura/{id}")
	public ResponseEntity<?> buscarClientePorIdFactura(@PathVariable Long id){		
		Cliente cliente = service.buscarClientePorIdFactura(id);
		return ResponseEntity.ok(cliente);
	}	

}
