package br.com.pteixeira.thoughts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pteixeira.thoughts.entity.Thought;

public interface ThoughtRepository extends JpaRepository<Thought, Integer>{

}
