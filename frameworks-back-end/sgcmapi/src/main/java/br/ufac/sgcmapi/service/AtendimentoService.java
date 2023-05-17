package br.ufac.sgcmapi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.model.EStatus;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@Service
public class AtendimentoService implements IService<Atendimento> {

    private AtendimentoRepository repo;
    public AtendimentoService(AtendimentoRepository repo){ //construtor
        this.repo = repo;
    }


    @Override
    public List<Atendimento> get() {
        return repo.findAll(); //Lista de atendimento
    }

    @Override
    public Atendimento get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Atendimento save(Atendimento objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        //mudar o status para cancelado/ remove o registro logicamente
        Atendimento registro = repo.findById(id).orElse(null);
        registro.setStatus(EStatus.CANCELADO);
        repo.save(registro);
    }
     
}
