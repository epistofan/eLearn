function getTasks() {

    let token = document.getElementById("tkn2").innerText;

    let list = document.getElementById("tasks2");

    let child = list.lastElementChild;
    while (child) {
        list.removeChild(child);
        child = list.lastElementChild;
    }


    let i;
    let data;
    let request = new XMLHttpRequest();
    request.open('GET', 'http://macibas.linkpc.net/getTasks', true);
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
            button.setAttribute("class", "collapsible3");



            let setTaskButton = document.createElement("button");
            setTaskButton.appendChild(document.createTextNode("Nosutit"));

                let eraseTaskButton = document.createElement("button");
                eraseTaskButton.appendChild(document.createTextNode("Dzēst"));

            button.appendChild(document.createTextNode(data[i].taskName));
            setTaskButton.setAttribute("onclick", "sendTask(name)");
            setTaskButton.setAttribute("id", "setTaskButton");
            setTaskButton.setAttribute("name", data[i].taskId);

                eraseTaskButton.setAttribute("onclick", "deleteTask(name)");
                eraseTaskButton.setAttribute("id", "deleteTaskButton");
                eraseTaskButton.setAttribute("name", data[i].taskId);

            div.appendChild(document.createTextNode(data[i].taskSubject));
                div.appendChild(document.createElement("br"));


                let link = document.createElement("a");
                link.appendChild(document.createTextNode("link"));
                link.download = "uzdevums";
                link.href = data[i].link ;
                div.appendChild(document.createElement("br"));
                div.appendChild(link);
                div.appendChild(document.createElement("br"));
                div.appendChild(setTaskButton);
                div.appendChild(eraseTaskButton);


                document.getElementById("tasks2").appendChild(button);


                document.getElementById("tasks2").appendChild(div);


            }

            let coll = document.getElementsByClassName("collapsible3");
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
        }else {
            return "no access";
        }
    }

}

