<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Khuyến mãi</title>
    <link rel="stylesheet" href="./views/assets/css/khuyenmai.css">
    <link rel="stylesheet" href="./views/assets/css/login.css">
    <link rel="stylesheet" href="./views/assets/css/grid.css">
    <link rel="stylesheet" href="./views/assets/css/base.css">
    <link rel="stylesheet" href="./views/assets/css/forgotpassword.css">
    <link rel="stylesheet" href="./views/assets/responsive/homeR.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="./views/assets/fontawesome-free-5.15.3-web/css/all.min.css">
</head>
<body>
    <div id="app">
        <jsp:include page="HeaderKhachHang.jsp"></jsp:include>

        <div class="container_content col l-12 row">
            <div class="m-12">
                <div class="container_content col">
                    <div class="container_content-post">
                        <img src="./views/assets/imgs/km1.jpg" style="width: 348px; height: 240px;" alt="">
                        <p style=" margin-top: 10px; font-size: 20px; font-weight: 500;">[Hà Nội] Ưu đãi mừng bộ ba Bủng – GoGi – Yu Tang về chung một nhà</p>
                        <p style="font-size: 16px;">28/10/2021</p>
                        <p> Tặng tín đồ ẩm thực quà gặp mặt duy nhất tại GoGi – Kichi – Yu Tang Times City:  ĂN 1 ĐƯỢC 3, thoả thích foodtour nướng – lẩu – trà sữa! Khi dùng</p>
                        <div class="service-item">
                            <h3><a target="_blank" href=""> Xem ngay</a></h3>
                        </div>
                    </div>
                </div>

                <div class="container_content col">
                    <div class="container_content-post">
                        <img src="./views/assets/imgs/km2.jpg" style="width: 348px; height: 240px;" alt="">
                        <p style=" margin-top: 10px; font-size: 20px; font-weight: 500;">[Hà Nội] Bủng Tân Sơn Nhất và ST Center Thủ Đức ưu đãi chỉ 199K</p>
                        <p style="font-size: 16px;">29/04/2021</p>
                        <p>Bủng Tân Sơn Nhất và ST Center Thủ Đức ưu đãi chỉ 199K/người Thưởng thức Buffet Lẩu Băng Chuyền với giá ưu đãi cả ngày chỉ 199.000đ/người</p>
                        <div class="service-item">
                            <h3><a target="_blank" href=""> Xem ngay</a></h3>
                        </div>
                    </div>
                </div>

                <div class="container_content col">
                    <div class="container_content-post">
                        <img src="./views/assets/imgs/km3.jpg" style="width: 348px; height: 240px;" alt="">
                        <p style=" margin-top: 10px; font-size: 20px; font-weight: 500;">[Hà Nội] Cả Tuần ” Nhúng Lẩu Thả Ga” Chỉ 199k</p>
                        <p style="font-size: 16px;">14/04/2021</p>
                        <p>Cả Tuần “Nhúng Lẩu Thả Ga” Chỉ Từ 199K   Kichi-Kichi dành tặng bạn ưu đãi bùng nổ với TẤT CẢ CÁC NGÀY trong tuần ở mọi khung giờ thưởng thức buffet</p>
                        <div class="service-item">
                            <h3><a target="_blank" href=""> Xem ngay</a></h3>
                        </div>
                    </div>
                </div>

                <div class="container_content col">
                    <div class="container_content-post">
                        <img src="./views/assets/imgs/km4.jpg" style="width: 348px; height: 240px;" alt="">
                        <p style=" margin-top: 10px; font-size: 20px; font-weight: 500;">[Hà Nội] Bủng Chiêu Đãi Học Sinh, Sinh Viên Chỉ 199K/Suất Buffet</p>
                        <p style="font-size: 16px;">05/04/2021</p>
                        <p>Bủng Chiêu Đãi Học Sinh, Sinh Viên Chỉ 199K/Suất Buffet Bủng tặng bạn chiếc giá buffet chỉ 199K cho tất cả học sinh – sinh viên khi đến nhà hàng.</p>
                        <div class="service-item">
                            <h3><a target="_blank" href=""> Xem ngay</a></h3>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <!--modal login, regis start-->
    <jsp:include page="Login.jsp"></jsp:include>

    <!--modal forgot pass start-->
    <jsp:include page="ForgotPassword.jsp"></jsp:include>

	<jsp:include page="FooterKhachHang.jsp"></jsp:include>
	
	<script src="./views/assets/js/register.js"></script>
    <script src="./views/assets/js/login.js"></script>
    <script src="./views/assets/js/navbar.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    <script src="./views/assets/js/onclickLogin.js"></script>
</body>
</html>