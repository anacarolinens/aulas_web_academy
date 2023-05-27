package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Profissional;
import br.ufac.sgcmapi.repository.ProfissionalRepository;

@Service
public class ProfissionalService implements IService<Profissional> {

    private ProfissionalRepository repo;

    public ProfissionalService(ProfissionalRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Profissional> get() {
        return repo.findAll();
    }

    @Override
    public Profissional get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Profissional> get(String termoBusca) {
        return repo.findByAll(termoBusca);
    }

    @Override
    public Profissional save(Profissional objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
