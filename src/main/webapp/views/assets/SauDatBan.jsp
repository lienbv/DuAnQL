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
    <title>Thông tin đặt bàn ${inforbooking.idBd}</title>
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
            <div class="content_left l-8">
                <div class="content_left_forminput">
                    <div class="forminput_title">GIỎ HÀNG</div>
                    <div class="forminput_content">
                        <form action="" method="post">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td style="font-weight: bold;" scope="col">STT</td>
                                        <td style="font-weight: bold;" scope="col">HÌNH ẢNH</td>
                                        <td style="font-weight: bold;" scope="col">TÊN MÓN</td>
                                        <td style="font-weight: bold;" scope="col">SỐ LƯỢNG</td>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${carts }" var="monan">
                                    <tr>
                                        <th scope="row"></th>
                                        <td>${monan.menu.img }</td>
                                        <td>${monan.menu.ten_Mon_An }</td>
                                        <td>${monan.so_luong }</td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </form>

                        <a type="button" href="/QL_Dat_Ban_NH/Order?index=${inforbooking.idBd}" style="width: 300px; float: left; margin-top: 20px;"
                            class="btn btn-success">THÊM MÓN ĂN</a>
                        <button type="button" style="width: 300px; float: right; margin-top: 20px;"
                            class="btn btn-danger">HỦY ĐẶT BÀN</button> 
                    </div>
                </div>
            </div>

            <div class="content_right l-4">
                <div class="content_right_forminfo">
                    <div class="forminput_title">THÔNG TIN BÀN ĐẶT</div>
                    <div class="forminfo_content">
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="inputAddress">Họ và tên</label>
                            <input type="text" style="height: 50px; margin-top: 10px;" readonly class="form-control"
                                id="inputAddress" placeholder="${inforbooking.khachHang.hoTen }">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="inputAddress2">Số điện thoại</label>
                            <input type="text" style="height: 50px; margin-top: 10px;" readonly class="form-control"
                                id="inputAddress2" placeholder="${inforbooking.khachHang.sdt }">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="inputAddress2">Số lượng người</label>
                            <input type="text" style="height: 50px; margin-top: 10px;" readonly class="form-control"
                                id="inputAddress2" placeholder="${inforbooking.so_Luong_Nguoi }">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="inputAddress2">Ngày đặt</label>
                            <input type="text" style="height: 50px; margin-top: 10px;" readonly class="form-control"
                                id="inputAddress2" placeholder="${inforbooking.ngayDatBan }">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="inputAddress2">Giờ đặt</label>
                            <input type="text" style="height: 50px; margin-top: 10px;" readonly class="form-control"
                                id="inputAddress2" placeholder="${inforbooking.gioDatBan }">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="inputAddress2">Trạng thái</label>
                            <input type="text" style="height: 50px; margin-top: 10px;" readonly class="form-control"
                                id="inputAddress2" placeholder="${inforbooking.trang_Thai }">
                        </div>
                        <div class="form-group" style="margin-bottom: 20px;">
                            <label for="inputAddress2">Ghi chú</label>
                            <textarea readonly style="margin-top: 10px; resize: none;" class="form-control"
                                id="exampleFormControlTextarea1" rows="3">${inforbooking.ghi_Chu }</textarea>
                        </div>
                    </div>
                    <a type="button" href="/QL_Dat_Ban_NH/Changebooking?index=${inforbooking.idBd}" style="margin-top: 20px; margin-left: 5%;" class="btn btn-success js_showmodal_info">
                        CẬP NHẬT THÔNG TIN
                    </a>
                </div>
            </div>

        </div>

        <!--modal login, regis start-->
		<jsp:include page="Login.jsp"></jsp:include>

        <jsp:include page="ForgotPassword.jsp"></jsp:include>

        <!--modal edit giỏ hàng-->
        <div class="modal_editGioHang js_modal_editGioHang">
            <div class="modal_editGioHang_container js_modal_editGioHang_container">
                <form>
                    <h3 style="text-align: center;">CHỈNH SỬA GIỎ HÀNG</h3>
                    <div class="form-group" style="margin-bottom: 15px;">
                        <label style="float: left;" for="formGroupExampleInput">Tên món</label>
                        <input readonly style="width: 380px;" type="text" class="form-control"
                            id="formGroupExampleInput" value="Lẩu Ếch">
                    </div>
                    <div class="form-group" style="margin-bottom: 15px;">
                        <label style="float: left;" for="formGroupExampleInput2">Số lượng</label>
                        <input style="width: 380px;" type="number" class="form-control" id="formGroupExampleInput2"
                            value="1">
                    </div>
                    <button type="button" style="width: 280px; margin-bottom: 15px;" class="btn btn-success">
                        SUBMIT
                    </button>
                    <button type="button" class="btn btn-danger js_btn_close">EXIT</button>
                </form>
            </div>
        </div>

    </div>

    <jsp:include page="FooterKhachHang.jsp"></jsp:include>

    <script>
        var myCarousel = document.querySelector('#myCarousel')
        var carousel = new bootstrap.Carousel(myCarousel, {
            interval: 1000,
            wrap: false
        })

    </script>
    <script src="./views/assets/js/saudatbangiohang.js"></script>
    <script src="./views/assets/js/login.js"></script>
    <script src="./views/assets/js/navbar.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="./views/assets/js/onclickLogin.js"></script>
</body>

</html>