function sendTask(name){

console.log(name);




let sendTaskRequest = new XMLHttpRequest();
    sendTaskRequest.open('POST', 'http://macibas.linkpc.net/sendTask',true);
    sendTaskRequest.setRequestHeader("Content-Type", "application/json");





    sendTaskRequest.send(name);

sendTaskRequest.onload = function() {
    workerTask();
}

}