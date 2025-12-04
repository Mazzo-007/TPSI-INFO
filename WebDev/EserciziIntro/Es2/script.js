let btn = document.getElementById("btn");
let fatt1 = document.getElementById("fatt1");
let fatt2 = document.getElementById("fatt2");
let result = document.getElementById("result");

let r;

btn.addEventListener("click", () => {
    r = parseInt(fatt1.value) + parseInt(fatt2.value);
    result.textContent = r;
});