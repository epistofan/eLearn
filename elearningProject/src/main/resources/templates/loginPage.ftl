<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/loginStyle.css" rel="stylesheet">

    <script src="https://ajax.aspnetcdn.com/ajax/jQuery/jquery-3.4.1.min.js"></script>

    <script src="js/getWorkerTask.js"></script>
    <script src="js/time.js"></script>
    <script src="js/collapse.js"></script>
    <script src="js/deleteTask.js"></script>
    <script src="js/setComplete.js"></script>
    <script src="js/logout.js"></script>
    <script src="js/getUsers.js"></script>
    <script src="js/uncompletedWorkerTask.js"></script>
    <script src="js/getTasks.js"></script>
    <script src="js/sendTask.js"></script>
    <script src="js/newTask.js"></script>
    <script src="js/workerTask.js"></script>
    <script src="js/workerTaskHistory.js"></script>
</head>
<body>

<script src="js/login.js"></script>


    <form class="login" id="loginForm">
        <h1 class="login-title">Sveiki!</h1>
        <input type="text" class="login-input" placeholder="Lietotājvārds" autofocus name="username" required>
        <input type="password" class="login-input" placeholder="Parole" name="password" required>


        <button type="button" class="login-button" onclick="login(username, password)">Aiziet!</button>

        <p class="login-lost"><a href="">sazināties</a></p>
    </form>


</body>
</html>
