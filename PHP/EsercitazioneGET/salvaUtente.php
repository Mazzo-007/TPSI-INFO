<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        :root{
            --bg-start: #74ebd5;
            --bg-end: #ACB6E5;
            --card-bg: #ffffff;
            --text-main: #253040;
            --accent: #4e8cff;
            --muted: #6b7a8a;
            --success: #2e8b57;
            --danger: #e03e3e;
            --radius: 14px;
        }

        /* Layout */
        html, body {
            height: 100%;
        }
        body {
            margin: 0;
            min-height: 100vh;
            display: flex;
            align-items: center;
            flex-direction: column;
            justify-content: center;
            padding: 2rem;
            font-family: "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
            background: linear-gradient(135deg, var(--bg-start) 0%, var(--bg-end) 100%);
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        /* Card */
        .container {
            background: linear-gradient(180deg, rgba(255,255,255,0.98), rgba(250,250,250,0.96));
            color: var(--text-main);
            padding: 2.25rem 2.5rem;
            border-radius: var(--radius);
            box-shadow: 0 10px 30px rgba(31,38,135,0.12);
            text-align: center;
            width: 100%;
            max-width: 480px;
            transition: transform 200ms ease, box-shadow 200ms ease;
            backdrop-filter: blur(6px);
            -webkit-backdrop-filter: blur(6px);
        }

        .container:hover {
            transform: translateY(-6px);
            box-shadow: 0 18px 45px rgba(31,38,135,0.16);
        }

        /* Headings */
        h1 {
            margin: 0 0 0.35rem 0;
            font-size: 1.9rem;
            line-height: 1.1;
            letter-spacing: 0.4px;
            color: var(--text-main);
            word-break: break-word;
        }

        h3 {
            margin: 0.25rem 0 1rem 0;
            font-size: 1rem;
            color: var(--accent);
            font-weight: 600;
        }

        h4 {
            margin: 0.25rem 0 1rem 0;
            font-size: 0.85rem;
            color: var(--text-main);
            font-weight: 600;
        }

        hr {
            width: 60%;
            border: 1px solid #b2bec3;
            margin-bottom: 30px;
        }

        /* Status helpers (apply to container class if desired: .container.success / .container.error) */
        .container.success h1 { color: var(--success); }
        .container.error h1 { color: var(--danger); }
        .container.success h3 { color: rgba(var(--success), .9); }
        .container.error h3 { color: rgba(var(--danger), .9); }

        /* Data block */
        .container + .container {
            margin-top: 1rem;
            padding-top: 1rem;
        }
        .container p {
            margin: 0.5rem 0 0;
            color: var(--muted);
            font-size: 0.95rem;
            line-height: 1.45;
            word-break: break-word;
        }
        .container p b { color: var(--text-main); }

        /* Key: value layout for user data */
        .data-row {
            text-align: left;
            margin: 0.6rem auto 0;
            padding: 0.6rem 0.75rem;
            border-radius: 10px;
            background: rgba(74, 123, 255, 0.04);
            color: var(--text-main);
            max-width: 360px;
        }
        .data-row div { margin: 0.25rem 0; font-size: 0.92rem; }

        /* Responsive */
        @media (max-width: 520px) {
            .container { padding: 1.1rem 1rem; border-radius: 12px; }
            h1 { font-size: 1.4rem; }
            h3 { font-size: 0.98rem; }
            .data-row { max-width: 100%; padding: 0.5rem; }
        }

        /* Print */
        @media print {
            body { background: #fff; }
            .container { box-shadow: none; transform: none; }
        }
    </style>
</head>
<body>
    <?php
        $errore = "";
        $nomeFile ="utente.json";
        if(!file_exists($nomeFile)){
        die("<div><h1>ERRORE DEL SISTEMA</h1></div>");
        }else{
            if(empty($_GET["nome"]) || empty($_GET["cognome"]) || empty($_GET["email"]) || empty($_GET["login"]) || empty($_GET["password"])){
                $errore = "<div><h1>Dati mancanti</h1></div>";
            } else {
            //leggere il file
            $json = file_get_contents($nomeFile);

            //trasformare in array associativo
            $dati = json_decode($json, true);

            foreach($dati as $utente){
                if($utente["login"] === $_GET["login"]){
                    $errore = "<div><h1>Utente già esistente</h1></div>";
                }
            }

            if($errore === ""){
            $utente = [
                "nome"=>$_GET["nome"],
                "cognome"=>$_GET["cognome"],
                "email"=>$_GET["email"],
                "login"=>$_GET["login"],
                "password"=>$_GET["password"]
            ];

            //aggiungere l'utente
            $dati[] = $utente;

            //trasformo l'array associativi in string json
            $json = json_encode($dati, JSON_PRETTY_PRINT);

            //salvo la stringa sul file
            file_put_contents($nomeFile,$json);
    ?>    
        <h1>Utente salvato con successo</h1>
        
        <hr>

        <div class="container">
        <h1> Dati </h1>

        <?php
            echo("<h4>" . (isset($utente) ? $utente['nome'] : '') . " i tuoi dati sono i seguenti: </h4>");
            echo "<p>";
            foreach ($utente as $k => $v) {
                echo "$k: $v<br>";
            }
            ?>

            </p>
            </div>
        <?php
            }
            }
    }
    if($errore !== ""){
        echo "<h1>$errore</h1>";
    }
    ?>
    <div class="container">
        <label><a href="index.html">Clicca qui</a> per effettuare il login.</label>
    </div>
</body>
</html>