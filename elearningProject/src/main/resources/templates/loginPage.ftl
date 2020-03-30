<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/loginStyle.css?version=2" rel="stylesheet">

    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>

    <script src="js/getWorkerTask.js"></script>
    <script src="js/time.js"></script>
    <script src="js/collapse.js"></script>
    <script src="js/deleteTask.js"></script>
    <script src="js/setComplete.js"></script>
    <script src="js/logout.js"></script>
    <script src="js/getUsers.js"></script>
    <script src="js/workers.js"></script>
    <script src="js/getTasks.js"></script>
    <script src="js/sendTask.js"></script>
    <script src="js/newTask.js"></script>
    <script src="js/workerTask.js"></script>
    <script src="js/workerTaskHistory.js"></script>
    <script src="js/newWorker.js"></script>
    <script src="js/getPhoto.js"></script>
    <script src="js/downloadTask.js"></script>
    <script src="js/download.js"></script>
    <script src="js/getPic.js"></script>
</head>
<body onload="getPic()">

<script src="js/login.js"></script>


    <form class="login" id="loginForm">

        <input type="text" class="login-input" placeholder="Lietotājvārds" autofocus name="username" required autocomplete="off">
        <input type="password" class="login-input" placeholder="Parole" name="password" required autocomplete="off">


        <button type="button" class="login-button" onclick="login(username, password)">Aiziet!</button>

    </form>

<div id="bkg">


    <img src="" alt="" class="img">
    <p id="title"></p>

    <p id="descr"></p>
    <p id="copyright">&copy;</p>

</div>


</body>
</html>
