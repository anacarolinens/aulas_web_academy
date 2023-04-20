package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.UnidadeDao;
import br.ufac.sgcm.model.Unidade;

public class UnidadeController implements IController{

    private UnidadeDao dao;

    public UnidadeController() { //metodo construtor
        dao = new UnidadeDao();
    }


    @Override
    public List<Unidade> get() {
        return dao.get();
    }

    @Override
    public Object get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int save(Object objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
