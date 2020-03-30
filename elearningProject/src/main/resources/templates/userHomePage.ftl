<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css?version=2" rel="stylesheet">
    <style>


    </style>
</head>
<body>

<div class="row">

    <div class="column1">


        <div class="dateTime" id="date"></div>

        <div class="dateTime" id="time"></div>


        <div>
            <img id="avatar" src=""  >
        </div>
        <p>${user.firstName} ${user.lastName}</p>
        <button class = "button" onclick="logout()">Iziet</button>
    </div>




    <div class="column">


        <p>Mani uzdevumi:</p>
        <div id="tasks" class="aside">



        </div>


    </div>


    <div class="column3">
        <div class="aside">




        </div>


        <p>Uzdevumu vesture:</p>
        <div id="history" class="aside">



        </div>



    </div>
</div>

<p hidden id="tkn2"></p>



</body>

</html>