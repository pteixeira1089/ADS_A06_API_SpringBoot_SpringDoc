package br.com.pteixeira.thoughts.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pteixeira.thoughts.entity.Usuario;
import br.com.pteixeira.thoughts.repository.UsuarioRepository;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository userRepository;

    public List<Usuario> getAll() {
        return userRepository.findAll();
    }
    
    public Usuario findByEmail(String email) {
        return userRepository.findByUserEmail(email).get();
    }

    public Usuario findById(Integer id) {
        return userRepository.findById(id).get();
    }

    public Usuario save(Usuario user){
        return userRepository.save(user);
    }

}
