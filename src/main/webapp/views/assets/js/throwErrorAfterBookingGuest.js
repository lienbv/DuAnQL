var urlName = location.href;


if(urlName.search("sucssesBookingGuest=3") > 0) {
    alert("Đặt bàn thành công!");
} else {
    console.log("Nothing throw error after booking guest");
}