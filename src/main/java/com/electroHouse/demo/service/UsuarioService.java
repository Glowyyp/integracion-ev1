package com.electroHouse.demo.service;

import com.electroHouse.demo.model.Usuario;
import com.electroHouse.demo.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Llamar una lista con tosos los usuarios
    public List<Usuario> findAll(){
        return usuarioRepository.findAll();
    }
    //Para buscar un Usuario por el ID
    public Usuario findById(Integer id){
        return usuarioRepository.findById(id).orElse(null);
    }
    //Eliminar un Usuario
    public void delete(Integer id){
        usuarioRepository.deleteById(id);
    }
    //Guardar Usuario
    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Buscar Por Nombres
    public List<Usuario> buscarPorNombre(String nombre){
        return usuarioRepository.findByNombres(nombre);
    }
    //Buscar Por Apellido
    public List<Usuario> buscarPorApellido(String apellido){
        return usuarioRepository.findByApellidos(apellido);
    }
    //Buscar Por Email
    public Usuario buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
}
