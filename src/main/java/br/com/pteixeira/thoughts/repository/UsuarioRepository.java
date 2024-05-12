package br.com.pteixeira.thoughts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pteixeira.thoughts.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    Optional<Usuario> findByUserEmail(String email);

}
