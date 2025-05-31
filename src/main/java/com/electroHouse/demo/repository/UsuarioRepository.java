package com.electroHouse.demo.repository;

import com.electroHouse.demo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    //Buscar por Nombres
    List<Usuario> findByNombres(String nombre);

    //Buscar por Apellidos
    List<Usuario> findByApellidos(String apellidos);

    //Buscar por Email
    Usuario findByEmail(String email);
}
