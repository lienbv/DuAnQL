<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Liên hệ</title>
    <link rel="stylesheet" href="./views/assets/css/lienhekhach.css">
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

        <div class="container_content">
            <div class="content_map">
                <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3725.1573060338806!2d105.79019334629783!3d20.986330544538387!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3135adfe9f2f947d%3A0xdea65fe0b3a71c04!2zQuG7p25nIEJ1ZmZldA!5e0!3m2!1svi!2s!4v1636186269557!5m2!1svi!2s" 
                width="100%" height="500" style="border:0;" allowfullscreen="" loading="lazy"></iframe>
            </div>
            <div class="content_info" style="padding-bottom: 15px;">
                <div class="form">
                    <form action="" id="form1">
                        <h2>Liên hệ với chúng tôi</h2>
                        <input type="text" style="border: 1px solid black;" id="fname" name="fname" placeholder="Họ tên"><br>
                        <input type="text" style="border: 1px solid black;" id="femail" name="femail" placeholder="Địa chỉ Email"><br>
                        <input type="text" style="border: 1px solid black;" id="fcontent" name="fcontent" placeholder="Nội dung yêu cầu"><br>
                        <input type="submit" value="Gửi yêu cầu">
                    </form>
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