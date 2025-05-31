package com.electroHouse.demo.controller;

import com.electroHouse.demo.model.Usuario;
import com.electroHouse.demo.repository.UsuarioRepository;
import com.electroHouse.demo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    //Listar Usuarios
    @GetMapping("/api/v1/usuario")
    public ResponseEntity<?> getUsuarios(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.status(200).body(usuarios);
    }
    //Llamar usuario por ID
    @GetMapping("/api/v1/usuario/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if(usuario == null){
            //Usuario no encontrado
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
        //Llamar usuario por el Id en el Path
        return ResponseEntity.status(200).body(usuario);
    }
    //Eliminar Usuario
    @DeleteMapping("/api/v1/usuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable Integer id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            //Usuario no Encontrado
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
        //Eliminar Usuario por ID en el Path
        usuarioService.delete(id);
        return ResponseEntity.status(200).body("Usuario eliminado correctamente");
    }
    //Crear Nuevo Usuario
    @PostMapping("/api/v1/usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody Usuario usuario){
        Usuario nuevoUsuario = usuarioService.save(usuario);
        //Codigo 201 Porque fue creada una nueva instancia de usuario
        return ResponseEntity.status(201).body(nuevoUsuario);
    }
    //Buscar Por Nombres
    @GetMapping("/api/v1/usuario/buscar-nombre/{nombres}")
    public ResponseEntity<?> buscarUsuarioNombre(@PathVariable String nombres){
        List<Usuario> usuarios = usuarioService.buscarPorNombre(nombres);
        if (usuarios == null){
            return ResponseEntity.status(404).body("No se encontro el usuario con el nombre "+nombres);
        }
        return ResponseEntity.status(200).body(usuarios);
    }
    //Buscar Por Apellidos
    @GetMapping("/api/v1/usuario/buscar-apellido/{apellidos}")
    public ResponseEntity<?> buscarUsuarioApellido(@PathVariable String apellidos){
        List<Usuario> usuarios = usuarioService.buscarPorApellido(apellidos);
        if (usuarios == null){
            return ResponseEntity.status(404).body("No se encontro el Usuario con el apellido " + apellidos);
        }
        return ResponseEntity.status(200).body(usuarios);
    }
    //Buscar Por Email
    @GetMapping("/api/v1/usuario/buscar-email/{email}")
    public ResponseEntity<?> buscarUsuarioEmail(@PathVariable String email){
        Usuario  usuario = usuarioService.buscarPorEmail(email);
        if (usuario == null){
            //Usuario No Encontrado
            return ResponseEntity.status(404).body("Usuario no encontrado");
        }
        return ResponseEntity.status(200).body(usuarioService.buscarPorEmail(email));
    }
}
