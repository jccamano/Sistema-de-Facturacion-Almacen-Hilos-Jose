package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.service;

import org.springframework.stereotype.Service;

import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity.Factura;
import co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.services.CommonServiceImpl;

import co.com.app.sistema.facturacion.hilos.jose.microserviciofactura.models.repository.FacturaRepository;

@Service
public class FacturaServiceImpl extends CommonServiceImpl<Factura, FacturaRepository> implements FacturaService {

}
