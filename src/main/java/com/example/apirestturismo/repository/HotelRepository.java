package com.example.apirestturismo.repository;

import com.example.apirestturismo.model.Hoteles;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interfaz del repositorio para la entidad Hoteles.
 * <p>
 * Esta interfaz extiende {@link JpaRepository}, proporcionando métodos CRUD para la entidad Hoteles.
 * No es necesario implementar estos métodos, ya que Spring Data JPA los proporciona automáticamente.
 * Se pueden añadir métodos adicionales específicos para la entidad Hoteles si es necesario.
 * </p>
 *
 * @author José Miguel Ruiz Guevara
 * @version 1.0
 * @see Hoteles
 */
public interface HotelRepository extends JpaRepository<Hoteles, Long> {
}