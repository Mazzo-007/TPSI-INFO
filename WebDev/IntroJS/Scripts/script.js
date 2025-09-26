//In JS non è necessario il punto e virgola alla fine di ogni riga
//Ma è buona norma metterlo

console.log("Hello");

//JS è debolmente tipizzato
//Non serve specificare il tipo di variabile

//Variabili
let x = 5;
let y = "Ciao";

//Costanti
const PI = 3.14;

console.log("x: " + typeof(x));

x = "Ciao";

console.log("x: " + typeof(x));

console.log("y: " + typeof(y));
console.log("PI: " + typeof(PI));

//Booleani: true o false
let isTrue = true;
let isFalse = false;

//Undefined è null
//Undefined è di default
//Null è un valore assegnato

let a; //undefined
let b = null; //null

console.log("a: " + typeof(a));
console.log("b: " + typeof(b));
console.log("b: " + b);

//Array
let arr = [1, 2, 3, 4, 5];
console.log("arr: " + typeof(arr));

//Oggetti
let obj = {
    nome: "Luca",
    cognome: "Mazzoni",
    eta: 18
};
console.log("obj: " + typeof(obj));

//Stringhe
let str = "Ciao";
console.log("str: " + str);
console.log("str[2]: " + str[2]);
console.log("str.charAt(2): " + str.charAt(2));
console.log("str.toUpperCase(): " + str.toUpperCase()); //tutto maiuscolo
console.log("str.toLowerCase(): " + str.toLowerCase()); //tutto minuscolo
console.log("str.indexOf('a'): " + str.indexOf("a")); //2
console.log("str.indexOf('z'): " + str.indexOf("z")); //-1 se non trova la lettera
console.log("str.lastIndexOf('a'): " + str.lastIndexOf("a")); //2
console.log("str.includes('a'): " + str.includes("a")); //true
console.log("str.slice(1, 3): " + str.slice(1, 3)); //da 1 a 3 (escluso) ha sostituito substring
console.log("replace: " + str.replace("i", "X")); //sostituisce i con X (la prima occorrenza) con replaceAll sostituisce tutte le occorrenze
console.log("split: " + str.split("")); //divide la stringa in un array
console.log("str.length: " + str.length);

//Operazioni
// +, -, *, /, %, **
//BIMDAS (Brackets, Indices, Multiplication and Division, Addition and Subtraction)
//(), **, *, /, %, +, -

console.log("5 **3 : " + (5 ** 3));
console.log("5 * 'Ciao': " + (5 * "Ciao")); //NaN (Not a Number)
console.log("Nan: " + typeof(NaN));

//Funzioni
function somma(num1, num2) {
    return num1 + num2;
}

console.log("somma: " + typeof(somma));
console.log("somma(5, 10): " + somma(5, 10));