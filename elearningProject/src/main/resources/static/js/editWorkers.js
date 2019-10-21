function editWorkers() {


    let list = document.getElementById("listOfWorkers").getElementsByTagName('li');

    for (let i=0; i<list.length; i++) {
        list[i].addEventListener('click', function () {alert("test")

        }, false);
    }

}

