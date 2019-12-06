function deleteTask(name) {


    console.log(name);


    let request = new XMLHttpRequest();
    request.open('PUT', 'http://macibas.linkpc.net/task', true);
    request.setRequestHeader("Content-Type", "application/json");


    request.send(name);
    request.onload = function () {


    getTasks();
    workerTask();
}
}