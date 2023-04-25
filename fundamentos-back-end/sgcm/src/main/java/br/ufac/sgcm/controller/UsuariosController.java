package br.ufac.sgcm.controller;

import java.util.List;

import br.ufac.sgcm.dao.UsuariosDao;
import br.ufac.sgcm.model.Usuarios;

public class UsuariosController implements IController<Usuarios>{
    
    private UsuariosDao dao;

    public UsuariosController() {
        dao = new UsuariosDao();
    }

    @Override
    public List<Usuarios> get() {
        return dao.get();
    }

    @Override
    public Usuarios get(Long id) {
        return dao.get(id);
    }

    @Override
    public List<Usuarios> get(String termoBusca) {
        return dao.get(termoBusca);
    }

    @Override
    public int save(Usuarios objeto) {
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
