<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Confirm Info Booking Guest</title>
    <link rel="stylesheet" href="./views/assets/css/afterbookingguest.css">
    <link rel="stylesheet" href="./views/assets/css/grid.css">
    <link rel="stylesheet" href="./views/assets/css/base.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="./views/assets/fontawesome-free-5.15.3-web/css/all.min.css">

</head>

<body>
    <div id="app">
        <header>
            <h1>Confirm info booking Guest</h1>
        </header>

        <div id="form">

            <div class="fish" id="fish"></div>
            <div class="fish" id="fish2"></div>

			<div id="waterform">
                <div class="formgroup" id="name-form">
                    <label for="name">Số điện thoại</label>
                    <input disabled type="text" id="name" name="phone" value="${booking.khachHang.sdt }"/>
                </div>

                <div class="formgroup" id="name-form">
                    <label for="name">Họ và tên</label>
                    <input disabled type="text" id="name" name="hoTen" value="${booking.khachHang.hoTen }"/>
                </div>

                <div class="formgroup" id="email-form">
                    <label for="email">Ngày đặt</label>
                    <input disabled type="text" id="email" name="date" value="${booking.ngayDatBan }"/>
                </div>

                <div class="formgroup" id="name-form">
                    <label for="name">Giờ đặt</label>
                    <input disabled type="text" id="name" name="time" value="${booking.gioDatBan }"/>
                </div>
                
                <div class="formgroup" id="name-form">
                    <label for="quan">Số lượng người</label>
                    <input disabled type="number" id="name" name="so_Luong_Nguoi" value="${booking.so_Luong_Nguoi }"/>
                </div>

                <div class="formgroup" id="message-form">
                    <label for="message">Ghi chú</label>
                    <textarea  disabled style="resize: none;" id="message" name="message">${booking.ghi_Chu }</textarea>
                </div>

                <input type="submit" onclick="showMessage(${booking.idBd})" class="exit" style="float: left;" value="Hủy Lịch"/>
                <input type="submit" onclick="showexit()" class="cancel" value="Exit"/>
               </div>
        </div>

    </div>

    <div class="container_support">
        <i class="fas fa-phone-square-alt"></i>
        <p class="container_support_text">Số điện thoại liên hệ: <span>0967381938</span> </p>
    </div>

    <div class="container_footer">
        <hr>
        <p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
    </div>

    <script src="./views/assets/js/afterbookingguest.js"></script>
    <script src="./views/assets/js/throwErrorAfterBookingGuest.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
        <script>
        function showMessage(id){
            var option = confirm('Bạn có muốn xóa đặt bàn này không?');
            if(option){
                window.location.href = '/QL_Dat_Ban_NH/CancelBooking/Guest?id='+id;
            }
        }
        
        function showexit(){
			window.location.href = '/QL_Dat_Ban_NH/HomeKhachHangServlet';
        }
        </script>
</body>

</html>