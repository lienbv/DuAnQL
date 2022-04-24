<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="header">
	<div class="grid wide">
		<div class="container_header-login">
			<div class="container_header-login-logo">
				<img src="./views/assets/imgs/logo.jpg" alt="">
			</div>
			<div class="container_header-login-button">
				<c:if test="${sessionScope.acountKH != null}">
					<div class="btn-group">
						<button type="button" class="btn btn-dark dropdown-toggle"
							data-bs-toggle="dropdown" aria-expanded="false">${sessionScope.acountKH.hoTen }</button>
						<ul class="dropdown-menu">
							<li><a class="dropdown-item" href="/QL_Dat_Ban_NH/Profile">Thông
									tin cá nhân</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="/QL_Dat_Ban_NH/Logout">Đăng
									xuất</a></li>
						</ul>
					</div>
				</c:if>
				<c:if test="${sessionScope.acountKH == null}">
					<button type="button" class="btn btn-success js-modal-btn">Đăng
						nhập</button>
				</c:if>
			</div>
		</div>
	</div>
</div>

<div class="container_banner">
	<!--slider-->
	<div id="carouselExampleFade" class="carousel slide carousel-fade"
		data-bs-ride="carousel">
		<div class="carousel-inner">

			<c:if test="${sessionScope.acountKH != null}">
				<div class="carousel-item active">
					<img src="./views/assets/imgs/banner0.jpg" class="d-block w-100"
						alt="...">
				</div>
			</c:if>
			<c:if test="${sessionScope.acountKH == null}">
				<div class="carousel-item active">
					<img src="./views/assets/imgs/banner.png" class="d-block w-100"
						alt="...">
				</div>
			</c:if>
			<div class="carousel-item">
				<img src="./views/assets/imgs/banner1.png" class="d-block w-100"
					alt="...">
			</div>
			<div class="carousel-item">
				<img src="./views/assets/imgs/banner2.jpg" class="d-block w-100"
					alt="...">
			</div>
		</div>
		<button class="carousel-control-prev" type="button"
			data-bs-target="#carouselExampleFade" data-bs-slide="prev">
			<span class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
		</button>
		<button class="carousel-control-next" type="button"
			data-bs-target="#carouselExampleFade" data-bs-slide="next">
			<span class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
		</button>
	</div>
	<!--slider end-->

	<!--banner input-->
	<c:if test="${sessionScope.acountKH == null}">
		<form action="/QL_Dat_Ban_NH/Bookinggest" method="post">
			<div class="container_banner_input">
				<div class="input-slogan">
					<div class="slogan_title">ĐẶT LỊCH GIỮ CHỖ CHỈ 30S</div>
					<div class="slogan_text">Ăn xong trả tiền, hủy lịch không sao</div>
				</div>
				<div class="input-form flex">
                	<div class="form_input">
                    	<input type="text" placeholder="Nhập số điện thoại để đặt lịch" name="phone_number" id="exampleInputPhoneNume11" style="width: 175%;" onkeyup="checkFormPhone()">
                    </div>
                 </div>
                 <div class="label">
                 	<span id="emailHelp1" style="color: tomato; font-size: 18px; float: left;"></span>
                 </div>
                 <div>
                 	<button type="submit" style="float: right;" id="button11" class="btn btn-danger">Đặt lịch</button>
                 </div>
			</div>
		</form>
	</c:if>

</div>

<div class="container_navbar">
	<div class="navbar-container">
		<ul>
			<li class="nav-link"><a
				href="/QL_Dat_Ban_NH/HomeKhachHangServlet">Trang chủ</a>
				<div class="underline"></div></li>
			<li class="nav-link"><a href="/QL_Dat_Ban_NH/Menu">Thực đơn</a>
				<div class="underline"></div></li>
			<c:if test="${sessionScope.acountKH != null}">
				<li class="nav-link"><a
					href="/QL_Dat_Ban_NH/Booking?date=${sessionScope.date_book }">Đặt
						bàn</a>
					<div class="underline"></div></li>
			</c:if>
			<li class="nav-link"><a href="/QL_Dat_Ban_NH/Khuyenmai">Khuyến
					mại</a>
				<div class="underline"></div></li>
			<li class="nav-link"><a href="/QL_Dat_Ban_NH/Lienhe">Liên hệ</a>
				<div class="underline"></div></li>
		</ul>
	</div>
</div>