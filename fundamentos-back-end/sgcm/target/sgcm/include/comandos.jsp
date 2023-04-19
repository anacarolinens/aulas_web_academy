<%@ page pageEncoding="UTF-8" %>
            <div id="comandos">
                <a href="<%=request.getParameter("link")%>"
                   id="add"
                   class="botao">Adicionar</a>
                <div>
                    <form action="">
                        <label for="busca">Busca</label>
                        <input type="search" name="busca" id="busca">
                    </form>
                </div>
            </div>