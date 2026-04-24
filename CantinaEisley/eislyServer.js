const express = require("express"); //import

const PORT = 3000;

//1) ccreare server
const server = express()

server.use(express.json())

const bevande = [
    {
        id : 1,
        gradazione : 10,
        nome : "keller",
        costo : 10 
    },
    {
        id : 2,
        gradazione : 5,
        nome : "ipa",
        costo : 12 
    },
    {
        id : 3,
        gradazione : 20,
        nome : "original",
        costo : 8
    },
    {
        id : 4,
        gradazione : 15,
        nome : "ottakringer",
        costo : 7
    },
    {
        id : 1,
        gradazione : 10,
        nome : "manchester bitter",
        costo : 15
    }
];

const cliente = [
    {
        id : 1,
        nome : "Han Solo",
        specie : "umano",
        credito : 1500
    },
    {
        id : 2,
        nome : "Greedo",
        specie : "rodiano",
        credito : 300
    },
    {
        id : 3,
        nome : "Chewbacca",
        specie : "wookiee",
        credito : 900
    },
    {
        id : 4,
        nome : "Hammerhead",
        specie : "ithoriano",
        credito : 200
    },
    {
        id : 1,
        nome : "Roda",
        specie : "rodiano",
        credito : 2000
    }
];

//MW globale che stampa info per ogni richiesta (REQ)
server.use( (req, res, next) => {
    console.log("[GL.MW] " + req.method + " - " + req.url);
    
    next()
})

server.use("/clienti", (req, res, next) => {
    //controlla se header custom esiste
    //prendo un header
    const tessera = req.headers["x-tessera"]

    if(!tessera) {
        //possibile 403...
        return res.status(400).json({err: " niente tessera, niente ingresso."})
    }

    next()
})

server.use("/clienti", (req, res, next) => {
    // leggere x-gettoni
    const gettoni = parseInt(req.headers["x-gettoni"])
    // se esiste associa il valore 
    if(gettoni) {
        req.gettoni = gettoni
    } else {
        req.gettoni = 0;
    }

    console.log(req.gettoni);
    
    next()
})

server.use("/clienti", (req, res, next) => {
    // leggere ruolo
    let ruolo = req.headers["x-ruolo"]
    // se esiste associa valore
    if (ruolo) {
        req.ruolo = ruolo
    } else {
        req.ruolo = "ospite"
    }

    next()
})

server.use("/bevande", (req, res, next) => {
    // leggere gradazione max
    let gradazione = parseInt(req.headers["x-gradazione-max"])
    // se esiste associa il valore
    if (gradazione) {
        req.gradazioneMax = gradazione
    } else {
        req.gradazioneMax = null
    }

    next()
})

server.get("/clienti", (req, res) => {
    res.status(200).json({msg: "test"})
})

server.get("/clienti/:id/ordini", (req, res) => {
    let id = parseInt(req.params.id)
    if (id) {

    } else {
        res.status(400).json({error: "Accesso non autorizzato"})
    }
})

server.get("/bevande", (req, res) => {
    let gradazioneMax = req.gradazioneMax;
    if (!gradazioneMax) {
        res.status(200).json(bevande);
    } else {
        let temp = [];
        for (let bevanda of bevande) {
            if (bevanda.gradazione <= gradazioneMax) temp.push(bevanda)
        }
        res.status(200).json(temp)
    }
})

//listen
server.listen(PORT, () => {
    console.log("ONLINE");
})
