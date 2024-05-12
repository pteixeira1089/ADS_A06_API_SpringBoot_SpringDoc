package br.com.pteixeira.thoughts.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "thought")
public class Thought {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "thought_id")
    private Integer thoughtId;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "user_id")
    @JsonBackReference
    private Usuario user;

    @Column(name="thought")
    private String thought;

    public Integer getThoughtId() {
        return thoughtId;
    }

    public void setThoughtId(Integer thoughtId) {
        this.thoughtId = thoughtId;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public String getThought() {
        return thought;
    }

    public void setThought(String thought) {
        this.thought = thought;
    }

}
