function logout(){

    let logoutRequest = new XMLHttpRequest();
    logoutRequest.open('GET', 'http://10.10.10.100:8888', true);



    logoutRequest.send();

    window.location.href = "http://10.10.10.100:8888";
}