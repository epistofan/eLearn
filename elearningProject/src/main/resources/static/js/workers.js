async function workers() {


    let response = await fetch("http://macibas.linkpc.net/workers", {headers: {"Authorization": $("#tkn2").text() }});

    let data = await response.json();

        JSON.stringify(data);

    let list = $("<ul>");


    $.each(data, function (index, value) {


        let button = $("<li>")
            .attr({class: "collapsible2", id:value.workerId})
            .text(value.workerId +" "+value.firstName+ " "+value.lastName)
            .append("<div class='content2'>")
            .click(function () {



                let item = $( this );
                let div = item.find( "div" );



                $.each(data, function (index, value) {


                    div.append(value.taskId + " " + value.taskName + "<br>" + value.taskSubject);
                    div.append("<br>");

                });
            });

        $("#users").append(list);
        $(list).append(button);


    });
}

