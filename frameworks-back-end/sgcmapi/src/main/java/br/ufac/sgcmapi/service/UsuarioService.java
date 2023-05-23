package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Usuario;
import br.ufac.sgcmapi.repository.UsuarioRepository;

@Service
public class UsuarioService implements IService<Usuario> {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Usuario> get() {
        return repo.findAll();
    }

    @Override
    public Usuario get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Usuario> get(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Usuario save(Usuario objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Usuario getByNomeUsuario(String nomeUsuario) {
        return repo.findByNomeUsuario(nomeUsuario);
    }
    
}
