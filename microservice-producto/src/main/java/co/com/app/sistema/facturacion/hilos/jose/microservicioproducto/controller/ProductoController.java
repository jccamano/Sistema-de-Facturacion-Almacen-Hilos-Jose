package co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.models.entity.Producto;
import co.com.app.sistema.facturacion.hilos.jose.microservicioproducto.service.ProductoService;

@RestController
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	private ProductoService service;
	
	@GetMapping
	public ResponseEntity<?> mostrarTodosLosProductos(){
		return ResponseEntity.ok().body(service.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> mostrarUnproducto(@PathVariable Long id){
		Optional<Producto> op = service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(op.get());
	}
	
	@PostMapping
	public ResponseEntity<?> registrarProducto(@RequestBody Producto producto){
		Producto productoBD = service.save(producto);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoBD);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody Producto producto, @PathVariable Long id){
		Optional<Producto> op = service.findById(id);
		if(op.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		Producto productoBD = op.get();
		productoBD.setNombre(producto.getNombre());
		productoBD.setPrecio(producto.getPrecio());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoBD));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminarProducto(@PathVariable Long id){
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	/*
	 * @PostMapping("/registrar-con-foto") public ResponseEntity<?>
	 * registrarProductoConFoto(Producto producto,
	 * 
	 * @RequestParam MultipartFile archivo) throws IOException{
	 * if(!archivo.isEmpty()) { producto.setFoto(archivo.getBytes()); } return
	 * ResponseEntity.status(HttpStatus.CREATED).body(producto); }
	 * 
	 * @PutMapping("/editar-con-foto/{id}") public ResponseEntity<?>
	 * editarProductoConFoto(Producto producto,
	 * 
	 * @PathVariable Long id, @RequestParam MultipartFile archivo) throws
	 * IOException{ Optional<Producto> op = service.findById(id); if(op.isEmpty()) {
	 * return ResponseEntity.notFound().build(); } Producto productoBD = op.get();
	 * productoBD.setNombre(producto.getNombre());
	 * productoBD.setPrecio(producto.getPrecio());
	 * 
	 * if(!archivo.isEmpty()) { productoBD.setFoto(archivo.getBytes()); }
	 * 
	 * return
	 * ResponseEntity.status(HttpStatus.CREATED).body(service.save(productoBD)); }
	 */
	
	
	
}
