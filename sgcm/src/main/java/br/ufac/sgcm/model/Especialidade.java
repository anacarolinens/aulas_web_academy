package br.ufac.sgcm.model;

import java.io.Serializable;

public class Especialidade implements Serializable{
    private Long id;  //atributo privado
    private String nome; //atributo privado



    public Long getId() { //getter
        return id;
    }
    public void setId(Long id) { //setter
        this.id = id;
    }
    public String getNome() { //getter
        return nome;
    }
    public void setNome(String nome) { //setter
        this.nome = nome;
    }

    
    
}
