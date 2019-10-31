<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>eLearning App</title>



    <link href="css/style.css" rel="stylesheet">



</head>

<body>


<div class="header">
    <span class="a" id="date"></span>

    <span class="a" id="time"></span>
    <span class="b" id="btn"><button class = "button" onclick="logout()">Iziet</button> </span>
    <span class="c"><button class="button" onclick="getTasks(); uncompletedWorkerTask()">Atjaunot</button></span>
</div>
<div class="sidenav">
    <div class="row">
        <div class="columnLeft" id="leftColumn">

            <img id="avatar" src="" width="130" height="130"  >
            <p>${user.firstName}</p>
            <p>${user.lastName}</p>
        </div>


        <div class="column1">


            <button onclick="collapse()">Izveidot uzdevumu!</button>


            <div id="coll" class="myContent">
                <br>
                Uzdevuma nosaukums:
                <br>
                <input type="text" id="taskName">
                <br>
                Uzdevuma apraksts:<textarea rows="10" cols="50" id="descr"></textarea>
                <br>
                Fails:<input type="file" id="file">
                <br>
                <br>
                <button onclick="newTask()">Izveidot!</button>

            </div>
            <p>Uzdevumi:</p>

            <br>
            <div id="tasks2">



            </div>
            <p>Mani uzdevumi:</p>
            <div id="tasks">



            </div>


        </div>

        <div class="column" id="users">
        <p> Lietotāju tekošie uzdevumi:</p>

        </div>



    </div>
    <p hidden id="tkn2"></p>
</div>


</body>

</html>