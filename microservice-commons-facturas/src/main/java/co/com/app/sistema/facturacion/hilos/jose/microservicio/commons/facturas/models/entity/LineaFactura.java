package co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "linea_factura")
public class LineaFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int cantidad;
	
	@JsonIgnoreProperties(value = {"linea_factura"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "factura_id")
	private Factura factura;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof LineaFactura)) {
			return false;
		}
		LineaFactura lf = (LineaFactura) obj;
		
		
		return this.id != null && this.id.equals(lf.getId());
	}
	
	
}
