var urlName = location.href;

if(urlName.search("successChangePass") > 0) {
    alert("Change Password successfully!");
} else if (urlName.search("errorChangePass") > 0){
	alert("Change Password fail, Please try again!");
} else if (urlName.search("sucssecUpdateprofile") > 0){
	alert("Update profile successfully!");
} else if (urlName.search("errorUpdateprofile") > 0){
	alert("Update profile fail, Please try again!");
} else {
    console.log("Nothing");
}