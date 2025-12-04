let voto = document.getElementById("voto");
let btn = document.getElementById("btn");
let res = document.getElementById("res");

btn.addEventListener("click", () => {
    if (!(voto.value > 10 || voto.value < 0)) {
        if (voto.value >= 6) res.textContent = "PROMOSSO !!";
        else res.textContent = "BOCCIATO !!";
    } else {
        res.textContent = "Valore non validi";
    }
})