<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Profissional" %>
<%@ page import="br.ufac.sgcm.model.Especialidade" %>
<%@ page import="br.ufac.sgcm.model.Unidade" %>

<jsp:useBean
    id="controllerP"
    class="br.ufac.sgcm.controller.ProfissionalController"
    scope="page" />

<jsp:useBean
    id="controllerE"
    class="br.ufac.sgcm.controller.EspecialidadeController"
    scope="page" />

<jsp:useBean
    id="controllerU"
    class="br.ufac.sgcm.controller.UnidadeController"
    scope="page" />

<jsp:useBean
    id="item"
    class="br.ufac.sgcm.model.Profissional"
    scope="page" />


<%
    String paramId = request.getParameter("id");
    if (paramId != null && paramId.isEmpty()) { //verificando o id
        Long id = Long.parseLong(request.getParameter("id"));
        item = controllerP.get(id); //tenta recuperar do banco

    }

    String submit = request.getParameter("submit");
    if (submit != null) {

        if (paramId != null && paramId.isEmpty()) { //verificando o id
            Long id = Long.parseLong(request.getParameter("id"));
            item.setId(id);
        }

        item.setNome(request.getParameter("nome"));
        item.setRegistroConselho(request.getParameter("registroConselho"));
        item.setTelefone(request.getParameter("telefone"));
        item.setEmail(request.getParameter("email"));

        Especialidade especialidade =  new Especialidade();
        Long especialidadeId = Long.parseLong(request.getParameter("especialidade"));
        especialidade.setId(especialidadeId);
        item.setEspecialidade(especialidade);

        Unidade unidade = new Unidade();
        Long unidadeId = Long.parseLong(request.getParameter("unidade"));
        unidade.setId(unidadeId);
        item.setUnidade(unidade);

        controllerP.save(item);
        pageContext.forward("profissionais.jsp");

    }

%>

<!DOCTYPE html>
<html>
    <%@ include file="include/head.jsp" %>
    <body>
        <%@ include file="include/header.jsp" %>
        <%@ include file="include/nav.jsp" %>
        <main>
            <form id="formCadastro" method="post">

                <div class="grid">

                <input type="hidden" nome="id" value="<%item.getId() != null ? item.getId() : ""%>">

                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nome" value="<%item.getNome() != null ? item.getNome() : ""%>" required>

                <label for="registroConselho">Registro</label>
                <input type="text" name="registroConselho" id="registroConselho" value="<%item.getRegistroConselho() != null ? item.getRegistroConselho() : ""%>" required>
                
                <label for="telefone">Telefone</label>
                <input type="tel" name="telefone" id="telefone" value="<%item.getTelefone() != null ? item.getTelefone() : ""%>">
                
                <label for="email">E-mail</label>
                <input type="email" name="email" id="email" value="<%item.getEmail() != null ? item.getEmail() : ""%>">
                
                <label for="especialidade">Especialidade</label>
                 <select name="especialidade" id="especialidade" required>
                    <option value=""></option>
                    <% 
                    
                            for (Especialidade e : controllerE.get()) { 
                            selecionado = "";
                            if(item.getId() != null) {
                                if (e.getId() == item.getEspecialidade().getId()) {
                                    selecionado = "selected";
                                }
                            }
                            
                    %>
                    <option value="<%=e.getId()%>"  <%selecionado%>><%=e.getNome()%></option>
                    <% } %>
                </select>
                
                <label for="unidade">Unidade</label>
                <select name="unidade" id="unidade" required>
                    <option value=""></option>
                                        <% 
                    
                        String selecionado = "";
                        for (Unidade e : controllerE.get()) { 
                            selecionado = "";
                            if(item.getId() != null) {
                                if (e.getId() == item.getUnidade().getId()) {
                                    selecionado = "selected";
                                }
                            }
                            
                    %>
                    <option value="<%=e.getId()%>"  <%selecionado%>><%=e.getNome()%></option>
                    <% } %>
                </select>

                </div>

                <input type="button" value="Cancelar" data-url="profissionais.jsp">
                <input type="submit" value="Salvar" name="submit">

            </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>