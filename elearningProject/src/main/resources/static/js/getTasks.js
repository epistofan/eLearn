function getTasks() {

    let token = document.getElementById("tkn2").innerText;

    $("#tasks2").empty();


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
                div.setAttribute("id", "task");
                div.setAttribute("class", "content");

let button = $("<div>").attr("class", "collapsible3").text(data[i].taskName).click(function () {



   let elem =  $(this).find("#task");

    if(elem.is(":visible")){

        elem.hide();
    }else {

        elem.show();
    }

});

            let setTaskButton = document.createElement("button");
            setTaskButton.appendChild(document.createTextNode("Nosutit"));

                let eraseTaskButton = document.createElement("button");
                eraseTaskButton.appendChild(document.createTextNode("Dzēst"));

            //button.appendChild(document.createTextNode(data[i].taskName));
            setTaskButton.setAttribute("onclick", "sendTask(name)");
            setTaskButton.setAttribute("id", "setTaskButton");
            setTaskButton.setAttribute("name", data[i].taskId);

                eraseTaskButton.setAttribute("onclick", "deleteTask(name)");
                eraseTaskButton.setAttribute("id", "deleteTaskButton");
                eraseTaskButton.setAttribute("name", data[i].taskId);

            div.appendChild(document.createTextNode(data[i].taskSubject));


                div.appendChild(document.createElement("br"));
                let linkButton = document.createElement("button");
                linkButton.setAttribute("name", data[i].taskId);
                linkButton.appendChild(document.createTextNode("Ieladet!"));
                linkButton.setAttribute("onclick", "downloadTask(name)");

                div.appendChild(setTaskButton);
                div.appendChild(eraseTaskButton);
                div.appendChild(linkButton);


                button.append(div);
$("#tasks2").append(button).append("<br>");




            }


        }else {
            return "no access";
        }
    }

}

