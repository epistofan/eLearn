async function workers() {

$("#users").empty();
    let response = await fetch("http://macibas.linkpc.net/workers", {headers: {"Authorization": $("#tkn2").text() }});

    let data = await response.json();

        JSON.stringify(data);

    let list = $("<ul>");


    $.each(data, function (index, value) {


        let button = $("<li>")
            .attr({class: "collapsible2", id:value.workerId})
            .text(value.workerId +" "+value.firstName+ " "+value.lastName)
            .append("<div class='content2'>")
            .click(async function () {

                let elem =  $(this).find(".content2");



                if(elem.is(":visible")){

                    elem.hide();
                }else {
                    let response = await fetch("http://macibas.linkpc.net/getWorkerTask", {headers: {"Authorization": $("#tkn2").text(),"user": value.workerId }});
                    let data = await response.json();

                    JSON.stringify(data);

                        $.each(data, function (index, value) {

                            elem.append("<p>").text(value.taskName);
                        });
                        elem.show();

                    }

            });

        $("#users").append(list);
        $(list).append(button);


    });
}

