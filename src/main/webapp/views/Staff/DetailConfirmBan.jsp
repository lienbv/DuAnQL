<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Xác nhân chi tiết bàn ${infor.idBd }</title>
    <link rel="stylesheet" href="./views/Staff/css/base.css">
    <link rel="stylesheet" href="./views/Staff/css/detailconfirmban.css">
    <link rel="stylesheet" href="./views/Staff/css/grid.css">
    <link rel="stylesheet" href="./views/Staff/fontawesome-free-5.15.3-web/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <div id="app">
    <form action="/QL_Dat_Ban_NH/Confirmbooking" method="post">
        <div class="container-fluid">

            <div class="container_left l-3">
                <ul class="nav flex-column">
                    <li class="nav_logo">
                        <h3>${sessionScope.acountST.hoTen }</h3>
                    </li>
                    <form action="/QL_Dat_Ban_NH/Confirmbooking" method="post" style="width: 100%;">
                       
                        <li class="nav-item1">
                            <input type="text" style="width: 100%;" readonly class="form-control" id="exampleFormControlInput1" placeholder="Họ và tên" value="${infor.khachHang.hoTen }">
                        </li>
                        <li class="nav-item1">
                            <input type="text" style="width: 100%; margin: 15px 0 15px 0;" readonly class="form-control" id="exampleFormControlInput1" placeholder="Email" value="${infor.khachHang.gmail }">
                        </li>
                        <li class="nav-item1">
                            <input type="text" style="width: 100%; margin-bottom: 10px;" readonly class="form-control" id="exampleFormControlInput1" placeholder="Số điện thoại" value="${infor.khachHang.sdt }">
                        </li>
                        <li class="nav-item1">
                            <div class="controlBTN" style="width: 100%; margin-bottom: 10px;">
                            	<h6>Ngày đặt</h6>
                                <c:if test="${count==1 }">
                                       	<a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay1 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-danger">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay2 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-info">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay3 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-info">${ngay3 }</a>
                                    </c:if>
                                    <c:if test="${count==2 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay1 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-info">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay2 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-danger">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay3 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-info">${ngay3 }</a>
                                    </c:if>
                                    <c:if test="${count==3 }">
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay1 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-info">${ngay1 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay2 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-info">${ngay2 }</a>
                                        <a type="button" href="/QL_Dat_Ban_NH/Confirmbooking?date=${ngay3 }&&index=${infor.idBd}&&status=1" style="width: auto; float: left; margin: 2px; border-radius: 50px; padding:10px 28px;" class="btn btn-danger">${ngay3 }</a>
                                    </c:if>
                            </div>
                        </li>
                        <li class="nav-item1">
                            <h6>Giờ đặt</h6>
                        </li>
                        <li class="nav-item1">
                            <select name="timedatban" id="" class="form-select" style="width: 450px; margin-bottom: 15px; height: 38px;">
                                <c:if test="${infor.gioDatBan==null }">
                                        	<option selected value="1">Chọn giờ</option>
                                        </c:if>
                                <c:forEach items="${giodat }" var="hour">
                                        <c:if test="${hour.equals(infor.gioDatBan) }">
                                        	<option selected value="${hour }">${hour }</option>
                                        </c:if>
                                        <c:if test="${!hour.equals(infor.gioDatBan) }">
                                        <option value="${hour }">${hour }</option>
                                        </c:if>
                                        </c:forEach> 
                            </select>
                        </li>
                        <li class="nav-item1">
                            <h6>Số lượng người</h6>
                        </li>
                        <li class="nav-item1">
                            <input type="number" style="width: 100%;" required class="form-control" name="so_luong" id="exampleFormControlInput1" value="${infor.so_Luong_Nguoi }">
                        </li>
                        <li class="nav-item1">
                            <h6>Ghi chú</h6>
                        </li>
                        <div class="form-floating">
                            <textarea class="form-control" placeholder="Leave a comment here" name="Note" id="floatingTextarea2"
                                style="height: 100px; resize: none; width: 450px;">${infor.ghi_Chu }</textarea>
                        </div>
                    
                </ul>
                <div class="left_footer">
                    <a href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" width="55" height="55" fill="currentColor"
                            class="bi bi-arrow-bar-up" viewBox="0 0 16 16">
                            <path fill-rule="evenodd"
                                d="M8 10a.5.5 0 0 0 .5-.5V3.707l2.146 2.147a.5.5 0 0 0 .708-.708l-3-3a.5.5 0 0 0-.708 0l-3 3a.5.5 0 1 0 .708.708L7.5 3.707V9.5a.5.5 0 0 0 .5.5zm-7 2.5a.5.5 0 0 1 .5-.5h13a.5.5 0 0 1 0 1h-13a.5.5 0 0 1-.5-.5z" />
                        </svg>
                    </a>
                </div>
            </div>

            <div class="container_right l-12">
                <div class="right_header">
                    <div class="header_search" style="float: left;">
                        <a type="button" href="/QL_Dat_Ban_NH/Notification" class="btn btn-secondary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                            </svg>
                        </a>
                    </div>
                </div>

                <div class="container_right_body l-12">
                    <div class="body_left l-3"></div>
                    <div class="body_right l-9">
                        <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                            <li class="nav-item1" role="presentation">
                                <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill"
                                    data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home"
                                    aria-selected="true">
                                    Chọn bàn
                                </button>
                            </li>
                            <li class="nav-item1" role="presentation">
                                <button class="nav-link" id="pills-home-tab" data-bs-toggle="pill"
                                    data-bs-target="#pills-not" type="button" role="tab" aria-controls="pills-not"
                                    aria-selected="true">
                                    Giỏ hàng
                                </button>
                            </li>
                        </ul>
						
                        <div class="tab-content" id="pills-tabContent">
                            <!--CHỌN BÀN start-->
                            
                           <c:if test="${status==1 }">
                            <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                                aria-labelledby="pills-home-tab">
                                 
                                <div class="content_submit">
                                    <button type="submit" formaction="/QL_Dat_Ban_NH/Confirmbooking/Create?index=${infor.idBd }&&date=${ngay}" class="btn btn-info" style="width: 200px;">Đặt bàn</button>
                                </div>
                                
                                <c:forEach items="${ban_trong }" var="ban">
                                    <div class="content_button l-5">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value=${ban.IDBan } name="checkboxbandat"
                                                id="flexCheckDefault">
                                            <label class="form-check-label" for="flexCheckDefault">
                                                <a href="">
                                                    <button type="button" class="btn btn-warning buttonTable">
                                                        Bàn ${ban.IDBan } <br>
                                                        loại bàn: ${ban.loaiBan } người
                                                    </button>
                                                </a>
                                            </label>
                                        </div>
                                    </div>
								</c:forEach>
								
                            </div>
                            </c:if>
                            <c:if test="${status==2 }">
                            <div class="tab-pane fade show active" id="pills-home" role="tabpanel"
                                aria-labelledby="pills-home-tab">
                                 
                                <div class="content_submit">
                                    <button type="submit" formaction="/QL_Dat_Ban_NH/Confirmbooking/Update?index=${infor.idBd }&&date=${ngay}" class="btn btn-info" style="width: 200px;">Sửa</button>
                                </div>
                                <c:forEach items="${Confirmed }" var="ban">
                                    <div class="content_button l-5">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" checked value=${ban.ttBan.IDBan } name="checkboxbandat"
                                                id="flexCheckDefault">
                                            <label class="form-check-label" for="flexCheckDefault">
                                                <a href="">
                                                    <button type="button" class="btn btn-warning buttonTable">
                                                        Bàn ${ban.ttBan.IDBan } <br>
                                                        loại bàn: ${ban.ttBan.loaiBan } người
                                                    </button>
                                                </a>
                                            </label>
                                        </div>
                                    </div>
								</c:forEach>
                                <c:forEach items="${ban_trong }" var="ban">
                                    <div class="content_button l-5">
                                        <div class="form-check">
                                            <input class="form-check-input" type="checkbox" value=${ban.IDBan } name="checkboxbandat"
                                                id="flexCheckDefault">
                                            <label class="form-check-label" for="flexCheckDefault">
                                                <a href="">
                                                    <button type="button" class="btn btn-warning buttonTable">
                                                        Bàn ${ban.IDBan } <br>
                                                        loại bàn: ${ban.loaiBan } người
                                                    </button>
                                                </a>
                                            </label>
                                        </div>
                                    </div>
								</c:forEach>
								
                            </div>
                            </c:if>
                            
                            <!--CHỌN BÀN end-->

                            <!--GIỎ HÀNG start-->
                            <div class="tab-pane fade" id="pills-not" role="tabpanel"
                                aria-labelledby="pills-profile-tab">
                                <table class="table" style="text-align: center;">
                                    <thead>
                                        <tr>
                                            <th scope="col">MÃ MÓN</th>
                                            <th scope="col">TÊN MÓN</th>
                                            <th scope="col">ẢNH</th>
                                            <th scope="col">SỐ LƯỢNG</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${dsgiohang }" var="food">
                                        <tr>
                                            <th scope="row">${food.menu.idmn }</th>
                                            <td><img alt="./views/assets/imgs/${food.menu.ten_Mon_An}" style="width: 298px; height: 240px;" src=""></td>
                                            <td>${food.menu.img }</td>
                                            <td>${food.so_luong }</td>
                                        </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            
                            <!--GIỎ HÀNG end-->
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
	</form>
    </div>

	<div class="container_footer" style="text-align: center;">
        <hr>
        <p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
    </div>
    <script src="./views/Staff/js/sidebar.js"></script>
    <script src="./views/Staff/js/thongtincanhanstaff.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>