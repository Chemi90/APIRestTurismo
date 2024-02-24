package com.example.apirestturismo.service;

import org.springframework.stereotype.Service;

/**
 * Servicio para la gestión de la seguridad, específicamente para la validación de tokens.
 * <p>
 * Este servicio contiene métodos para realizar validaciones de seguridad como la validación de tokens.
 * Actualmente, valida un token estático para simplificar el proceso de autenticación y autorización.
 * </p>
 *
 * @author José Miguel Ruiz Guevara
 * @version 1.0
 */
@Service
public class SecurityService {

    /**
     * Valida si el token proporcionado es igual al token esperado.
     *
     * @param token El token a validar.
     * @return {@code true} si el token es válido, {@code false} en caso contrario.
     */
    public Boolean validateToken(String token) {
        return (token.equals("t0k3n"));
    }
}
