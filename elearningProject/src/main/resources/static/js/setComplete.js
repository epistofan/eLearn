function setComplete(id) {

    let token = document.getElementById("tkn2").innerText;

    let request = new XMLHttpRequest();
    request.open('POST', 'http://macibas.linkpc.net/setComplete', true);
    request.setRequestHeader("Content-Type", "application/json");
    request.setRequestHeader("Authorization", token);
    request.send(id);


    request.onload = function () {

        alert("izpildits!");
        workerTask();
        workerTaskHistory();

    }

}

