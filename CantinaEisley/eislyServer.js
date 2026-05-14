const express = require("express"); //import

const PORT = 3000;

//1) creare server
const server = express()

server.use(express.json())

let clienti = [
    { id: 1, nome: 'Han Solo', specie: 'umano', credito: 1500 },
    { id: 2, nome: 'Greedo', specie: 'rodiano', credito: 300 },
    { id: 3, nome: 'Chewbacca', specie: 'wookiee', credito: 900 },
    { id: 4, nome: 'Hammerhead', specie: 'ithoriano', credito: 200 }
];

let bevande = [
    { id: 1, nome: 'Corellian Ale', prezzo: 50, gradazione: 8 },
    { id: 2, nome: 'Juri Juice', prezzo: 80, gradazione: 15 },
    { id: 3, nome: 'Spotchka', prezzo: 120, gradazione: 20 },
    { id: 4, nome: 'Merenzane Gold', prezzo: 200, gradazione: 5 }
];

let ordini = [
    { id: 1, cliente: 'Han Solo', bevanda: 'Corellian Ale', quantita: 2, costo_totale: 100 },
    { id: 2, cliente: 'Han Solo', bevanda: 'Spotchka', quantita: 1, costo_totale: 120 },
    { id: 3, cliente: 'Greedo', bevanda: 'Juri Juice', quantita: 1, costo_totale: 80 },
    { id: 4, cliente: 'Chewbacca', bevanda: 'Corellian Ale', quantita: 3, costo_totale: 150 }
];

let taglie = [
    { id: 1, clienteId: 1, motivazione: 'Debiti non saldati con Jabba the Hutt', ricompensa: 5000, attiva: true },
    { id: 2, clienteId: 1, motivazione: 'Contrabbando di spezie kessel', ricompensa: 3000, attiva: false },
    { id: 3, clienteId: 2, motivazione: 'Informatore ribelle segnalato', ricompensa: 1000, attiva: false },
    { id: 4, clienteId: 3, motivazione: 'Evasione dalla colonia di lavoro imperiale', ricompensa: 2500, attiva: true }
];

let missioni = [
    {
        id: 1,
        codice: 'AURORA-1',
        descrizione: 'Recupero piani della Morte Nera',
        pianeta: 'Scarif',
        rischio: 'alto',
        clearance: 3,
        agente: 'Cassian Andor'
    },
    {
        id: 2,
        codice: 'NEBULA-4',
        descrizione: 'Sorveglianza porto di Mos Eisley',
        pianeta: 'Tatooine',
        rischio: 'basso',
        clearance: 1,
        agente: 'Fulcrum'
    },
    {
        id: 3,
        codice: 'ECLIPSE-7',
        descrizione: 'Sabotaggio generatori imperiali',
        pianeta: 'Lothal',
        rischio: 'alto',
        clearance: 2,
        agente: 'Hera Syndulla'
    },
    {
        id: 4,
        codice: 'PHANTOM-2',
        descrizione: 'Estrazione agente sotto copertura',
        pianeta: 'Coruscant',
        rischio: 'critico',
        clearance: 3,
        agente: 'Sconosciuto'
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

server.use("/missioni", (req, res, next) => {
    if (req.method !== "GET") return res.status(405).json({error : "Metodo non consentito. Le missioni non si toccano."})
    next();
})

server.use("/missioni", (req, res, next) => {
    let clearance = parseInt(req.headers["x-clearance"]);
    if (clearance) req.clearance = clearance;
    else req.clearance = 0;
    next();
})

server.use("/missioni", (req, res, next) => {
    let temp = [];
    for (let missione of missioni) {
        if (missione.clearance <= req.clearance) temp.push(missione);
    }
    req.missioniVisibili = temp;
    next();
})

server.get("/clienti", (req, res) => {
    res.status(200).json(clienti)
})

server.get("/clienti/:id", (req, res) => {
    let idCliente = parseInt(req.params.id);
    //TODO check se id è davvero un numero intero
    //TODO ricerca se ho davvero quel cliente
    for (let cliente of clienti) {
        if (cliente.id === idCliente) {
            return res.status(200).json(cliente);
        }
    }
    return res.status(404).json({"msg":"Cliente non trovato"})
})

server.get("/clienti/:id/ordini", (req, res) => {
    let id = parseInt(req.params.id);
    let checkCliente = true;
    let nomeCliente;
    let temp = [], temp2 = [];
    if (id) {
            for (let cliente of clienti) {
                if (cliente.id === id) {
                    checkCliente = false;
                    nomeCliente = cliente.nome;
                }    
            }
            if (checkCliente) {
                res.status(404).json({error: "Cliente non trovato"})
            } else {
                for (let ordine of ordini) {
                    if (ordine.cliente === nomeCliente) temp.push(ordine);
                }
                if (req.ruolo === "admin") res.status(200).json(temp);
                else {
                    for (let ordine of temp) {
                        const {costo_totale, ...resto} = ordine;
                        temp2.push(resto);
                    }
                    res.status(200).json(temp2);
                }
            }
    } else {
        res.status(400).json({error: "Accesso non autorizzato"})
    }
})

server.get("/clienti/:id/riepilogo", (req, res) => {
    let idCliente = parseInt(req.params.id);
    let checkCliente = true;
    let tempCliente;
    let tempObj;
    let tempOrdini = [];
    let summCostoTotale = 0;
    let contatore = {};
    let bevandaPreferita = null;
    let maxQuantita = 0;
    let taglieAttive = 0;
    if (idCliente) {
        for (let cliente of clienti) {
            if (cliente.id === idCliente) {
                checkCliente = false;
                tempCliente = cliente;
            }
        }
        if (checkCliente) res.status(404).json({error : "Cliente non trovato"});
        else {
            for (let ordine of ordini) {
                if (ordine.cliente === tempCliente.nome) tempOrdini.push(ordine);
            }

            for (let ordine of tempOrdini) {
                summCostoTotale += ordine.costo_totale;
            }

            for (let ordine of tempOrdini) {
                if (contatore[ordine.bevanda]) contatore[ordine.bevanda] += ordine.quantita;
                else contatore[ordine.bevanda] = ordine.quantita;
            }

            for (const nomeBevanda in contatore) {
                if (contatore[nomeBevanda] > maxQuantita) {
                    maxQuantita = contatore[nomeBevanda];
                    bevandaPreferita = nomeBevanda;
                }
            }

            for (let taglia of taglie) {
                if (taglia.clienteId === idCliente) {
                    if (taglia.attiva) taglieAttive++;
                }
            }

            tempObj = 
            {
                cliente : tempCliente.nome,
                credito_attuale : tempCliente.credito,
                numero_ordini : tempOrdini.length,
                totale_speso : summCostoTotale,
                bevanda_preferita : bevandaPreferita,
                taglie_attive : taglieAttive
            };

            res.status(200).json(tempObj);
        }
    } else {
        res.status(400).json({error : "Accesso non autorizzato"})
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

server.get("/missioni", (req, res) => {
    let clearance = req.clearance;
    let temp = [];
    if (clearance === 0) {
        res.status(403).json({messaggio : "Clearance inssuficente. Non sai niente."})
    } else if (clearance === 1 || clearance === 2) {
        for (let missione of req.missioniVisibili) {
            temp.push({ ...missione, agente: "[CLASSIFICATO]"});
        }
        res.status(200).json(temp);
    } else {
        res.status(200).json(req.missioniVisibili);
    }
})

server.get("/missioni/:id", (req, res) => {
    let clearance = req.clearance;
    let idMissione = parseInt(req.params.id);
    let searchMissione = null;

    if(idMissione) {
        if (clearance === 0) {
            return res.status(403).json({messaggio : "Clearance inssuficente. Non sai niente."})
        }
        for (let missione of req.missioniVisibili) {
            if (missione.id === idMissione) {
                searchMissione = missione;
            }
        }
        if (searchMissione) {
            if (clearance <= 2) {
                res.status(200).json({...searchMissione, agente : "[CLASSIFICATO]"});
            } else {
                res.status(200).json(searchMissione);
            }
        } else {
            for (let missione of missioni) {
                if (missione.id === idMissione) {
                    searchMissione = missione;
                }
            }
            if (searchMissione) res.status(403).json({messaggio : "Clearance insufficente per questa missione."})
            else res.status(404).json({errore : "Missione non trovata."})
        }
    } else {
        res.status(400).json({error : "Accesso non autorizzato"})
    }
})

server.post("/clienti", (req, res) => {
    let name = req.body.nome;

    if(!name) return res.status(400).json({"msg":"errore client"});
    clienti.push({
      id: clienti.length + 1,
      nome: req.body.nome,
      specie: req.body.specie,
      credito: req.body.credito
    })
    res.status(201).json({ msg: "Cliente aggiunto", cliente: clienti[clienti.length - 1] });
})

server.post("/ordini", (req, res) => {
    let clienteId = req.body.clienteId;
    let bevandaId = req.body.bevandaId;
    let quantitaOrd = req.body.quantita;

    let cliente = null;
    let bevanda = null;

    let costoBase, costoTotale;

    let taglieRiscosse = 0;

    if (!clienteId || !bevandaId || !quantitaOrd) return res.status(400).json({error : "Campi obbligatori mancanti."});

    for (let c of clienti) {
        if (c.id === clienteId) cliente = c;
    }

    if (!cliente) return res.status(404).json({ error: "Cliente non trovato" });

    for (let b of bevande) {
        if (b.id === bevandaId) bevanda = b;
    }

    if (!bevanda) return res.status(404).json({ error: "Bevanda non trovata" });

    costoBase = bevanda.prezzo * quantitaOrd;

    if (bevanda.gradazione > 10) costoTotale = costoBase * 1.15;
    else costoTotale = costoBase;

    if (cliente.credito >= costoTotale) cliente.credito -= costoTotale;
    else return res.status(400).json({error : "Credito insufficente."})

    ordini.push({
        id: ordini.length+1, 
        cliente: cliente.nome, 
        bevanda: bevanda.nome, 
        quantita: quantitaOrd, 
        costo_totale: costoTotale
    })

    for (let taglia of taglie) {
        if (taglia.clienteId === clienteId && taglia.attiva === true) {
            taglia.attiva = false;
            taglieRiscosse ++;
        }
    }

    res.status(201).json({ msg: "Ordine creato", ordine: ordini[ordini.length - 1], taglie_riscosse: taglieRiscosse });
})

//listen
server.listen(PORT, () => {
    console.log("ONLINE");
})
