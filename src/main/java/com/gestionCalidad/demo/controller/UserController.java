package com.gestionCalidad.demo.controller;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    private List<User> usuarios = new ArrayList<>();

    @PostMapping("/api/usuarios")
    public User guardarUsuario(@RequestBody User user) {
        user.setId(System.currentTimeMillis());
        usuarios.add(user);
        return user;
    }

    public static class User {
        private Long id;
        private String nombre;
        private String email;
        private String fecha;
        private String tipo;

        // Getters y Setters
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        public Short getFecha() {
            return fecha;
        }
        public void setFecha(String fecha) {
            this.fecha = fecha;
        }
        public Short getTipo() {
            return tipo;
        }
        public void setTipo(Short tipo) {
            this.tipo = tipo;
        }
    }
} 
