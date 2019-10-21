function sendTask(name){

console.log(name);




let sendTaskRequest = new XMLHttpRequest();
    sendTaskRequest.open('POST', 'http://10.10.10.100:8888/sendTask',true);
    sendTaskRequest.setRequestHeader("Content-Type", "application/json");





    sendTaskRequest.send(name);





}