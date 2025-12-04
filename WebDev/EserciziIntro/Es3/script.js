let value = document.getElementById("in");
let btn = document.getElementById("btn");
let res = document.getElementById("result");

btn.addEventListener("click", () => {
    if (value.value % 2 === 0) res.textContent = "Il numero è pari";
    else res.textContent = "Il numero è dispari";
})