function getUsers() {
    let i;
    let data;

    let request = new XMLHttpRequest();
    request.open('GET', 'http://10.10.10.100:8888/getWorkers', true);


    request.send();


    request.onload = function () {
        try {

            // Begin accessing JSON data here
            data = JSON.parse(this.response);
        } catch (err) {

        }


        if (request.status >= 200 && request.status < 400) {
            data.reverse();
            for (i = 0; i < data.length; i++) {
                let div = document.createElement("div");
                div.setAttribute("class", "content2");
                let button = document.createElement("button");
                button.setAttribute("class", "collapsible2");

                button.appendChild(document.createTextNode(data[i].firstName+ " "+data[i].lastName));

                button.setAttribute("name", data[i].workerId);



                div.appendChild(document.createTextNode(data[i].lastName));

                let p = document.createElement("p");
                p.setAttribute("id",data[i].workerId );

                div.appendChild(p);

                document.getElementById("users").appendChild(button);

                document.getElementById("users").appendChild(div);


            }
            let coll = document.getElementsByClassName("collapsible2");
            let j;
            for (j = 0; j < coll.length; j++) {
                coll[j].addEventListener("click", function () {
                    this.classList.toggle("active");
                    let content = this.nextElementSibling;
                    if (content.style.display === "block") {
                        content.style.display = "none";
                    } else {
                        content.style.display = "block";
                    }
                });
            }
        }
    }

}

