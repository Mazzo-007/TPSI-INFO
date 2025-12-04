let btn = document.getElementById("btn");
let res = document.getElementById("res");

let arr =[1,4,7,23,9,32,2,11];
let r;

let showRes = document.createElement("p");

btn.addEventListener("click", () => {
    r = 0;
    for (i = 0; i < arr.length; i++) {
        r += arr[i];
    }
    showRes.textContent = "Somma = " + r;
    res.appendChild(showRes);
})