var urlName = location.href;

var updateSuccess = urlName.search("updateSuccess");

if(updateSuccess > 0) {
    alert("Update Account Successfully!");
} else if (urlName.search("successDeleteBan") > 0){
	alert("Delete Table successfully!");
} else if (urlName.search("succesCreateEmployee") > 0){
	alert("Create Account Employee successfully!");
} else if (urlName.search("errorCreateEmployee") > 0){
	alert("Create Account Employee fail, Please try again!");
} else if (urlName.search("successupdateMenuManager") > 0){
	alert("Update Menu successfully!");
} else if (urlName.search("successUpdateBanManager") > 0){
	alert("Update Table successfully!");
} else if (urlName.search("successUpdateAccManager") > 0){
	alert("Update Account successfully!");
} else if (urlName.search("successThemBan") > 0){
	alert("Thêm bàn thành công!");
} else {
    console.log("Nothing");
}