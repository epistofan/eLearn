function newTask(){


    let taskName = $("#taskName").val();
    let taskSubject = $("#descr").val();

    let file = $("#file")[0].files[0];

    let task  = {
        taskName,
        taskSubject

    };

    let data =  JSON.stringify(task);



    let formData = new FormData();
    formData.append("obj", file);
    formData.append("task", data);




    $.ajaxSetup({async: true,
        headers: {},


    });


    $.ajax({url: "http://macibas.linkpc.net/newTask", data: formData, cache: false, processData: false,
        contentType: false, method: "POST", success: function (status) {
        console.log(status);
            if (status === "success") {

                alert("Uzdevums ir izveidots");
                $("#coll").hide();
                $("#taskName").empty();
                $("#descr").empty();
                $("#file").empty();
            } else {
                alert("neizdevas");
            }





        }
    });



}