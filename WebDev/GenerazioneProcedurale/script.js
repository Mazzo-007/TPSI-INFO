console.log("Script caricato correttamente");
let btn = document.createElement("button");

btn.textContent = "Click";

btn.addEventListener("click", () => {
    alert("Bottone cliccato");
});

document.body.appendChild(btn);
console.log("Bottone creato correttamente");

//Temporizzazione

//1) setTimeout(function, time) => ONESHOT
setTimeout(() => alert("Ciaoo"), 2000);

//2) setInterval() => RIPETITIVO
let timer1 = setInterval(() => console.log("timer"), 1000);

//fermare interval/timeout
setTimeout(() => clearInterval(timer1), 10000);