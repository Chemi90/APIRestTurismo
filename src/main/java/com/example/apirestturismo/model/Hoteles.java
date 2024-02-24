package com.example.apirestturismo.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Clase que representa la entidad Hotel en la base de datos.
 * <p>
 * Esta clase modela los datos de un hotel, incluyendo su identificador único,
 * nombre, dirección, cantidad de estrellas, teléfono, email y sitio web.
 * Utiliza anotaciones de JPA para mapear la clase a una tabla en la base de datos y
 * anotaciones de Lombok para reducir el código boilerplate, como getters y setters.
 * </p>
 *
 * @author José Miguel Ruiz Guevara
 * @version 1.0
 */
@Data
@Entity
public class Hoteles {

    /**
     * Identificador único del hotel, generado automáticamente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre del hotel.
     */
    private String nombre;

    /**
     * Dirección física del hotel.
     */
    private String direccion;

    /**
     * Cantidad de estrellas que clasifican al hotel.
     */
    private Integer estrellas;

    /**
     * Número de teléfono de contacto del hotel.
     */
    private String telefono;

    /**
     * Dirección de correo electrónico de contacto del hotel.
     */
    private String email;

    /**
     * Sitio web oficial del hotel.
     */
    private String sitioWeb;
}
