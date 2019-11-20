<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/style.css" rel="stylesheet">
    <style>


    </style>
</head>
<body>



<div class="sidenav">


    <div class="dateTime" id="date"></div>

    <div class="dateTime" id="time"></div>


    <div>
        <img id="avatar" src=""  >
    </div>
    <p>${user.firstName} ${user.lastName}</p>
    <button class = "button" onclick="logout()">Iziet</button>
</div>



<div class="row">





    <div class="col-9">


        <p>Mani uzdevumi:</p>
        <div id="tasks" class="aside">



        </div>


    </div>


    <div class="col-3">
        <div class="aside">




        </div>
    </div>
</div>

<div class="row">





    <div class="col-9">



        <p>Uzdevumu vesture:</p>
        <div id="history" class="aside">



        </div>


    </div>


    <div class="col-3">
        <div class="aside">




        </div>
    </div>
</div>


<p hidden id="tkn2"></p>



</body>

</html>