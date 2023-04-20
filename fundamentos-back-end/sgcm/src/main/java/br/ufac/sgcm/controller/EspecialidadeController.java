package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.model.Especialidade;

public class EspecialidadeController implements IController<Especialidade>{

    private EspecialidadeDao dao;

    public EspecialidadeController() {
        dao = new EspecialidadeDao();
    }


    @Override
    public List<Especialidade> get() {
       return dao.get();
    }

    @Override
    public Especialidade get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Especialidade> get(String termoBusca) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public int save(Especialidade objeto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
