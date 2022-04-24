var urlName = location.href;


if(urlName.search("sucssesCancelBooking") > 0) {
    alert("Cancel Booking Successfully!");
} else if(urlName.search("successChangeBooking") > 0){
	alert("Change booking successfully!");
} else if(urlName.search("errorChangeBooking") > 0){
	alert("Change booking fail, Please try again!");
} else {
    console.log("Nothing throw Error Cancel Booking");
}