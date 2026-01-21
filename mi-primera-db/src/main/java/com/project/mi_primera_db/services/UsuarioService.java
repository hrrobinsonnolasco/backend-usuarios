package com.project.mi_primera_db.services;

import com.project.mi_primera_db.repositories.UsuarioRepository;
import com.project.mi_primera_db.entities.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> obtenerTodos(){
        return usuarioRepository.findAll();

    }
    public Optional<Usuario> buscarID(long id){
        return usuarioRepository.findById(id);
    }

    public void eliminarID(Long id){
        usuarioRepository.deleteById(id);
    }

    public Usuario actualizarUsuario(Long id, Usuario usuarioDetalles) {
            return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioDetalles.getNombre());
            usuario.setEmail(usuarioDetalles.getEmail());
            usuario.setPais(usuarioDetalles.getPais());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id " + id));
    }


}
