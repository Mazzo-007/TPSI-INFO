// PRO TIP CTR + J

// libreria HTTP
const http = require("http")

const PORT = 80
const HOSTNAME = "localhost"

const user = [
    { età: 1, username: "Mario Rossi", email: "mario.rossi@gmail.com" },
    { età: 2, username: "Luigi Bianchi", email: "luigi.bianchi@gmail.com" },
    { età: 3, username: "Giulia Verdi", email: "giulia.verdi@gmail.com" },
    { età: 4, username: "Anna Neri", email: "anna.neri@gmail.com" },
    { età: 5, username: "Paolo Russo", email: "paolo.russo@gmail.com" }
]

const server = http.createServer((req, res) => {

    if(req.url === "/" && req.method === "GET") {
        res.statusCode = 200;
        res.setHeader("Content-Type","text/plain");
        return res.end("ciaoo, benvenuto!");
    } 
    if(req.url === "/" && req.method !== "GET") {
        res.statusCode = 405; //Method not allowd
        res.setHeader("Allow", "GET");
        return res.end();
    } 
    
    if(req.url === "/users" && req.method === "GET") {
        res.statusCode = 200;
        res.setHeader("Content-Type","text/plain");
        return res.end(JSON.stringify(user));
    } 
    if(req.url === "/users" && req.method !== "GET") {
        res.statusCode = 405; //Method not allowd
        res.setHeader("Allow", "GET");
        return res.end();
    } 

    if(req.url === "/number" && req.method === "GET") {
        res.statusCode = 200;
        res.setHeader("Content-Type","text/plain");
        const random = Math.floor(Math.random() * 100) + 1;
        return res.end(String(random));
    } 
    if(req.url === "/number" && req.method !== "GET") {
        res.statusCode = 405; //Method not allowd
        res.setHeader("Allow", "GET");
        return res.end();
    } 

    res.statusCode = 404;
    res.setHeader("Content-Type", "application/json");
    res.end(JSON.stringify({ error: req.url + " Not found"}))

})

server.listen(PORT, HOSTNAME, () => {
    console.log("ONLINE su http:/" + HOSTNAME + ":" + PORT)
})
