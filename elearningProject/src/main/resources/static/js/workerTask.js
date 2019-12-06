function workerTask() {



    let token = document.getElementById("tkn2").innerText;




    let list = document.getElementById("tasks");

    let child = list.lastElementChild;
    while (child) {
        list.removeChild(child);
        child = list.lastElementChild;
    }


    let i;
    let data;
    let request = new XMLHttpRequest();
    request.open('GET', 'http://macibas.linkpc.net/workerTask', true);
    request.setRequestHeader("Authorization", token);

    request.send();


    request.onload = function () {
        try {
            // Begin accessing JSON data here
            data = JSON.parse(this.response);
        } catch (err) {

        }


        if (request.status >= 200 && request.status < 400) {
            data.reverse();
            for (i = 0; i < data.length; i++) {

                let div = document.createElement("div");
                div.setAttribute("class", "content");

                let button = document.createElement("button");

                let completeButton = document.createElement("button");
                let linkButton = document.createElement("button");
                linkButton.setAttribute("name", data[i].taskId);
                linkButton.appendChild(document.createTextNode("Ieladet!"));
                linkButton.setAttribute("onclick", "downloadTask(name)");

                completeButton.setAttribute("name", data[i].workerTaskId);
                completeButton.appendChild(document.createTextNode("Izpildit!"));
                completeButton.setAttribute("onclick", "setComplete(name)");
                button.setAttribute("class", "collapsible");
                div.appendChild(document.createElement("br"));

                button.appendChild(document.createTextNode(data[i].taskName));

                div.appendChild(document.createTextNode(data[i].taskSubject));
                div.appendChild(document.createElement("br"));

                div.appendChild(document.createElement("br"));

                div.appendChild(document.createElement("br"));
                let currentDateTime = new Date(data[i].creationDate);
                let formattedDate = currentDateTime.getDate() + "-" + (currentDateTime.getMonth() + 1) + "-" + currentDateTime.getFullYear();
                div.appendChild(document.createTextNode("Izveidots: " + formattedDate));
                div.appendChild(document.createElement("br"));
                if (data[i].complete != true) {

                div.appendChild(completeButton);
                    div.appendChild(linkButton);
            }else{
                    div.appendChild(document.createTextNode("Izpildits: " + new Date(data[i].completionDate)));
                }
                document.getElementById("tasks").appendChild(button);


                document.getElementById("tasks").appendChild(div);


            }
            let coll = document.getElementsByClassName("collapsible");
            let j;
            for (j = 0; j < coll.length; j++) {
                coll[j].addEventListener("click", function() {
                    this.classList.toggle("active");
                    let content = this.nextElementSibling;
                    if (content.style.display === "block") {
                        content.style.display = "none";
                    } else {
                        content.style.display = "block";
                    }
                });
            }
        }
    }

}

