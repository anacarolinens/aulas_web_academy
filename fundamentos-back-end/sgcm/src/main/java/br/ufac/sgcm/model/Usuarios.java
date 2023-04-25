package br.ufac.sgcm.model;

public class Usuarios  {
    private Long id;
    private String nomeCompleto;
    private String nomeUsuario;
    private String senha;
    private String ativo;
    //private PapelEnum papel;
    private String papel;

    public Long getId(){
        return id;
    }
    public void setId(Long Id){
        this.id = Id;
    }
    public String getNomeCompleto(){
        return nomeCompleto;
    }
    public void setNomeCompleto(String NomeCompleto){
        this.nomeCompleto = NomeCompleto;
    }
    public String getNomeUsuario(){
        return nomeUsuario;
    }
    public void setNomeUsuario(String NomeUsuario){
        this.nomeUsuario = NomeUsuario;
    }
    public String getSenha(){
        return senha;
    }
    public void setSenha(String Senha){
        this.senha = Senha;
    }
    public String getAtivo(){
        return ativo;
    }
    public void setAtivo(String Ativo){
        this.ativo = Ativo;
    }
    public String getPapel() {
        return papel;
      }
      
      public void setPapel(String papel) {
        this.papel = papel;
      }
    }
