let index = document.getElementById("i");
let btn = document.getElementById("btn");
let res = document.getElementById("res");

let arr =["mela", "pera", "pesca"];

btn.addEventListener("click", () => {
    if (!(index.value >= arr.length || index.value < 0)) {
        res.textContent = "Il frutto all'indice " + index.value + " è: " + arr[index.value];
    } else {
        res.textContent = "Indice non valido";
    }
})