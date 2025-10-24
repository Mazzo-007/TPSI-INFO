let label = document.getElementById("result");
let input = document.getElementById("btn");

btn.addEventListener("click", sayHello);

function sayHello() {
    label.textContent = "Ciao Studente!";
}