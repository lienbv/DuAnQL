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
<title>Thực đơn</title>
<link rel="stylesheet" href="./views/assets/css/thucdonkhachhang.css">
<link rel="stylesheet" href="./views/assets/css/login.css">
<link rel="stylesheet" href="./views/assets/css/grid.css">
<link rel="stylesheet" href="./views/assets/css/base.css">
<link rel="stylesheet" href="./views/assets/css/forgotpassword.css">
<link rel="stylesheet" href="./views/assets/responsive/homeR.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
	integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="./views/assets/fontawesome-free-5.15.3-web/css/all.min.css">

</head>

<body>
	<div id="app">
		<jsp:include page="HeaderKhachHang.jsp"></jsp:include>

		<div class="container_content col row l-12">
			<div class="content_header">
				<div class="header_tabs">
					<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
						<li class="nav-item" role="presentation">
							<button class="nav-link active" id="pills-home-tab"
								data-bs-toggle="pill" data-bs-target="#pills-home" type="button"
								role="tab" aria-controls="pills-home" aria-selected="true">HẢI
								SẢN THỎA THÍCH</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-profile-tab"
								data-bs-toggle="pill" data-bs-target="#pills-profile"
								type="button" role="tab" aria-controls="pills-profile"
								aria-selected="false">BUFFET</button>
						</li>
						<li class="nav-item" role="presentation">
							<button class="nav-link" id="pills-contact-tab"
								data-bs-toggle="pill" data-bs-target="#pills-contact"
								type="button" role="tab" aria-controls="pills-contact"
								aria-selected="false">ĐỒ UỐNG</button>
						</li>
					</ul>
				</div>

			</div>

			<div class="content_body">
				<div class="tab-content" id="pills-tabContent">
					<div class="tab-pane fade show active" id="pills-home"
						role="tabpanel" aria-labelledby="pills-home-tab">
						<div class="content_body-header">
							<h2>
								Hai San <span>//Áp dụng các ngày trong tuần</span>
							</h2>
						</div>

						<div class="content_body-menu l-5">
							<div class="flip-card">
								<div class="flip-card-inner">
									<c:forEach items="${doan }" var="item">
										<div class="front">
											<img src="./views/assets/imgs/${item.img }" alt="" />
										</div>

										<div class="back">
											<table class="">
												<tbody>
													<c:forEach items="${dsmonan }" var="food">
													<c:if test="${food.loaiMenu.idloai  == item.idloai }">
														<tr>
															<td>${food.ten_Mon_An  }</td>
														</tr>
													</c:if>
													</c:forEach>
												</tbody>
											</table>
										</div>
									</c:forEach>
								</div>
							</div>
						</div>

					</div>

					<div class="tab-pane fade" id="pills-profile" role="tabpanel"
						aria-labelledby="pills-profile-tab">
						<div class="content_body-header">
							<h2>
								Buffet <span>//Áp dụng các ngày trong tuần</span>
							</h2>
						</div>
						<c:forEach items ="${buffet }" var="loai">
						<div class="content_body-menu l-5">
							<h3>${loai.tenLoai }</h3>
							<div class="flip-card">
								<div class="flip-card-inner">
									<div class="front">
										<img src="./views/assets/imgs/${loai.img }" alt="" />
									</div>
									<div class="back">
										<table class="">
											<tbody>
											<c:forEach items ="${dsmonan }" var="food">
											<c:if test="${food.loaiMenu.idloai==loai.idloai }">
												<tr>
													<td>${food.ten_Mon_An }</td>
												</tr>
												</c:if>
												</c:forEach>											
											</tbody>
										</table>
									</div>
									
								</div>
							</div>
						</div>
						</c:forEach>
					</div>

					<div class="tab-pane fade" id="pills-contact" role="tabpanel"
						aria-labelledby="pills-contact-tab">
						<div class="content_body-header">
							<h2>
								ĐỒ UỐNG <span>//Áp dụng các ngày trong tuần</span>
							</h2>
						</div>
						<c:forEach items ="${drink}" var="loai">
						<div class="content_body-menu l-5">
							<h3>${loai.tenLoai }</h3>
							<div class="flip-card">
								<div class="flip-card-inner">
									<div class="front">
										<img src="./views/assets/imgs/${loai.img }" alt="" />
									</div>
									<div class="back">
										<table class="">
											<tbody>
											<c:forEach items ="${dsmonan }" var="food">
											<c:if test="${food.loaiMenu.idloai==loai.idloai }">
												<tr>
													<td>${food.ten_Mon_An }</td>
												</tr>
												</c:if>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						</c:forEach>
					</div>
				</div>
			</div>

		</div>

		<!--modal login, regis start-->
		<jsp:include page="Login.jsp"></jsp:include>

		<!--modal forgot pass start-->
		<jsp:include page="ForgotPassword.jsp"></jsp:include>

	</div>

	<jsp:include page="FooterKhachHang.jsp"></jsp:include>

	<script src="./views/assets/js/register.js"></script>
	<script>
		var myCarousel = document.querySelector('#myCarousel')
		var carousel = new bootstrap.Carousel(myCarousel, {
			interval : 1000,
			wrap : false
		})

		var triggerTabList = [].slice.call(document
				.querySelectorAll('#myTab button'))
		triggerTabList.forEach(function(triggerEl) {
			var tabTrigger = new bootstrap.Tab(triggerEl)

			triggerEl.addEventListener('click', function(event) {
				event.preventDefault()
				tabTrigger.show()
			})
		})
	</script>

	<script src="./views/assets/js/login.js"></script>
	<script src="./views/assets/js/navbar.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script src="./views/assets/js/onclickLogin.js"></script>
</body>

</html>