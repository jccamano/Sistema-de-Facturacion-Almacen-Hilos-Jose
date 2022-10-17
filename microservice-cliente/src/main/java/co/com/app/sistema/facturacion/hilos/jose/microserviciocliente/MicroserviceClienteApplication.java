package co.com.app.sistema.facturacion.hilos.jose.microserviciocliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"co.com.app.sistema.facturacion.hilos.jose.microservicio.commons.facturas.models.entity",
			 "co.com.app.sistema.facturacion.hilos.jose.microserviciocliente.models.entity"})
public class MicroserviceClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClienteApplication.class, args);
	}

}
