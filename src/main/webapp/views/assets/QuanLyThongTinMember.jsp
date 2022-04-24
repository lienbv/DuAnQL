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
    <title>Thông tin của tôi</title>
    <link rel="stylesheet" href="./views/assets/css/quanlythongtinmember.css">
    <link rel="stylesheet" href="./views/assets/css/login.css">
    <link rel="stylesheet" href="./views/assets/css/grid.css">
    <link rel="stylesheet" href="./views/assets/css/base.css">
    <link rel="stylesheet" href="./views/assets/css/forgotpassword.css">
    <link rel="stylesheet" href="./views/assets/responsive/homeR.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="./fontawesome-free-5.15.3-web/css/all.min.css">
    <link rel="stylesheet" href="./views/assets/fontawesome-free-5.15.3-web/css/all.min.css">
	<% String err=request.getParameter("error");
		String suc=request.getParameter("sucssec");
                        %>
    <link rel="stylesheet" href="./views/assets/fontawesome-free-5.15.3-web/css/all.min.css">

</head>

<body>
    <div id="app">
        <jsp:include page="HeaderKhachHang.jsp"></jsp:include>

        <div class="container_content col row l-12">
            <div class="content_header">
                <div class="header_tabs">
                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home"
                                aria-selected="true">Cập nhật thông tin cá nhân</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile"
                                aria-selected="false">Đổi mật khẩu</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-contact" type="button" role="tab" aria-controls="pills-contact"
                                aria-selected="false">Quản lý hóa đơn</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="pills-contact-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-history" type="button" role="tab" aria-controls="pills-contact"
                                aria-selected="false">Lịch sử đặt bàn</button>
                        </li>
                    </ul>
                </div>

            </div>
            <div class="tab-content" id="pills-tabContent">
            
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="content1" style="margin-left: 30%;">
                        <h3>Thông tin cá nhân</h3>
                        <form action="/QL_Dat_Ban_NH/Profile" method="post" >
                        <%if("2".equals(suc)){
                            		out.print("<h5 id='alertupdateprofile' style='color: green;' class='form-text text-muted' >Update profile success</h5>");
                            	} %>
                            <div class="mb-3">
                                <label for="exampleInputFullName1" style="float: left; width: 100px;"
                                    class="form-label">Họ và tên bạn
                                </label>
                                <input type="text" class="form-control" id="exampleInputFullName1"
                                    aria-describedby="emailHelp" onkeyup="checkFormName()" name="hoTen" value="${profile.hoTen }" required>
                                <div id="nameHelp" class="error"></div>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPhoneNume1" style="float: left; width: 100px;"
                                    class="form-label">Số điện thoại</label>
                                <input type="tel" class="form-control" id="exampleInputPhoneNume1" onkeyup="checkFormPhone()" name="sdt" value="${profile.sdt }" required>
                                <div id="emailHelp" class="error"></div>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputEmail1" style="float: left; width: 100px;"
                                    class="form-label">Email của bạn</label>
                                <input type="email" class="form-control" name="gmail" id="exampleInputEmail1" value="${profile.gmail }" required>
                                <div id="emailHelp" class="error"></div>
                            </div>
                            <button type="submit" id="button1" formaction="/QL_Dat_Ban_NH/Profile/Updateprofile?id=${iduser}" class="btn btn-primary">Submit</button>  

                        </form>
                    </div>
                </div>
                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                    <div class="content1" style="margin-left: 30%;">
                        <h3>Đổi mật khẩu</h3>
                        <form action="/QL_Dat_Ban_NH/Profile" method="post" >
                        <%if("1".equals(suc)){
                            		out.print("<h5 id='Changepasswords' style='color: green;' class='form-text text-muted' >Change Password Success</h5>");
                            	} %>
                            <div class="mb-3">
                                <label for="InputOldPass1" style="float: left; width: 100px;" class="form-label">Mật khẩu cũ</label>
                                <input required type="password" class="form-control" name="oldpassword" id="InputOldPass1" aria-describedby="emailHelp">
                                <%if("1".equals(err)){
                            		out.print("<small id='oldpasswordhl' style='color: red;' class='form-text text-muted' >Password Insuccess</small>");
                            	} %>
                            </div>
                            <div class="mb-3">
                                <label for="InputNewPass1" style="float: left; width: 100px;" class="form-label">Mật khẩu mới</label>
                                <input type="password" class="form-control" id="InputNewPass1" required name='newpass'>
                                <div id="newPass1Help" class="error"></div>
                            </div>
                            <div class="mb-3">
                                <label for="InputNewPass2" style="float: left; width: 100px;" class="form-label">Nhập lại mật khẩu</label>
                                <input type="password" class="form-control" id="InputNewPass2" onkeyup='check();' required name='confirmpass'>
                                <div id="newPass2Help" class="error"></div>
                                <div id="newPass2HelpSuc" class="success" style="color: green; float: left;"></div>
                            </div>
                            <button type="submit" id="button" formaction="/QL_Dat_Ban_NH/Profile/Changepass?id=${iduser}"  class="btn btn-primary">Submit</button>
                        </form>
                    </div>
                </div>
				<div class="tab-pane fade table_lshd" id="pills-contact" role="tabpanel"
                    aria-labelledby="pills-contact-tab" style="margin-left: 10%;">
                    <div class="container_content">
                        <div class="col row l-12">
                            <div class="container_content-header">
                                <h3 class="container_content-header--title">Lịch sử hóa đơn</h3>
                            </div>
                            <div class="container_content-body">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">NGÀY ĂN</th>
                                            <th scope="col">SỐ LƯỢNG NGƯỜI</th>
                                            <th scope="col">GIẢM GIÁ</th>
                                            <th scope="col">TỔNG TIỀN</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${lsthoadon}" var="hd">
                                        	<tr>
                                            	<td>${hd.thoi_gian.toString()} </td>
                                            	<td>${hd.thongTinBanDat.so_Luong_Nguoi}</td>
                                            	<td>${hd.khuyen_mai}</td>
                                            	<td>${hd.tong_Tien}</td>
                                        	</tr>
                                    	</c:forEach>
                                        
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="tab-pane fade table_lsdb" id="pills-history" role="tabpanel"
                    aria-labelledby="pills-contact-tab">
                    <div class="container_content">
                        <div class="col row l-12">
                            <div class="container_content-header">
                                <h3 class="container_content-header--title">Lịch sử đặt bàn</h3>
                            </div>
                            <div class="container_content-body">
                                <table class="table table-striped">
                                    <thead>
                                        <tr>
                                        	<th scope="col">NGÀY ĐẶT BÀN</th>
                                        	<th scope="col">GIỜ ĐẶT BÀN</th>
                                            <th scope="col">HỌ VÀ TÊN</th>
                                            <th scope="col">SỐ ĐIỆN THOẠI</th>
                                            <th scope="col">SỐ LƯỢNG NGƯỜI</th>
                                            <th scope="col">TRẠNG THÁI</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    	<c:forEach items="${lstbandat}" var="ttbd">
                                        <tr>
                                        	<td>${ttbd.ngayDatBan }</td>
                                        	<td>${ttbd.gioDatBan }</td>
                                            <td>${ttbd.khachHang.hoTen }</td>
                                            <td>${ttbd.khachHang.sdt }</td>
                                            <td>${ttbd.so_Luong_Nguoi }</td>
                                            <td>${ttbd.trang_Thai }</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        <jsp:include page="Login.jsp"></jsp:include>
        
    </div>

	<jsp:include page="ForgotPassword.jsp"></jsp:include>
    <jsp:include page="FooterKhachHang.jsp"></jsp:include>

    <script src="./views/assets/js/quanlythongtinmember.js"></script>
    <script>
        var myCarousel = document.querySelector('#myCarousel')
        var carousel = new bootstrap.Carousel(myCarousel, {
            interval: 1000,
            wrap: false
        })
        var triggerTabList = [].slice.call(document.querySelectorAll('#myTab button'))
        triggerTabList.forEach(function (triggerEl) {
            var tabTrigger = new bootstrap.Tab(triggerEl)
            triggerEl.addEventListener('click', function (event) {
                event.preventDefault()
                tabTrigger.show()
            })
        })
    </script>
    <script src="./views/assets/js/login.js"></script>
    <script src="./views/assets/js/throwErrorQuanLyTTMember.js"></script>
    <script src="./views/assets/js/navbar.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="./views/assets/js/onclickLogin.js"></script>
</body>

</html>