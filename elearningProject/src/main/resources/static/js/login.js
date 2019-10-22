function login(username, password){


let loginRequest = new XMLHttpRequest();
    loginRequest.open('POST', 'http://10.10.10.100:8888/login',true);
    loginRequest.setRequestHeader("Content-Type", "application/json");
    loginRequest.setRequestHeader('Authorization', username.value);

    loginRequest.setRequestHeader('Authorization', password.value);

    //loginRequest.responseType = "document";
    loginRequest.send();

        loginRequest.onload = function () {
            if (loginRequest.status >= 200 && loginRequest.status < 400) {
            try {

                let tkn = loginRequest.getResponseHeader("Authorization");
                let photo = loginRequest.getResponseHeader("photo");
                //document.body.appendChild(loginRequest.responseXML);

                document.getElementsByTagName('html')[0].innerHTML = "";
                document.getElementsByTagName("html")[0].innerHTML = loginRequest.response;
                document.getElementById("tkn2").innerText = tkn;



                startTime();
                document.getElementById("avatar").src = photo;

               uncompletedWorkerTask();

                //getWorkerTask();
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