package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.UnidadeDao;
import br.ufac.sgcm.model.Unidade;

public class UnidadeController implements IController<Unidade> {

    private UnidadeDao dao;

    public UnidadeController() {
        dao = new UnidadeDao();
    }

    @Override
    public List<Unidade> get() {
        return dao.get();
    }

    @Override
    public Unidade get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Unidade> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int save(Unidade objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
