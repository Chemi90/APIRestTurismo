package com.example.apirestturismo.controller;

import com.example.apirestturismo.model.Hoteles;
import com.example.apirestturismo.repository.HotelRepository;
import com.example.apirestturismo.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Controlador para la gestión de hoteles en la aplicación.
 * Provee endpoints para operaciones CRUD sobre hoteles.
 *
 * <p>
 * Este controlador incluye métodos para obtener todos los hoteles, obtener un hotel por su ID,
 * crear un nuevo hotel, actualizar un hotel existente y eliminar un hotel.
 * Las operaciones de creación, actualización y eliminación requieren un token de seguridad válido.
 * </p>
 *
 * @author José Miguel Ruiz Guevara
 * @version 1.0
 */
@RestController
@RequestMapping("/api/hoteles")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private SecurityService security;

    /**
     * Obtiene todos los hoteles.
     *
     * @return Lista de hoteles.
     */
    @GetMapping("/")
    public List<Hoteles> getAllHoteles() {
        return hotelRepository.findAll();
    }

    /**
     * Obtiene un hotel por su ID.
     *
     * @param id ID del hotel a obtener.
     * @return ResponseEntity con el hotel encontrado o un estado NOT_FOUND si no se encuentra.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Hoteles> getHotelById(@PathVariable Long id) {
        return hotelRepository.findById(id)
                .map(hoteles -> ResponseEntity.ok().body(hoteles))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Crea un nuevo hotel.
     *
     * @param hoteles Datos del hotel a crear.
     * @param token Token de seguridad para autorización.
     * @return ResponseEntity con el hotel creado o un estado UNAUTHORIZED si el token no es válido.
     */
    @PostMapping("/")
    public ResponseEntity<Hoteles> createHotel(@RequestBody Hoteles hoteles, @RequestParam String token) {
        if (security.validateToken(token)) {
            return new ResponseEntity<>(hotelRepository.save(hoteles), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    /**
     * Actualiza un hotel existente.
     *
     * @param id ID del hotel a actualizar.
     * @param hotelesDetails Datos actualizados del hotel.
     * @param token Token de seguridad para autorización.
     * @return ResponseEntity con el hotel actualizado o un estado UNAUTHORIZED si el token no es válido.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Hoteles> updateHotel(@PathVariable Long id, @RequestBody Hoteles hotelesDetails, @RequestParam String token) {
        if (!security.validateToken(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return hotelRepository.findById(id)
                .map(hoteles -> {
                    hoteles.setNombre(hotelesDetails.getNombre());
                    hoteles.setDireccion(hotelesDetails.getDireccion());
                    hoteles.setEstrellas(hotelesDetails.getEstrellas());
                    hoteles.setTelefono(hotelesDetails.getTelefono());
                    hoteles.setEmail(hotelesDetails.getEmail());
                    hoteles.setSitioWeb(hotelesDetails.getSitioWeb());
                    Hoteles updatedHoteles = hotelRepository.save(hoteles);
                    return ResponseEntity.ok().body(updatedHoteles);
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Elimina un hotel.
     *
     * @param id ID del hotel a eliminar.
     * @param token Token de seguridad para autorización.
     * @return ResponseEntity con el estado de la operación.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable Long id, @RequestParam String token) {
        if (!security.validateToken(token)) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }

        return hotelRepository.findById(id)
                .map(hoteles -> {
                    hotelRepository.delete(hoteles);
                    return ResponseEntity.ok().build();
                }).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
