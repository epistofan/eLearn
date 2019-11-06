function collapse() {

let element = document.getElementById("coll")
    let x = document.querySelector(".myContent");
    let y = window.getComputedStyle(x, null);

    if (y.getPropertyValue("display") === "none") {
        element.style.display = "block";
    } else {
        element.style.display = "none";
    }
}

function collapse2() {

    let element = document.getElementById("addWorker")
    let x = document.querySelector(".myContent2");
    let y = window.getComputedStyle(x, null);

    if (y.getPropertyValue("display") === "none") {
        element.style.display = "block";
    } else {
        element.style.display = "none";
    }
}