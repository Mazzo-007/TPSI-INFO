//Prendere i nome dal DOM tramite input text.
let names = [];

let nameInput = document.getElementById("name");
let btnAdd = document.getElementById("addBtn");
let btn = document.getElementById("btn");
let resObj = document.getElementById("res");

// find max. le str sono array
// foreach JS
// per ogni elemento della collezione names. for non indicizzato
// [5,2,9,7] -> max 9

// JS è attinente allo standard ES6, con ES6 se prima di una variabile non si mette nulla allora essa sarà globale altri,
// mentre con let o const sarà locale al blocco di codice in cui è definita

// funzioni anonime (lambda function)
btn.addEventListener("click", () => {
    let maxName = names[0];
    for (let elem of names) {
        let nameLength = elem.length;
        if (nameLength > maxName.length) {
            maxName = elem;
        }
    }

    //show result
    resObj.textContent = "Il nome più lungo è " + maxName + " con " + maxName.length + " lettere.";
});

btnAdd.addEventListener("click", () => {
    let name = nameInput.value;
    names.push(name);
    nameInput.value = "";
});
