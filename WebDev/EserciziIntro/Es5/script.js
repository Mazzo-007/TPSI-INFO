let arr =["mela", "pera", "pesca"];

let btn = document.getElementById("btn");
let res = document.getElementById("res");

btn.addEventListener("click", () => {
    res.textContent = "Ci sono " + arr.length + " frutti";
})