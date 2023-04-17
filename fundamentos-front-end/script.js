let botoesExcluir = document.querySelectorAll('a.botao.excluir'); //selecionar o boão

console.log(botoesExcluir);

for (let botao of botoesExcluir) {
    botao.addEventListener("click", () => {
        if (confirm("Deseja realmente excluir?")) {

            botao.parentNode.parentNode.remove();
        }
    })
}
// //alterar a forma como o usuário acessa o formulário de cadastro

// let formCadastro = document.querySelector('#formCadastro');

// formCadastro.style.display = 'none'; //ocutar o formulário

// let botaoAdicionar = document.querySelector('a.botao.adicionar');

// botaoAdicionar.addEventListener('click', () => {
//     formCadastro.style.display = 'block'; //mostra o formulário
// });



// let botaoCancelar = document.querySelector('input[id="cancelar"]'); // especifica o botao

// botaoCancelar.addEventListener('click', () => {
//     formCadastro.style.display = 'none'; //Ocuta o botão novamente
// });


let botaoAdd = document.querySelector("a.botao#add");
botaoAdd.addEventListener("click", () => {
    let form = document.querySelector("form#formCadastro");
    form.classList.remove("inativo");
});

let botaoCancelar = document.querySelector("form input[value='Cancelar']");
if (botaoCancelar) {
    botaoCancelar.addEventListener("click", event => {
        let form = event.target.parentNode;
        form.reset();
        form.classList.add("inativo");
    });
}





let botaoCarregar = document.querySelector("a#carregar");

console.log(botaoCarregar);

carregarTabela = () => {
        let tabela = document.querySelector("table");
        let url = "http://my-json-server.typicode.com/danielnsilva/json/profissionais";
        //xhr.open("GET", url);
        //xhr.addEventListener("readystatechange", () => {
        //if (xhr.readyState == 4 && xhr.status == 200) {
        //                 let dados = JSON.parse(xhr.responseText);
        //                 for (const item of dados){
        //                     //Criando os elementos
        //                     let linha = document.createElement("tr");
        //                     let id = document.createElement("td");
        //                     let nome = document.createElement("td");
        //                     let registro = document.createElement("td");
        //                     let especialidade = document.createElement("td");
        //                     let unidade = document.createElement("td");
        //                     let telefone = document.createElement("td");
        //                     let email = document.createElement("td");
        //                     let acoes = document.createElement("td");
        //                     //atribuindo valores aos elementos
        //                     id.classList.add("fit");
        //                     id.textContent = item.id;
        //                     nome.textContent = item.nome;
        //                     registro.textContent = item.registro;
        //                     especialidade.textContent = item.especialidade;
        //                     unidade.textContent = item.unidade;
        //                     telefone.textContent = item.telefone;
        //                     email.textContent = item.email;
        //                     acoes.innerHTML = '<a href="javascript:void(0)" class="botao">Editar</a> <a href="javascript:void(0)" class="botao excluir">Excluir</a> ';
        //                     //colocando os elementos nas linhas da tabela
        //                     linha.appendChild(id);
        //                     linha.appendChild(nome);
        //                     linha.appendChild(registro);
        //                     linha.appendChild(especialidade);
        //                     linha.appendChild(unidade);
        //                     linha.appendChild(telefone);
        //                     linha.appendChild(email);
        //                     linha.appendChild(acoes);
        //                     tabela.tBodies[0].appendChild(linha);


        //                 }
        //             //}
        //        // );
        //         //xhr.send();

        fetch(url).then(resposta => resposta.json()).then(dados => {
            for (const item of dados) {
                //Criando os elementos
                let linha = document.createElement("tr");
                let id = document.createElement("td");
                let nome = document.createElement("td");
                let registro = document.createElement("td");
                let especialidade = document.createElement("td");
                let unidade = document.createElement("td");
                let telefone = document.createElement("td");
                let email = document.createElement("td");
                let acoes = document.createElement("td");
                //atribuindo valores aos elementos
                id.classList.add("fit");
                id.textContent = item.id;
                nome.textContent = item.nome;
                registro.textContent = item.registro;
                especialidade.textContent = item.especialidade;
                unidade.textContent = item.unidade;
                telefone.textContent = item.telefone;
                email.textContent = item.email;
                acoes.innerHTML = '<a href="javascript:void(0)" class="botao">Editar</a> <a href="javascript:void(0)" class="botao excluir">Excluir</a> ';
                //colocando os elementos nas linhas da tabela
                linha.appendChild(id);
                linha.appendChild(nome);
                linha.appendChild(registro);
                linha.appendChild(especialidade);
                linha.appendChild(unidade);
                linha.appendChild(telefone);
                linha.appendChild(email);
                linha.appendChild(acoes);
                tabela.tBodies[0].appendChild(linha);
            }
        }).catch(erro => {
            console.log(erro);
        })
    }
carregarTabela()

//botão salvar
let botaoSalvar = document.querySelector('input[type="button"][value="salvar"]');

    //Criando os elementos
if (botaoSalvar) {
    botaoSalvar.addEventListener("click", event => {
        event.preventDefault();
        let form = event.target.parentNode;
        let tabela = document.querySelector("table");
        let linha = document.createElement("tr");
        let id = document.createElement("td");
        let nome = document.createElement("td");
        let registro = document.createElement("td");
        let especialidade = document.createElement("td");
        let unidade = document.createElement("td");
        let telefone = document.createElement("td");
        let email = document.createElement("td");
        let acoes = document.createElement("td");
        //atribuindo valores aos elementos
        id.classList.add("fit");
        id.textContent = tabela.tBodies[0].rows.length + 1;
        nome.textContent = form.nome.value;
        registro.textContent = form.registroConselho.value;
        especialidade.textContent = form.especialidade.options[form.especialidade.selectedIndex].label;
        unidade.textContent = form.unidade.options[form.unidade.selectedIndex].label;
        telefone.textContent = form.telefone.value;
        email.textContent = form.email.value;
        acoes.innerHTML = '<a href="javascript:void(0)" class="botao">Editar</a> <a href="javascript:void(0)" class="botao excluir">Excluir</a> ';
        //colocando os elementos nas linhas da tabela
        linha.appendChild(id);
        linha.appendChild(nome);
        linha.appendChild(registro);
        linha.appendChild(especialidade);
        linha.appendChild(unidade);
        linha.appendChild(telefone);
        linha.appendChild(email);
        linha.appendChild(acoes);
        tabela.tBodies[0].appendChild(linha);
        form.reset();
        form.classList.add("inativo");
    });
}




