<?php
    $lista = array(1,2,3,4,5,6,7,8,9,"paolo");

    
    $nome = "Luca";
    $message = "<h1 style = 'color :red'>Hello $nome!</h1>";
    
    echo ($message);
    
    foreach($lista as $k => $item){
        echo ("<p>$k : $item</p>");
    }
?>