package com.fontebo.inventario.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.fontebo.inventario.Modelo.Usuario;

public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String username);

}
