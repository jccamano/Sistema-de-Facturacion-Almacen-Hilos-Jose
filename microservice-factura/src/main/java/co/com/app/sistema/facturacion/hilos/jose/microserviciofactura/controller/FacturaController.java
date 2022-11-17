package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.controller;

import java.util.ArrayList;
import java.util.List;
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

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.controllers.CommonController;
import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity.Factura;
import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity.LineaFactura;
import co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.service.FacturaService;

@RestController
@RequestMapping("/factura")
public class FacturaController extends CommonController<Factura, FacturaService>{

	/*
	 * @PutMapping("/{id}") public ResponseEntity<?> editarFactura(@RequestBody
	 * Factura factura, @PathVariable Long id){ Optional<Factura> op =
	 * this.service.findById(id); if (op.isEmpty()) { return
	 * ResponseEntity.notFound().build(); } Factura facturaDb = op.get();
	 * facturaDb.setDescripcion(factura.getDescripcion());
	 * facturaDb.setObservacion(factura.getObservacion());
	 * 
	 * return
	 * ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(facturaDb));
	 * }
	 */
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarFactura(@RequestBody Factura factura, @PathVariable Long id){
		Optional<Factura> op = this.service.findById(id);
		if (op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Factura facturaDb = op.get();
		facturaDb.setDescripcion(factura.getDescripcion());
		facturaDb.setObservacion(factura.getObservacion());
		
		List<LineaFactura> eliminadas = new ArrayList<>();
		
		facturaDb.getLineasFactura().forEach(pdb ->{
			if(!factura.getLineasFactura().contains(pdb)) {
				eliminadas.add(pdb);
			}
		});
		
		eliminadas.forEach(facturaDb::removeLineaFactura);
		
		facturaDb.setLineasFactura(factura.getLineasFactura());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(facturaDb));
	}
	
	@GetMapping("/buscar/{term}")
	public ResponseEntity<?> buscarPorDescripcion(@PathVariable String term){
		return ResponseEntity.ok(service.buscarFacturaPorDescripcion(term));
	}
}
