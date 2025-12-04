let inputName = document.getElementById("name");
let inputSpesa = document.getElementById("spesa");
let AddBtn = document.getElementById("AddBtn");

let showSpese = document.getElementById("listaSpese");
let showSpeseTot = document.getElementById("totSing");
let showAvarageSpesa = document.getElementById("avarageSpesa");
let showRestituzioni = document.getElementById("restituzioni");

let names = [];
let spese = [];
let media;

AddBtn.addEventListener("click", addSpesa);

function addSpesa() {
    let controllo = true;

    for (let elem of names) {
        if (elem === inputName.value) {
            controllo = false;
            break;
        } 
    }

    if (controllo) names.push(inputName.value);

    let spesa = {nome: inputName.value, spesa: Number(inputSpesa.value)};

    spese.push(spesa);

    UpdateShowSpese(spesa);

    UpdateShowSpeseTot();

    UpdateShowAvarageSpesa();

    UpdateShowRestituzioni();
}

function UpdateShowSpese(spesa) {
    let newSpesa = document.createElement("p");
    newSpesa.textContent = spesa.nome + ": " + spesa.spesa + " €";
    showSpese.appendChild(newSpesa);
}

function UpdateShowSpeseTot() {
    showSpeseTot.textContent = "";

    let tot;
    
    for (let elem of names) {
        tot = 0;
        for (let obj of spese) {
            if (obj.nome === elem) {
                tot += obj.spesa;
            }
        }
        let newSpesaTot = document.createElement("p");
        newSpesaTot.textContent = elem + ": " + tot + " €";
        showSpeseTot.appendChild(newSpesaTot);
    }
}

function UpdateShowAvarageSpesa() {
    media = 0;

    for (let elem of spese) {
        media += elem.spesa;
    }

    media /= names.length;

    showAvarageSpesa.textContent = "Media: " + media + " €";
}

function UpdateShowRestituzioni() {
    showRestituzioni.textContent = "";
    let str;
    let pay;

    let deb = [];
    let cred = [];

    for (let elem of names) {
        tot = 0;
        for (let obj of spese) {
            if (obj.nome === elem) {
                tot += obj.spesa;
            }
        }
        let saldo = tot - media
        if (saldo > 0) cred.push({nome: elem, saldo: saldo});
        else deb.push({nome: elem, saldo: (saldo*-1)});
    }

    do {
        for (i = 0; i < deb.length; i++){
            let elem = deb[i];
            if (elem.saldo > cred[0].saldo) {
                pay = cred[0].saldo;
                elem.saldo -= cred[0].saldo;
                str = elem.nome + ": " + pay + " € --> " + cred[0].nome;
                cred.splice(0, 1);
            } else {
                pay = elem.saldo;
                cred[0].saldo -= pay;
                str = elem.nome + ": " + pay + " € --> " + cred[0].nome;
                deb.splice(i, 1);
                i--;
            }
    
            let newRestituzione = document.createElement("p");
            newRestituzione.textContent = str;
            showRestituzioni.appendChild(newRestituzione);
        }
    } while (deb.length > 0);
}