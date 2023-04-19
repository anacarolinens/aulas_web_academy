
let botoesExcluir = document.querySelectorAll("a.botao.excluir");
for (let botao of botoesExcluir) {
    botao.addEventListener("click", evento => {
        if (!confirm("Deseja realmente excluir?")) {
            evento.preventDefault();
        }
    });
}