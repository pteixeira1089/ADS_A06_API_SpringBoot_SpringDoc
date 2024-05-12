package br.com.pteixeira.thoughts.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.pteixeira.thoughts.entity.Usuario;
import br.com.pteixeira.thoughts.service.UsuarioService;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Operation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/user")
//@Api(tags="User Controller", description="Endpoints relacionados ao registro de usuários")
public class UsuarioController {
    
    @Autowired
    private UsuarioService userService;

    @SuppressWarnings("null")
    @GetMapping("/all")
    @Operation(summary = "Obtém todos os usuários cadastrados", description = "Listagem de usuários")
    public ResponseEntity<List<Usuario>> getAll() {
        List<Usuario> users = userService.getAll();
        if (!users.isEmpty()){
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    @Operation(summary = "Obtém o usuário registrado com o id informado", description = "Retorna um cadastro de usuário")
    public ResponseEntity<Usuario> getById(@PathVariable Integer id) {
        Usuario user = userService.findById(id);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/{email}")
    @Operation(summary = "Obtém o usuário registrado com o e-mail informado", description = "Retorna um cadastro de usuário")
    public ResponseEntity<Usuario> getById(@PathVariable String email) {
        Usuario user = userService.findByEmail(email);
        if (user != null){
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Cria um novo usuário", description = "Novo usuário")
    public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(userService.save(usuario), HttpStatus.CREATED);
    }

}
