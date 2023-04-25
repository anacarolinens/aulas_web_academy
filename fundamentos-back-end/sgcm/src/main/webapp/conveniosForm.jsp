<%@ page pageEncoding="UTF-8" %>

<%@ page import="java.util.List" %>
<%@ page import="br.ufac.sgcm.model.Convenio" %>

<jsp:useBean
    id="controllerC"
    class="br.ufac.sgcm.controller.ConvenioController"
    scope="page" />
<jsp:useBean
    id="item"
    class="br.ufac.sgcm.model.Convenio"
    scope="page" />

<%
    String pageTitle="Convênios Formulário";

    String paramId = request.getParameter("id");
    if (paramId != null && !paramId.isEmpty()) {
        Long id = Long.parseLong(paramId);
        item = controllerC.get(id);
    }



    String submit = request.getParameter("submit");
    if (submit != null) {

        if (paramId != null && !paramId.isEmpty()) {
            Long id = Long.parseLong(request.getParameter("id"));
            item.setId(id);
        }
        item.setAtivo(Boolean.parseBoolean(request.getParameter("ativo")));
        item.setCnpj(request.getParameter("cnpj"));
        item.setEmail(request.getParameter("email"));
        item.setNome(request.getParameter("nome"));
        item.setRazaoSocial(request.getParameter("razao_social"));
        item.setRepresentante(request.getParameter("representante"));
        item.setTelefone(request.getParameter("telefone"));
        
        
        controllerC.save(item);
        pageContext.forward("convenios.jsp");

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

                    <input type="hidden" name="id" value="<%=item.getId() != null ? item.getId() : "" %>">

                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" value="<%=item.getNome() != null ? item.getNome() : "" %>" required>

                    <label for="razaoSocial">Razão Social</label>
                    <input type="text" name="razao_social" id="razao_social" value="<%=item.getRazaoSocial() != null ? item.getRazaoSocial() : "" %>" required>

                    <label for="cnpj">CNPJ</label> 
                    <input type="text" name="cnpj" id="cnpj" value="<%=item.getCnpj() != null ? item.getCnpj() : "" %>" required>

                    <label for="representante">Representante</label>
                    <input type="text" name="representante" id="representante" value="<%=item.getRepresentante() != null ? item.getRepresentante() : "" %>" required>

                    <label for="email">E-mail</label>
                    <input type="text" name="email" id="email" value="<%=item.getEmail() != null ? item.getEmail() : "" %>" required>

                    <label for="telefone">Telefone</label>
                    <input type="text" name="telefone" id="telefone" value="<%=item.getTelefone() != null ? item.getTelefone() : "" %>" required>

                    <label for="ativo">Ativo</label>
                    <input type="checkbox" name="ativo" id="ativo" value="true" <%=item.isAtivo() ? "checked" : ""%> >


                </div>

                <input type="button" value="Cancelar" data-url="convenios.jsp">
                <input type="submit" name="submit" value="Salvar">

            </form>
        </main>
        <%@ include file="include/footer.jsp" %>
    </body>
</html>