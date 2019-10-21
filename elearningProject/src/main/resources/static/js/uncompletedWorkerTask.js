function uncompletedWorkerTask() {
    let data;
let count;
    let i;
    let token = document.getElementById("tkn2").innerText;

    let request = new XMLHttpRequest();
    request.open('GET', 'http://10.10.10.100:8888/uncompletedWorkerTask', true);
    request.setRequestHeader("Authorization", token);
    request.setRequestHeader("user", name);
    request.send();


    request.onload = function () {
        try {
            // Begin accessing JSON data here
            data = JSON.parse(this.response);
        } catch (err) {

        }


        if (request.status >= 200 && request.status < 400) {

                     let users = document.getElementById("users");

                     let mapLength = request.getResponseHeader("mapLength");


            for (i = 1; i <parseInt(mapLength)+1; i++) {

               // let div = document.createElement("div");

                //div.setAttribute("class", "content2");
                try {
                let div = $("<div></div>").attr("class", "content2");
                let button = $("<button></button>").attr({class: "collapsible2", id:"data[i][0].workerId", onclick:"getWorkerTask(id)"}).text(data[i][0].workerId +" "+data[i][0].firstName+ " "+data[i][0].lastName);

                //let button = document.createElement("button");





    /*button.setAttribute("class", "collapsible2");
    button.setAttribute("id", data[i][0].workerId);
    button.setAttribute("onclick", "getWorkerTask(id)");
    button.appendChild(document.createTextNode(data[i][0].workerId +" "+data[i][0].firstName+ " "+data[i][0].lastName));
*/


    data[i].forEach(function (item) {


$(".content2").text(item.taskId + " " +item.taskName);
       //div.appendChild(document.createTextNode(item.taskId + " " +item.taskName)) ;
        //div.appendChild(document.createElement("br"));
    });




$("#users").append(button);
                $("#users").append(div);
                //document.getElementById("users").appendChild(button);
                //document.getElementById("users").appendChild(div);

            }catch (error) {
                console.log("error");
            }


            }
            let coll = document.getElementsByClassName("collapsible2");
            let j;
            for (j = 0; j < coll.length; j++) {
                coll[j].addEventListener("click", function () {
                    this.classList.toggle("active");
                    let content = this.nextElementSibling;
                    if (content.style.display === "block") {
                        content.style.display = "none";
                    } else {
                        content.style.display = "block";
                    }
                });
            }
        }else {

            return "no access";
        }
    }






}

