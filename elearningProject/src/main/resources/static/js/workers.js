async function workers() {

$("#users").empty();
    let response = await fetch("http://macibas.linkpc.net/workers", {headers: {"Authorization": $("#tkn2").text() }});

    let data = await response.json();


    let list = $("<select>");


    $.each(data, function (index, value) {


        let button = $("<option>")
            .attr({class: "collapsible2", value:value.workerId})
            .text(value.workerId +" "+value.firstName+ " "+value.lastName)
            .click(async function () {

        let elem = $("#userInfo");

                    let response = await fetch("http://macibas.linkpc.net/getWorkerTask", {headers: {"Authorization": $("#tkn2").text(),"user": value.workerId }});
                    let data = await response.json();


                        $.each(data, function (index, value) {

                            elem.append("<p>").text(value.taskName);
                        });




            });

        $("#users").append(list);
        $(list).append(button);


    });
}

