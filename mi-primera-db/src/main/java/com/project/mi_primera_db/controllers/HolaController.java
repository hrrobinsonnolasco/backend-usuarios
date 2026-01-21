package com.project.mi_primera_db.controllers;

import com.project.mi_primera_db.entities.Usuario;
import com.project.mi_primera_db.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200") // Permite que Angular se conecte
@RestController
public class HolaController {

    @Autowired // @Autowired: Le dice a Spring que busque el servicio y lo conecte aquí automáticamente.
    private UsuarioService usuarioService; // Declaramos la variable para poder usarla abajo.

    @GetMapping("/hola")
    public String saludar() {
        return "¡Conexión exitosa!";
    }

    @PostMapping("/guardar") // @PostMapping: Habilita la recepción de datos.
    public Usuario guardarNuevo(@RequestBody Usuario nuevoUsuario) {
        // @RequestBody: Convierte el JSON que envíes en un objeto Usuario.
        return usuarioService.guardarUsuario(nuevoUsuario);
    }

    @GetMapping("/listar")
    public List<Usuario> listarUsuarios() {
        return usuarioService.obtenerTodos();
    }


    @GetMapping("/buscar/{id}")
    public Optional<Usuario> obtenerUsuario(@PathVariable Long id){
        return usuarioService.buscarID(id);
    }

    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id){
        usuarioService.eliminarID(id);
        return "Usuario con ID " + id + " eliminado correctamente.";
    }

    @PutMapping("/actualizar/{id}") // @PutMapping: Se usa para MODIFICAR registros existentes.
    public Usuario actualizar(@PathVariable Long id, @RequestBody Usuario detalles) {
        // Combinamos @PathVariable (para saber a quién) y @RequestBody (para saber qué cambiar).
        return usuarioService.actualizarUsuario(id, detalles);
    }

}