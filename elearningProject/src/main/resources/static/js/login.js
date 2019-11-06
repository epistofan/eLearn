function login(username, password){


let loginRequest = new XMLHttpRequest();
    loginRequest.open('POST', 'http://macibas.linkpc.net/login',true);
    loginRequest.setRequestHeader("Content-Type", "application/json");
    loginRequest.setRequestHeader('Authorization', username.value);

    loginRequest.setRequestHeader('Authorization', password.value);

    //loginRequest.responseType = "document";
    loginRequest.send();

        loginRequest.onload = function () {
            if (loginRequest.status >= 200 && loginRequest.status < 400) {
            try {

                let tkn = loginRequest.getResponseHeader("Authorization");


                document.getElementsByTagName('html')[0].innerHTML = "";
                document.getElementsByTagName("html")[0].innerHTML = loginRequest.response;
                document.getElementById("tkn2").innerText = tkn;



                startTime();

                getPhoto();


               workers();

                workerTaskHistory();
                workerTask();
                getTasks();

            } catch (err) {
            }

            }else{

                console.log("not found");
            }
        };



}