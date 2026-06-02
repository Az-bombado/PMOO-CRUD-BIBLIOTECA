document.addEventListener("DOMContentLoaded", () => {

    const modal = document.getElementById("modal");

    window.abrirModal = function () {
        modal.style.display = "flex";
    }

    window.fecharModal = function () {
        modal.style.display = "none";
    }

    const pesquisa = document.getElementById("pesquisa");

    pesquisa.addEventListener("keyup", () => {

        const valor = pesquisa.value.toLowerCase();

        const linhas =
            document.querySelectorAll("#tabelaLivros tr");

        linhas.forEach(linha => {

            const texto =
                linha.innerText.toLowerCase();

            linha.style.display =
                texto.includes(valor)
                    ? ""
                    : "none";
        });

    });

});