<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
        body {
            background: linear-gradient(135deg, #74ebd5 0%, #ACB6E5 100%);
            font-family: 'Segoe UI', Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .container {
            background: #fff;
            padding: 2.5rem 3.5rem;
            border-radius: 18px;
            box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.18);
            text-align: center;
            min-width: 350px;
            transition: box-shadow 0.3s;
        }
        .container:hover {
            box-shadow: 0 12px 40px 0 rgba(31, 38, 135, 0.22);
        }
        h1 {
            color: #2d3a4b;
            margin-bottom: 0.5rem;
            font-size: 2.2rem;
            letter-spacing: 1px;
        }
        h3 {
            color: #4e8cff;
            margin-top: 0.5rem;
            font-weight: 500;
        }
        @media (max-width: 500px) {
            .container {
                padding: 1.2rem 0.5rem;
                min-width: unset;
            }
            h1 {
                font-size: 1.3rem;
            }
            h3 {
                font-size: 1rem;
            }
        }
    </style>
</head>
<body>
    <div class="container">
    <?php 
        $_USER = array(
            'admin' => 'admin',
            'Luca' => 'Mazzoni',
            'Niccolò' => 'Veronesi'
        );

        if ($_USER[$_GET['username']] === $_GET['password']) {
            echo "<h1>Benvenuto " . $_GET['username'] . "</h1>";
            echo "<h3>Accesso effettuato con successo</h3>";
        } else {
            echo "<h1>Accesso negato</h1>";
            echo "<h3>Username o password errati</h3>";
        }
    ?>
</body>
</html>