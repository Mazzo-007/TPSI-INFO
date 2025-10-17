<?php
    $nomeFile = "utente.json";
    //1. verifico se il file esiste
    if (!file_exists($nomeFile)) {
        die ("File non esistente");
    } else {
        $contenuto = file_get_contents($nomeFile);
        //var_dump --> stampa il tipo di variabile e il suo contenuto
        //var_dump($contenuto);
        $dati = json_decode($contenuto, true); //con true converto in array associativo
        var_dump($dati);

        //Recupero i singoli utenti
        foreach ($dati as $utente) {
            echo "<p>";
            foreach ($utente as $k => $v) {
                echo "$k: $v<br>";
            }
            echo "</p>";
        }
    }
?>    