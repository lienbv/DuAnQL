var urlName = location.href;

var errorGoogle = urlName.search("errorGoogle");
var successGoogle = urlName.search("successGoogle");

var errorAccWrong = urlName.search("errorAccWrong");
var succesLogout = urlName.search("succesLogout");

var successforgotpass = urlName.search("successforgotpass");
var errorforgotpass = urlName.search("errorforgotpass");

var errorSignUp = urlName.search("errorSignUp");
var succesSignUp = urlName.search("succesSignUp");

if (errorGoogle > 0) {
	alert("Chưa có tài khoản, hãy thử lại");
} else if (successGoogle > 0) {
	alert("Login with account Google successfully!");
} else if (errorAccWrong > 0) {
	alert("Password or UserName is wrong, Please Login again or create a new Account");
} else if (succesLogout > 0) {
	alert("Logout successfully, See you again!");
} else if (successforgotpass > 0) {
	alert("Your password has been sent, please check your email");
} else if (errorforgotpass > 0) {
	alert("Get password error, please try again or contact with us with phone number 0977256375");
} else if (errorSignUp > 0) {
	alert("Register account fail, because UserName or Phone Number already exist, please try again!");
} else if (succesSignUp > 0) {
	alert("Register account successfully, please Login with new account!");
} else if (urlName.search("sucssesCancelBooking") > 0){
	alert("Cancel Booking Successfully!");
} else {
	console.log("Nothing");
}