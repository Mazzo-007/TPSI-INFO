let voti = [6, 4, 8, 3, 3, 9, 10];

let lbl = document.getElementById("voti");
lbl.textContent = voti;

document.body.appendChild(lbl);

let btn = document.createElement("button");
btn.textContent = "calcola";

document.body.appendChild(btn);

let risultato = 0;
let lbl2 = document.createElement("label");
btn.addEventListener("click", () => {
    voti.forEach(elemet => {
        risultato += elemet;
    });
    risultato /= voti.length;
    lbl2.textContent = risultato;
    document.body.appendChild(lbl2)
    risultato = 0;
});