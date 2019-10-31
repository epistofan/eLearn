function workerTaskHistory() {

    $(document).ready(function() {

        $.ajaxSetup({
            async: true,
            headers: {"Authorization": $("#tkn2").text()},
            dataType: "json"

        });

        $.getJSON("http://macibas.linkpc.net/workerTaskHistory", function (data) {

            let div = $("#history");

div.empty();

                $.each(data, function (index, value) {


                   div.append(value.taskId + " " + value.taskName + " " + value.taskSubject);
                    div.append("<br>");

                });




        });



});

}

