//CONTROLLER WIP

//il DOM e' il Document Object Model, una rappresentazione strutturata del contenuto di una pagina web.
//Il DOM consente di accedere e manipolare gli elementi HTML e CSS tramite JavaScript.
//Ad esempio, possiamo usare il DOM per cambiare il testo di un paragrafo, modificare lo stile di un elemento o aggiungere nuovi elementi alla pagina.

//Ecco un esempio di come usare il DOM per ottenere il contenuto di un elemento HTML con l'id "result": e' un oggetto di tipo stringa
let output = document.getElementById("result");
let inputObjet = document.getElementById("input");
let btn = document.getElementById("btn");
output.textContent = "Ciao";// Modifica il testo dell'elemento con id "result" senza interpretare i tag HTML

//InnerHTML permette di inserire codice HTML all'interno di un elemento
//RISCHIOSO
output.innerHTML += "<strong> Mondo</strong>";

//Prendere l'input dall'utente e visualizzarlo nel paragrafo quando si clicca il bottone
//Bisogna ricordarsi di non mettere le parentesi tonde alla fine della funzione altrimenti viene eseguita subito e non può più essere riusato
btn.addEventListener("click", getInputAndShow);

//Prendere numero da utente -> n+5
function getInputAndShow() {
    let v = (Number)(inputObjet.value); //prende il valore dall'input
    output.textContent = v + ": " + (v + 5); //concatena la stringa con il numero aumentato di 5
}