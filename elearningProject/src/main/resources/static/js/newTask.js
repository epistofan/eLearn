function newTask(){


   let taskName =  document.getElementById("taskName");
   let descr = document.getElementById("descr");
    let file = document.getElementById("file");

const obj = file.files[0];

console.log("upload");
    console.log(taskName.value);
    let formData = new FormData();

const request = new XMLHttpRequest();
    request.open('POST', 'http://10.10.10.100:8888/newTask',true);

    formData.append("obj", obj);
    formData.append("name", descr.value);
    formData.append("taskName", taskName.value);

    request.send(formData);

    console.log("upload 2");
    request.onload = function () {

    if (request.status >= 200 && request.status < 400) {

        alert("Uzdevums ir izveidots");
    }


        document.getElementById("taskName").value = "";
        document.getElementById("descr").value = "";
        document.getElementById("file").value = "";

        document.getElementById("coll").style.display ="none";


        getTasks();
};
}