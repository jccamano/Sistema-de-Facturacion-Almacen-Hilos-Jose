package co.com.app.sistema.facturacion.hilos.jose.microserviciofactura;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity"})
public class MicroserviceFacturaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceFacturaApplication.class, args);
	}

}
