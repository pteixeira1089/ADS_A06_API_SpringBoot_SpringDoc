package br.com.pteixeira.thoughts.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pteixeira.thoughts.entity.Thought;
import br.com.pteixeira.thoughts.service.ThoughtService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/thought")
@Api(tags="Thought Controller", description = "Endpoints relativos a pensamentos registrados")
public class ThoughtController {
    @Autowired
    ThoughtService thoughtService;

    @SuppressWarnings("null")
    @GetMapping("/all")
    @Operation(summary = "Obtém os pensamentos registrados", description = "Listagem de pensamentos")
    public ResponseEntity<List<Thought>> getAll() {
        List<Thought> thoughts = thoughtService.getAll();
        if (!thoughts.isEmpty()){
            return new ResponseEntity<>(thoughts, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @SuppressWarnings("null")
    @GetMapping("/{id}")
    @Operation(summary = "Obtém os pensamentos registrados com o id informado", description = "Listagem de pensamentos")
    public ResponseEntity<Thought> getById(@PathVariable Integer id) {
        Thought thought = thoughtService.getById(id);
        if (thought != null) {
            return new ResponseEntity<>(thought, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    @Operation(summary = "Registra um novo pensamento", description = "Registra um novo pensamento")
    public ResponseEntity<Thought> saveThought(@RequestBody Thought thought) {
        return new ResponseEntity<>(thoughtService.saveThought(thought), HttpStatus.CREATED);
    }

    @SuppressWarnings("null")
    @PutMapping("/{id}")
    @Operation(summary = "Edita um pensamento já registrado", description = "Edita um pensamento")
    public ResponseEntity<Thought> updateThought(@PathVariable Integer id, @RequestBody Thought thought) {
        if(thought != null) {
            return new ResponseEntity<>(thought, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta um pensamento registro", description = "Deleta o pensamento cujo id é informado na requisição")
    public ResponseEntity<Boolean> deleteThought(@PathVariable Integer id) {
        if(thoughtService.deleteThought(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }
    }

}
