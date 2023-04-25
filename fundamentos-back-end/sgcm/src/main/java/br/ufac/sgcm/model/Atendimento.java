package br.ufac.sgcm.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import br.ufac.sgcm.dao.ConvenioDao;
import br.ufac.sgcm.dao.PacienteDao;
import br.ufac.sgcm.dao.ProfissionalDao;

public class Atendimento implements Serializable{

    private Long id;
    private Date data;
    private Time hora;
    private ConvenioDao convenioDao;
    private PacienteDao pacienteDao;
    private ProfissionalDao profissionalDao;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }
    public ConvenioDao getConvenioDao() {
        return convenioDao;
    }
    public void setConvenioDao(ConvenioDao convenioDao) {
        this.convenioDao = convenioDao;
    }
    public PacienteDao getPacienteDao() {
        return pacienteDao;
    }
    public void setPacienteDao(PacienteDao pacienteDao) {
        this.pacienteDao = pacienteDao;
    }
    public ProfissionalDao getProfissionalDao() {
        return profissionalDao;
    }
    public void setProfissionalDao(ProfissionalDao profissionalDao) {
        this.profissionalDao = profissionalDao;
    }

    
    


    
}
