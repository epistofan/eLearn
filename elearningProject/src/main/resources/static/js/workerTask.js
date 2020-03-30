async function workerTask() {

    $("#tasks").empty();
    let response = await fetch("http://macibas.linkpc.net/workerTask", {headers: {"Authorization": $("#tkn2").text() }});

    let data = await response.json();

    let list = $("<ul>");


    $.each(data, function (index, value) {


        let button = $("<li>")
            .attr({class: "collapsible2", id:value.workerTaskId})
            .text(value.taskName)
            .append("<div class='content2'>")
            .click(async function () {

                let elem =  $(this).find(".content2");


                if(elem.is(":visible")){

                    elem.hide();
                }else {

                let button = $("<button>").text("Izpildīt!").attr("onclick", "setComplete(name)");
                let button2 = $("<button>").text("Ieladet!").attr("onclick", "downloadTask(name)");


                    let currentDateTime = new Date(value.creationDate);
                    let formattedDate = currentDateTime.getDate() + "-" + (currentDateTime.getMonth() + 1) + "-" + currentDateTime.getFullYear();

                        elem.append("<p>").text(value.taskSubject);
                        elem.append("<br>");
                        elem.append(formattedDate);
                    elem.append("<br>");
                        elem.append(button);

                        elem.append(button2);

                    elem.show();

                }

            });

        $("#tasks").append(list);
        $(list).append(button);


    });
}

