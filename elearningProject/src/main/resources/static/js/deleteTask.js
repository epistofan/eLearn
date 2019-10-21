function deleteTask(name){


    console.log(name);




    let request = new XMLHttpRequest();
    request.open('PUT', 'http://10.10.10.100:8888/tasks',true);
    request.setRequestHeader("Content-Type", "application/json");





    request.send(name);


    getTasks();
}