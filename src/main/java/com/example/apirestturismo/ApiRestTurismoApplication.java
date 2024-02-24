package com.example.apirestturismo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Spring Boot para el sistema de turismo.
 * <p>
 * Esta clase inicia la aplicación Spring Boot, configurando automáticamente el entorno de la aplicación
 * basado en las dependencias y configuraciones proporcionadas.
 * </p>
 * <p>
 * Utiliza la anotación {@link org.springframework.boot.autoconfigure.SpringBootApplication} para habilitar la configuración
 * automática de Spring Boot, el escaneo de componentes y otras configuraciones predeterminadas.
 * </p>
 *
 * @author José Miguel Ruiz Guevara
 * @version 1.0
 */
@SpringBootApplication
public class ApiRestTurismoApplication {

    /**
     * Método principal que sirve como punto de entrada para la aplicación Spring Boot.
     *
     * @param args Argumentos de línea de comandos pasados al iniciar la aplicación.
     */
    public static void main(String[] args) {
        SpringApplication.run(ApiRestTurismoApplication.class, args);
    }
}