/**
 * Realizza un’applicazione che genera automaticamente un bottone nel DOM ogni secondo. 
 * Il bottone deve avere come testo e valore un numero progressivo (1, 2, 3,…). 
 * 
 * Ogni bottone deve essere inserito in un div dedicato. Quando l’utente clicca su un bottone:
 *   - Il valore del bottone viene aggiunto a una somma totale;
 *   - La somma deve essere mostrata dinamicamente nel DOM;
 *   - Dopo 30 bottoni generati, ferma automaticamente la generazione. Quando un bottone viene cliccato, eliminalo dal DOM (se append() aggiunge remove() rimuove). 
 * Infine, crea un pulsante reset che:
 *   - Azzera la somma;
 *   - Elimina ogni bottone (devo manipolare il contenuto html e azzerarlo);
 *   - Riparte la generazione dal valore 1.
 */

let btnContainer = document.getElementById("btnContainer")
let index = 1
let summ = 0

setTimeout( () => { 
    let btn = document.createElement("button")

    btn.textContent = index
    btn.value = index++

    btn.addEventListener("click", () => {
        summ += Number(btn.value)
    })
 }, 1000)

