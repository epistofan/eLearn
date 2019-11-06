function newWorker() {


    let firstName = $("#firstName").val();
    let lastName = $("#lastName").val();
    let username = $("#username").val();
    let password = $("#password").val();
    let photo = $("#photo")[0].files[0];

    let worker  = {
        firstName,
        lastName

    };

    let workerAccess  = {
        username,
        password

    };
    let data =  JSON.stringify(worker);
    let data2 =  JSON.stringify(workerAccess);

    let formData = new FormData();
    formData.append("photo", photo);
    formData.append("worker", data);
    formData.append("workerAccess", data2);



                        $.ajaxSetup({async: true,
                                            headers: {},


                                            });


                      $.ajax({url: "http://macibas.linkpc.net/worker", data: formData, cache: false, processData: false,
                          contentType: false, method: "POST", success: function () {}


                    });


}

