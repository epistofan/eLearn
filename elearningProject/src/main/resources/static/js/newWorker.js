async function newWorker() {


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



    try {
        const response = await fetch("http://macibas.linkpc.net/worker", {
            method: "POST",
            body: formData
        });
        const result = await response;
        console.log('Успех:', result);

        alert("Darbinieks ir izveidots");

        $("#firstName").val("");
        $("#lastName").val("");
        $("#username").val("");
        $("#password").val("");
        $("#photo").val("");
        $("#addWorker").hide();


    } catch (error) {
        alert("neizdevas");
        console.error('Ошибка:', error);
    }


workers();

}

