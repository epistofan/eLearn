async function  getPic() {

    try {

    let response = await fetch("https://api.nasa.gov/planetary/apod?api_key=sItsDwcpicgqmJeXI3VyZj2k6SEPyVC44vqqI3aD");

    const result = await response.json();


    $("#titlePic").attr("src", result.url).attr("alt", result.title);
    $("#title").text(result.title);
    $("#descr").text(result.explanation);
    $("#copyright").append(result.copyright);

}catch (error){


        $("#title").text("... no picture for today... ;(");

}

}