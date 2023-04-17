# fundamentos-front-end
Repositório da disciplina Fundamentos de Programação Front-end

# Atualizando seu repositório local

O código produzido em sala de aula, e compartilhado neste repositório, pode ser atualizado em seu repositório local com o comando:

```console
git pull
```

No entando, se você fez alterações no seu repositório local, o comando acima pode gerar conflitos. Para evitar lidar com isso, você pode forçar uma atualização com o repositório remoto por meio dos comandos:

```console
git fetch origin
git reset --hard origin/main
```

O primeiro comando recebe as atualizações mais recentes do repositório remoto, e o segundo descarta todas as alterações locais e atualiza com o histórico mais recente do repositório remoto (branch main).

# Sites de referência

- MDN Web Docs - Aprendendo desenvolvimento web: https://developer.mozilla.org/pt-BR/docs/Learn
- W3Schools Online Web Tutorials: https://www.w3schools.com/
- W3C Standards: https://www.w3.org/standards/

# Ferramentas

- **Visual Studio Code**
  - https://code.visualstudio.com/Download
- **Live Server (Extensão do VS Code)**
  - https://marketplace.visualstudio.com/items?itemName=ritwickdey.LiveServer
- **Git**
   - https://git-scm.com/downloads
- **Chrome Developer Tools (Ctrl+Shift+I)**

# SGCM - Diagrama de Classes

![SGCM_Diagrama_Classes](SGCM_Diagrama_Classes.png)

# Atividade prática

1. Construir páginas para cadastro de usuários, convênios, unidades, especialidades e pacientes, de forma semelhante à página de cadastro de profissionais, e baseado no diagrama de classes acima.

    - Parte 1: HTML e CSS (Entrega: 03/04/2023)

      - Solução: https://github.com/webacademyufac/fundamentos-front-end/compare/35a65ec...4c3b012

    - Parte 2: JavaScript (Entrega: 10/04/2023)

      - Não é necessário implementar a funcionalidade de carregar dados de um arquivo JSON, somente o conteúdo relacionado às atividades 2 e 3.

2. Alterar a forma como o usuário acessa o formulário de cadastro. (Entrega: 05/04/2023)

    - O formulário não deve ser visualizado ao carregar a página, mas somente quando o usuário clicar no botão "Adicionar".
    - O formulário deve voltar ao estado inicial quando o usuário clicar no botão "Cancelar".
    - DICA: a visualização dos elementos HTML pode ser controlada por meio da propriedade *display*.

3. Atribuir uma ação para o botão "Salvar" do formulário, para inserir na tabela os valores de cada campo do formulário. (Entrega: 05/04/2023)

    - Os campos do tipo "select" possuem, além do valor do campo, um rótulo que representa o conteúdo visível para o usuário, sendo este o conteúdo que deve ser inserido na tabela.
    - DICA: pode utilizar a mesma abordagem apresentada no exemplo de inserção de dados na tabela, ou pesquisar sobre outros métodos como: [insertAdjacentElement()](https://developer.mozilla.org/en-US/docs/Web/API/Element/insertAdjacentElement), [insertAdjacentHTML()](https://developer.mozilla.org/en-US/docs/Web/API/Element/insertAdjacentHTML) e [insertAdjacentText()](https://developer.mozilla.org/en-US/docs/Web/API/Element/insertAdjacentText).

4. Implementar um filtro para a tabela de profissionais, baseado no campo de busca, de forma que o usuário possa filtrar os profissionais pelo conteúdo de qualquer atributo. (Entrega: 05/04/2023)

    - O filtro deve ser aplicado sempre que o conteúdo do campo de busca for alterado.
    - O termo de busca deve ser destacado na tabela quando encontrado.
    - Deve ser criada uma função para atribuir o evento de exclusão de um profissional ao botão "Excluir", que deve ser chamado sempre que o conteúdo da tabela for atualizado.
    - DICA: O evento [input](https://developer.mozilla.org/en-US/docs/Web/API/HTMLElement/input_event) pode ser utilizado para detectar alterações no conteúdo de um campo de texto.
    - DICA: O método [filter()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/Array/filter) pode ser utilizado para filtrar os elementos de um array.
    - DICA: O método [includes()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/includes) pode ser utilizado para verificar se uma string contém um determinado conteúdo.
    - DICA: O método [toLowerCase()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/toLowerCase) pode ser utilizado para converter uma string para letras minúsculas.
    - DICA: o elemento HTML [mark](https://developer.mozilla.org/en-US/docs/Web/HTML/Element/mark) pode ser utilizado para destacar o termo de busca na tabela.
    - DICA: o método [replace()](https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/replace) pode ser utilizado para substituir um conteúdo por outro em uma string.

> **IMPORTANTE:** Todos os membros dos grupos devem participar das atividades, registrando esta participação por meio da identificação dos commits com seus respectivos usuários no GitHub.
