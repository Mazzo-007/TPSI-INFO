/**
 * Crea un pulsante “Mostra notifica”. Ogni volta che l’utente clicca, devi generare dinamicamente una notifica che scompare dopo 3 secondi.
 * Al click crea un <div> usando createElement.
 * Imposta il testo “Nuova notifica #N”.
 * Aggiungi la notifica a un container usando .append().
 * Dopo 3 secondi, rimuovila.
 * Le notifiche devono impilarsi (non sovrascriversi).
 */

let btn = document.getElementById("btn")
let notificationDiv = document.getElementById("notificationContainer")
let index = 1;

btn.addEventListener("click", () => {
    let newNotification = document.createElement("div")

    newNotification.textContent = "NOTIFICA #" + index++

    notificationDiv.append(newNotification)

    setTimeout(() => { newNotification.remove() }, 3000)
})