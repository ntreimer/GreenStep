let footprintArray = ["footprints! ", "about ", "learn ", "Let's "];
document.getElementById("show-message-button").addEventListener("click", showMessage);

function showMessage() {
    if (footprintArray.length === 0) {
        alert("no more message left!");
    }
    document.getElementById("message-here").append(footprintArray.splice(footprintArray.length - 1));
}

function forLoopMessage() {
    let content = document.getElementById("for-loop-message").value + " ";
    let loopNumber = Number(document.getElementById("for-loop-times").value);
    for (let i = 0; i < loopNumber; i++) {
        console.log(loopNumber);
        document.getElementById("for-message-here").append(content);        
    }
}