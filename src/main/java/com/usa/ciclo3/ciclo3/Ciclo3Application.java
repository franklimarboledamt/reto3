/**
 * 1. Clase principal del proyecto
 */
package com.usa.ciclo3.ciclo3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * Con esta anotación le indicamos el proyecto donde encontrar todas
 * las Clases-Entidades (Clases que me representan tablas en una BD) y le
 * diremos que la bustque en el paquete base.
 * @author frankdev
 */
@EntityScan(basePackages = {"com.usa.ciclo3.ciclo3.model"})
/**
 * Anotación que indica que estamos trabjando con un proyecto
 * Spring Boot.
 * @author frankdev
 */
@SpringBootApplication
public class Ciclo3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciclo3Application.class, args);
	}

}
