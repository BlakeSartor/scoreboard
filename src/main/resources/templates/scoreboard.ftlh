<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
</head>
<body>



<div class="container" style="border:1px solid black;">

    <div class = "row">
        <div class = "col-lg-2"> <h1>${player1.score}</h1>
            <button onclick="location.href='/addPlayer1'">+</button>
        </div>
        <div class = "col-lg-8" style=" text-align: center;"><h1>Scoreboard</h1> </div>
        <div class = "col-lg-2"> <h1>${player2.score}</h1>
            <button onclick="location.href='/addPlayer2'">+</button>
        </div>
    </div>


</div>

<div>
    <button onclick="location.href='/reset'">Reset Game</button>

</div>