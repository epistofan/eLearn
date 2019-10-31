function logout(){

    let logoutRequest = new XMLHttpRequest();
    logoutRequest.open('GET', 'http://macibas.linkpc.net', true);



    logoutRequest.send();

    window.location.href = "http://macibas.linkpc.net";
}