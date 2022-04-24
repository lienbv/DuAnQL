<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">

<head> 
    <meta charset="UTF-8">
    <meta http–equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Chỉnh sửa thông tin bàn ${show.idBd }</title>
    <link rel="stylesheet" href="./views/assets/css/saudatban.css">
    <link rel="stylesheet" href="./views/assets/css/login.css">
    <link rel="stylesheet" href="./views/assets/css/grid.css">
    <link rel="stylesheet" href="./views/assets/css/base.css">
    <link rel="stylesheet" href="./views/assets/css/forgotpassword.css">
    <link rel="stylesheet" href="./views/assets/responsive/datbankhachR.css">
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
            <div class="modal_editInfo">
                <div class="modal_editInfo_container">
                    <form action="/QL_Dat_Ban_NH/Changebooking" method="post">
                        <h3>CHỈNH SỬA THÔNG TIN ĐẶT BÀN</h3>
                        <div class="container_body">
                            <div class="row">
                                <div class="col">
                                        <div class="controlBTN" style="width: 480px; margin-bottom: 70px;">
                                    <c:if test="${count==1 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay1 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-danger">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay2 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-info">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay3 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-info">${ngay3 }</a>
                                    </c:if>
                                    <c:if test="${count==2 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay1 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-info">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay2 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-danger">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay3 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-info">${ngay3 }</a>
                                    </c:if>
                                    <c:if test="${count==3 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay1 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-info">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay2 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-info">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Changebooking?date=${ngay3 }&&index=${show.idBd}" style="width: 150px; float: left; margin: 2px; border-radius: 50px;" class="btn btn-danger">${ngay3 }</a>
                                    </c:if>
                                    </div>
                                </div>
                                <div class="col">
                                    <select name="timedatban" id="" class="form-select form-control" style="width: 240px; margin-bottom: 15px; height: 38px; float: left;">
                                        <c:forEach items="${giodat }" var="hour">
                                        <c:if test="${hour.equals(show.gioDatBan) }">
                                        	<option selected value="${hour }">${hour }</option>
                                        </c:if>
                                        <c:if test="${!hour.equals(show.gioDatBan) }">
                                        <option value="${hour }">${hour }</option>
                                        </c:if>
                                        </c:forEach> 
                                    </select>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <input required type="text" name="ten" class="form-control" placeholder="Họ và tên"
                                        value="${show.khachHang.hoTen }">
                                </div>
                                <div class="col">
                                    <input required type="text" name="sdt" id="exampleInputPhoneNume1" onkeyup="checkFormPhone()" class="form-control" placeholder="Số điện thoại"
                                        value="${show.khachHang.sdt }">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <input required disabled type="text" class="form-control" placeholder="Trạng thái"
                                        value="${show.trang_Thai }">
                                </div>
                                <div class="col">
                                    <input required type="number" min="1" name="soluong" class="form-control" placeholder="Số lượng người"
                                        value="${show.so_Luong_Nguoi }">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col">
                                    <textarea class="form-control" style="resize: none;"
                                        id="exampleFormControlTextarea1" name="note" placeholder="Ghi chú"
                                        rows="3">${show.ghi_Chu }</textarea>
                                </div>
                            </div>
                        </div>

                        <button type="submit" id="button1" formaction="/QL_Dat_Ban_NH/Changebooking?index=${show.idBd }&&date=${ngay}" style="width: 500px;" class="btn btn-success">SUBMIT</button>


                    </form>
                </div>
            </div>
        </div>

        <!--modal login, regis start-->
		<jsp:include page="Login.jsp"></jsp:include>

        <!--modal forgot pass start-->
        <jsp:include page="ForgotPassword.jsp"></jsp:include>

    </div>

    <jsp:include page="FooterKhachHang.jsp"></jsp:include>

    <script>
        var myCarousel = document.querySelector('#myCarousel')
        var carousel = new bootstrap.Carousel(myCarousel, {
            interval: 1000,
            wrap: false
        })

    </script>
    
    <script>
        function is_phone(phonenumber) {
            var phoneregex = /^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/;
            if (phonenumber.match(phoneregex)) {
                return true;
            }
            else {
                return false;
            }
        }

        function checkFormPhone() {
            var phone = document.getElementById('exampleInputPhoneNume1').value;
            if (is_phone(phone) == false) {
                document.getElementById('exampleInputPhoneNume1').style.borderColor = "red";
                document.getElementById("button1").disabled = true;
            } else {
                document.getElementById('exampleInputPhoneNume1').style.borderColor = "green";
                document.getElementById("button1").disabled = false;
            }
        }
    </script>
    <script src="./views/assets/js/login.js"></script>
    <script src="./views/assets/js/throwErrorCancelBooking.js"></script>
    <script src="./views/assets/js/navbar.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="./views/assets/js/onclickLogin.js"></script>
</body>

</html>