package br.ufac.sgcmapi;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufac.sgcmapi.model.Atendimento;
import br.ufac.sgcmapi.repository.AtendimentoRepository;

@SpringBootApplication
@Controller
public class SgcmapiApplication {

	private AtendimentoRepository repo;

	public SgcmapiApplication(AtendimentoRepository repo) {
		this.repo = repo;
	}

	@RequestMapping("/")
	@ResponseBody
	public String exemplo() {
		List<Atendimento> atendimentos = repo.findAll();
		StringBuilder resultado = new StringBuilder();
		for (Atendimento item: atendimentos) {
			resultado.append(item.getId() + "\n");
			resultado.append(item.getData() + "\n");
			resultado.append(item.getHora() + "\n");
			resultado.append(item.getStatus() + "\n");
			resultado.append(item.getPaciente().getNome() + "\n");
			resultado.append(item.getProfissional().getNome() + "\n");
			resultado.append(item.getConvenio().getNome() + "\n");
		}
		return resultado.toString();
		// return "Spring Boot!";
	}

	public static void main(String[] args) {
		SpringApplication.run(SgcmapiApplication.class, args);
	}

}
