package co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "facturas")
public class Factura {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String descripcion;
	
	private String observacion;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_facturacion")
	private Date fechaFacturacion;
	
	@JsonIgnoreProperties(value = {"factura"}, allowSetters = true)
	@OneToMany(mappedBy = "factura",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<LineaFactura> lineasFactura;
	
	

	public Factura() {
		this.lineasFactura = new ArrayList<>();
	}

	@PrePersist
	public void prePersis() {
		this.fechaFacturacion = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Date getFechaFacturacion() {
		return fechaFacturacion;
	}

	public void setFechaFacturacion(Date fechaFacturacion) {
		this.fechaFacturacion = fechaFacturacion;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(!(obj instanceof Factura)) {
			return false;
		}
		Factura f = (Factura) obj;
		
		
		return this.id != null && this.id.equals(f.getId());
	}

	public List<LineaFactura> getLineasFactura() {
		return lineasFactura;
	}

	public void setLineasFactura(List<LineaFactura> lineasFactura) {
		this.lineasFactura.clear();
		lineasFactura.forEach(this::addLineaFactura);
		
	}	
	
	public void addLineaFactura(LineaFactura lineasFactura) {
		this.lineasFactura.add(lineasFactura);
		lineasFactura.setFactura(this);
	}
	
	public void removeLineaFactura(LineaFactura lineasFactura) {
		this.lineasFactura.remove(lineasFactura);
		lineasFactura.setFactura(null);
	}

}
