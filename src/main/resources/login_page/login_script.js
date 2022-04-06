console.log("login script!!");

function validateLogin(event) {
    // event.preventDefault();
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    if(verifyInput(username, password)) {
        location.href = "../home_page/index.html";
    }
}

function verifyInput(username, password) {
    
}