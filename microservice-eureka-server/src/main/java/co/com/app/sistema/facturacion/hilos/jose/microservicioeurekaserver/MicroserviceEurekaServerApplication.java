package co.com.app.sistema.facturacion.hilos.jose.microservicioeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MicroserviceEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceEurekaServerApplication.class, args);
	}

}
