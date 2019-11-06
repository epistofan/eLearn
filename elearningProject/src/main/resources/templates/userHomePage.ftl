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
            <p>${user.firstName}</p>
            <p>${user.lastName}</p>
        </div>
    </div>



    <div class="col-6">




        <p>Mani uzdevumi:</p>
        <div id="tasks" class="aside">



        </div>


    </div>


    <div class="col-3">
        <div class="aside">
            <div class="column" id="users">
                <p> dfvdfvdfvdf:</p>

            </div>



        </div>
    </div>
</div>

<div class="row">

    <div class="col-3">
        <div class="aside">
            <h1>dfvdfvdfv</h1>

        </div>
    </div>



    <div class="col-6">



        <p>Uzdevumu vēsture:</p>
        <div id="tasks" class="aside">



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
    @2019


</div>

</body>
</html>