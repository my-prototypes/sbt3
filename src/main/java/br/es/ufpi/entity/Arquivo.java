package br.es.ufpi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
public class Arquivo {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private String caminho;
    public Arquivo(){}

    // Getters e setters
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getCaminho(){
        return this.caminho;
    }

    public void setCaminho(String caminho){
        this.caminho = caminho;
    }
}