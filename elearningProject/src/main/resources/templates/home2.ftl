<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet">
    <style>


    </style>
</head>
<body>

<div class="header">


    <span class="c"><button class="button" onclick="getTasks(); workers()">Atjaunot</button></span>

    <span class="a" id="date"></span>

    <span class="a" id="time"></span>


    <span class="b" id="btn"><button class = "button" onclick="logout()">Iziet</button> </span>
</div>

<div class="row">

    <div class="col-3">
        <div class="aside">
            <img id="avatar" src=""  >
            <p>${user.firstName} ${user.lastName}</p>

        </div>
    </div>



    <div class="col-6">


        <button onclick="collapse()">Izveidot uzdevumu!</button>
        <div id="coll" class="myContent">
            <br>
            Uzdevuma nosaukums:
            <br>
            <input type="text" id="taskName">
            <br>

            Uzdevuma apraksts:
            <br>
            <textarea id="descr" rows="10"></textarea>
            <br>
            Fails:<input type="file" id="file">
            <br>
            <br>
            <button onclick="newTask()">Izveidot!</button>

        </div>
        <p>Uzdevumi:</p>

        <br>
        <div id="tasks2" class="aside">



        </div>
        <p>Mani uzdevumi:</p>
        <div id="tasks" class="aside">



        </div>


    </div>


    <div class="col-3">
        <div class="aside">
            <div class="column" id="users">
                <p> Lietotāji(darbinieki):</p>

            </div>



        </div>
    </div>
</div>

<div class="row">

    <div class="col-3">
        <div class="aside">
            <h1>Izveidot darbinieku</h1>
            <button onclick="collapse2()">Izveidot darbinieku!</button>
            <div id="addWorker" class="myContent2">
                <br>
                Vārds:
                <br>
                <input type="text" id="firstName">
                <br>
                Uzvārds:
                <br>
                <input type="text" id="lastName">
                <br>
                Lietotājvārds:
                <br>
                <input type="text" id="username">
                <br>
                Parole:

                <br>
                <input type="password" id="password">
                <br>
                Bilde:<input type="file" id="photo">
                <br>
                <br>
                <button onclick="newWorker()">Izveidot!</button>

            </div>
        </div>
    </div>



    <div class="col-6">



        <p>Uzdevumu vēsture:</p>
        <div id="history" class="aside">



        </div>


    </div>


    <div class="col-3">
        <div class="aside">
            <div class="column" id="users">
                <p> Info:</p>

            </div>



        </div>
    </div>
</div>


<p hidden id="tkn2"></p>

<div class="footer">
    2019


</div>

</body>
</html>