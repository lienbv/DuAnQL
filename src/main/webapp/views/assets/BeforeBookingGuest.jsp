<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Info Booking Guest</title>
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
            <h1>Info Booking Guest</h1>
        </header>

        <div id="form">

            <div class="fish" id="fish"></div>
            <div class="fish" id="fish2"></div>

            <form id="waterform" action="/QL_Dat_Ban_NH/Bookinggests" method="post">

                <div class="formgroup" id="email-form">
                    <label for="email">Ngày đặt</label>
                    <div class="controlBTN" style="width: 480px; margin-bottom: 30px;">
                    <c:if test="${count==1 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay1 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-danger">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay2 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-info">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay3 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-info">${ngay3 }</a>
                                    </c:if>
                                    <c:if test="${count==2 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay1 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-info">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay2 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-danger">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay3 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-info">${ngay3 }</a>
                                    </c:if>
                                    <c:if test="${count==3 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay1 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-info">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay2 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-info">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Bookinggests?date=${ngay3 }&&idgest=${user.idkh}" style="width: 150px; float: left; margin: 5px; border-radius: 50px;" class="btn btn-danger">${ngay3 }</a>
                                    </c:if>
                    </div>
                </div>

                <div class="formgroup" id="name-form">
                    <label for="name">Giờ đặt</label>
                    <select name="timedatban" id="" class="form-select" style="width: 500px; margin-bottom: 15px; height: 50px; border-radius: 20px;">
                        <c:forEach items="${giodat }" var="hour">
                             <option value="${hour }" selected>${hour }</option>
                        </c:forEach> 
                    </select>
                </div>

                <div class="formgroup" id="name-form">
                    <label for="name">Họ và tên</label>
                    <input required type="text" id="exampleInputFullName1" onkeyup="checkFormName()" name="name" value="${user.hoTen }"/>
                    <span id="nameHelp" style="color: tomato;"></span>
                </div>
                <div class="formgroup" id="name-form">
                    <label for="quan">Số lượng người</label>
                    <input required type="number" id="name" min="1" name="so_Luong_Nguoi" value=""/>
                </div>
                <div class="formgroup" id="message-form">
                    <label for="message">Ghi chú</label>
                    <textarea  name="ghi_Chu" style="resize: none;" id="message"></textarea>
                </div>

                <input type="submit" formaction="/QL_Dat_Ban_NH/Bookinggests?idgest=${user.idkh }&&date=${ngay}" class="cancel" id="button1" style="width: 500px !important;" value="ĐĂT BÀN NGAY"/>
            </form>
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
    <script src="./views/assets/js/quanlythongtinmember.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>