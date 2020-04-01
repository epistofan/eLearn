async function changeAvatar() {

    $("#avatarTools").empty();

    let fileInput = $("<input>").attr("type", "file");
    let imagePreview = $("<img>");

    //imagePreview.attr("src", URL.createObjectURL(fileInput[0].files[0]));

    let button = $("<button>").text("Mainit").click(async function () {


        let photo = fileInput[0].files[0];


        let formData = new FormData();
        formData.append("photo", photo);
        try {
            const response = await fetch("http://macibas.linkpc.net/worker", {
                headers: {"Authorization": $("#tkn2").text() },
                method: "PUT",
                body: formData
            });
            const result = await response;


            alert("Bilde mainita");

        getPhoto();

        } catch (error) {
            alert("neizdevas");

        }



    });
    let closeButton = $("<button>").text("Cancel").click(async function () {

        $("#avatarTools").empty();

        });

    $("#avatarTools").append(button);
    $("#avatarTools").append(fileInput);
    $("#avatarTools").append(closeButton);
    $("#avatarTools").append(imagePreview);







}

