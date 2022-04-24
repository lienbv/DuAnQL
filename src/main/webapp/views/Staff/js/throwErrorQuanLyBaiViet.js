var urlName = location.href;


if(urlName.search("successDeletePost") > 0) {
    alert("Delete Post successfully!");
} else if (urlName.search("successUpdateBaiViet") > 0){
	alert("Update post successfully!");
}  else if (urlName.search("SuccsesBill") > 0){
	alert("Thanh toán thành công!");
} else {
    console.log("Nothing");
}