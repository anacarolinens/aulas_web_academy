package br.ufac.sgcm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import br.ufac.sgcm.dao.EspecialidadeDao;
import br.ufac.sgcm.dao.ProfissionalDao;
import br.ufac.sgcm.dao.UnidadeDao;
import br.ufac.sgcm.model.Especialidade;
import br.ufac.sgcm.model.Profissional;
import br.ufac.sgcm.model.Unidade;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

public class PrimeiroServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res)throws ServletException, IOException {
    PrintWriter saida = res.getWriter();
    // saida.println("<html>");
    // saida.println("<head>");
    // saida.println("<title>Primeiro Servlet</title>");
    // saida.println("</head>");
    // saida.println("<body>");
    // saida.println("<h1>Exemplo de Servlet</h1>");
    // saida.println("</form>");
    // saida.println("</body>");
    // saida.println("</html>");
    // }
    ProfissionalDao dao = new ProfissionalDao();
    List<Profissional> profissionais = dao.get();
    // for (Profissional item : profissionais) {
    //     saida.println(item.getNome());
    //     saida.println(item.getEmail());
    //     saida.println(item.getEspecialidade().getNome());
    //     saida.println(item.getUnidade().getNome());
    //     saida.println();
    //     }

    // Profissional p = dao.get(1L);
    // saida.println(p.getNome()); //pegando o nome
    // p.setNome("Ana"); //alterando o nome
    // dao.update(p); //Fazendo update
    // p = dao.get(1L);
    // saida.println(p.getNome()); //verificando se alterou


       

    List<Profissional> profissionaisBusca = dao.get("cardiologia");
    for (Profissional itemProfissional : profissionaisBusca){
        saida.println(itemProfissional.getNome());
        saida.println(itemProfissional.getEspecialidade().getNome());
        saida.println();

    }


        EspecialidadeDao dao2 = new EspecialidadeDao();
        List<Especialidade> especialidades = dao2.get();
        // for (Especialidade item : especialidades) {
        //     saida.println(item.getId());
        //     saida.println(item.getNome());
        //     saida.println();
        // }
        
        UnidadeDao dao3 = new UnidadeDao();
        List<Unidade> unidades = dao3.get();
        // for (Unidade item: unidades) {
        //    saida.println(item.getId());
        //     saida.println(item.getNome());
        //     saida.println(item.getEndereco());
        //     saida.println();
        // }
    }



   
 }

