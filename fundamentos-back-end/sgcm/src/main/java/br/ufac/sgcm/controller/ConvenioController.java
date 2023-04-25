package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.ConvenioDao;
import br.ufac.sgcm.model.Convenio;

public class ConvenioController implements IController<Convenio>{
    
    private ConvenioDao dao;
    
    public ConvenioController() {
        dao = new ConvenioDao();
    }


    @Override
    public List<Convenio> get() {
        return dao.get();
    }

    @Override
    public Convenio get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<Convenio> get(String termoBusca) {
        return dao.get(termoBusca);
    }

    @Override
    public int save(Convenio objeto) {
        int registrosAfetados = 0;
        if (objeto.getId() == null) {
            registrosAfetados = dao.insert(objeto);            
        } else {
            registrosAfetados = dao.update(objeto);
        }
        return registrosAfetados;
    }

    @Override
    public int delete(Long id) {
        return dao.delete(id);
    }

}
