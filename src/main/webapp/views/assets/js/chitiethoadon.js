
//get the modal
var modal = document.getElementById("js-modal-detail");

// get button open
var btnShow = document.getElementById("js_showDetail");

// get the span element that close
var span = document.getElementsByClassName("js_close");

btnShow.onclick = function () {
    modal.style.display = "block";
}

span.onclick = function () {
    modal.style.display = "none";
}

window.onclick = function (event) {
    if (event.target == modal) {
        modal.style.display = "none"
    }
}
