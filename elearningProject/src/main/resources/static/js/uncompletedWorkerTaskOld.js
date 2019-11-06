function uncompletedWorkerTask1() {
    let data;

    let i;
    let token = document.getElementById("tkn2").innerText;

    let request = new XMLHttpRequest();
    request.open('GET', 'http://macibas.linkpc.net/workers', true);
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


                     let mapLength = request.getResponseHeader("mapLength");

                     let list = $("<ul>");

            for (i = 1; i <parseInt(mapLength)+1; i++) {

                try {



                let button = $("<li>")
                    .attr({class: "collapsible2", id:data[i][0].workerId})
                    .text(data[i][0].workerId +" "+data[i][0].firstName+ " "+data[i][0].lastName)
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

            }catch (error) {
                console.log("error");
            }


            }

        }else {

            return "no access";
        }
    }






}

