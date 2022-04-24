const signUpButton = document.getElementById('signUp');
const signInButton = document.getElementById('signIn');
const container = document.getElementById('container');

signUpButton.addEventListener('click', () => {
	container.classList.add("right-panel-active");
});

signInButton.addEventListener('click', () => {
	container.classList.remove("right-panel-active");
});


// check repeat password
var checkPass = function(){
	if (document.getElementById("pass").value == document.getElementById("repeatPass").value) {
		document.getElementById("button").disabled = false;
		document.getElementById("repeatPass").style.borderColor = "green";
	} else {
		alert("Password not match");
		document.getElementById("repeatPass").style.borderColor = "red";
		document.getElementById("button").disabled = true;
	}
}