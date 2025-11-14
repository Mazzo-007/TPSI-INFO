let display = document.getElementById("timer")
let startBtn = document.getElementById("startBtn")
let resetBtn = document.getElementById("resetBtn")
let pauseBtn = document.getElementById("pauseBtn")

let timer = {
    seconds: 1500,
    running: false
}

function updateView() {
    let min = parseInt(timer.seconds / 60)
    let sec = timer.seconds % 60;

    display.textContent = min+":"+sec
}

function tick() {
    timer.seconds--;
    updateView()
}

function start() {
    if(!timer.running) {
        timer.running = true;
        setInterval(tick, 1000)
    }
}

// Se la funzione è corta allora lamda
// altrimenti normale
startBtn.addEventListener("click", start)
