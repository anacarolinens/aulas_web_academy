package br.ufac.sgcm.model;

import java.io.Serializable;

public class Unidade implements Serializable{
    //Atibutos privados
    private Long id;
    private String nome;
    private String endereço;

    //Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEndereço() {
        return endereço;
    }
    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    
}
