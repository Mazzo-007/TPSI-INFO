let num = document.getElementById("num");
let btn = document.getElementById("btn");
let res = document.getElementById("res");

let arr =[1,4,7,23,9,32,2,11];
let controllo;

btn.addEventListener("click", () => {
    controllo = true;
    for (i = 0; i < arr.length; i++) {
        if (Number(num.value) === arr[i]) {
            res.textContent = "Numero TROVATO !!"
            controllo = false;
            break;
        }
    }
    if (controllo) res.textContent = "Numero NON TROVATO !!"
})