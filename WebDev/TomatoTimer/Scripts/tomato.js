let display = document.getElementById("timer")
let startBtn = document.getElementById("startBtn")
let resetBtn = document.getElementById("resetBtn")
let pauseBtn = document.getElementById("pauseBtn")
let interval;

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
        interval = setInterval(tick, 1000)
    }
}

function reset() {
    clearInterval(interval)
    timer.seconds = 1500
    timer.running = false
    updateView()
}

function pause() {
    clearInterval(interval)
    timer.running = false
}

// Se la funzione è corta allora lamda
// altrimenti normale
startBtn.addEventListener("click", start)
resetBtn.addEventListener("click", reset)
pauseBtn.addEventListener("click", pause)
