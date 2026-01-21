package com.project.mi_primera_db.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.project.mi_primera_db.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // ¡Listo! Ya tienes métodos como save(), findAll(), delete() sin escribir nada.
}