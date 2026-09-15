package com.tatandev.taskmanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> manejarValidacion(MethodArgumentNotValidException ex) {
        String campo = ex.getBindingResult().getFieldError().getField();
        String mensaje = ex.getBindingResult().getFieldError().getDefaultMessage();

        Map<String, Object> respuesta = new HashMap<>();
        respuesta.put("campo", campo);
        respuesta.put("mensaje", mensaje);
        respuesta.put("status", 400);

        return ResponseEntity.badRequest().body(respuesta);
    }

}
