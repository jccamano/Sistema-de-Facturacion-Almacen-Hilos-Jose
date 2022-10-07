package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.models.entity.Factura;
import co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.service.FacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaController {

	@Autowired
	private FacturaService service;

	@GetMapping
	public ResponseEntity<?> mostrarTodasLasFacturas() {
		return ResponseEntity.ok().body(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> mostrarUnaFactura(@PathVariable Long id) {
		Optional<Factura> op = service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}

	@PostMapping
	public ResponseEntity<?> crearFactura(@RequestBody Factura factura) {
		Factura facturaBD = service.save(factura);
		return ResponseEntity.status(HttpStatus.CREATED).body(facturaBD);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarFactura(@RequestBody Factura factura, @PathVariable Long id){
		Optional<Factura> op = service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Factura facturaBD = op.get();
		facturaBD.setDescripcion(factura.getDescripcion());
		facturaBD.setObservacion(factura.getObservacion());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(facturaBD));
	}
}
