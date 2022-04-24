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
<title>Document</title>
<link rel="stylesheet" href="./views/Staff/css/base.css">
<link rel="stylesheet" href="./views/Staff/css/viewmenustaff.css">
<link rel="stylesheet" href="./views/Staff/css/grid.css">
<link rel="stylesheet"
	href="./views/Staff/fontawesome-free-5.15.3-web/css/all.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>
	<div id="app">
		<div class="container-fluid">

			<!-- side bar -->
			<jsp:include page="Sidebar.jsp"></jsp:include>

			<div class="container_right l-12">
				<div class="right_header"></div>

				<div class="container_right_body l-12">
					<div class="body_left l-3"></div>
					<div class="body_right l-9">
						<div class="body_right--header">
							<h3>Menu</h3>
							<div class="header_search">
							</div>
						</div>
						<div class="body_right--content">
							<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
								<li class="nav-item1" role="presentation">
									<button class="nav-link active" id="pills-home-tab"
										data-bs-toggle="pill" data-bs-target="#pills-home"
										type="button" role="tab" aria-controls="pills-home"
										aria-selected="true">Hải sản</button>
								</li>
								<li class="nav-item1" role="presentation">
									<button class="nav-link" id="pills-profile-tab"
										data-bs-toggle="pill" data-bs-target="#pills-profile"
										type="button" role="tab" aria-controls="pills-profile"
										aria-selected="false">Đồ uống</button>
								</li>
								<li class="nav-item1" role="presentation">
									<button class="nav-link" id="pills-contact-tab"
										data-bs-toggle="pill" data-bs-target="#pills-contact"
										type="button" role="tab" aria-controls="pills-contact"
										aria-selected="false">Buffet</button>
								</li>
								<li class="nav-item1" role="presentation">
									<button class="nav-link" id="pills-contact-tab"
										data-bs-toggle="pill" data-bs-target="#pills-bonus"
										type="button" role="tab" aria-controls="pills-bonus"
										aria-selected="false"></button>
								</li>
							</ul>
							<div class="tab-content" id="pills-tabContent">
								<c:forEach var="loai" items="${buffet }">
									<div class="tab-pane fade show active" id="pills-home"
										role="tabpanel" aria-labelledby="pills-home-tab">
										<div class="content_items--page1">
											<c:forEach var="food" items="${menu }">
												<c:if test="${food.loaiMenu.idloai  == loai.idloai }">
													<div class="page1--item l-3">
														<img src="./views/assets/imgs/${food.img }" alt="">
														<h4>${food.ten_Mon_An  }</h4>
														<p>${food.gia }VND</p>
													</div>
												</c:if>
											</c:forEach>


										</div>
									</div>
								</c:forEach>

								<c:forEach var="loai" items="${douong }">
									<div class="tab-pane fade" id="pills-profile" role="tabpanel"
										aria-labelledby="pills-profile-tab">
										<div class="content_items--page1">
											<c:forEach var="food" items="${menu }">
												<c:if test="${food.loaiMenu.idloai  == loai.idloai }">
													<div class="page1--item l-3">
														<img src="/QL_Dat_Ban_NH/img/${food.img }" alt="">
														<h4>${food.ten_Mon_An  }</h4>
														<p>${food.gia }VND</p>
													</div>
												</c:if>
											</c:forEach>
										</div>
									</div>

								</c:forEach>

								<c:forEach var="loai" items="${haisan }">
									<div class="tab-pane fade" id="pills-contact" role="tabpanel"
										aria-labelledby="pills-contact-tab">
										<div class="content_items--page1">
											<c:forEach var="food" items="${menu }">
												<c:if test="${food.loaiMenu.idloai  == loai.idloai }">
													<div class="page1--item l-3">
														<img src="/QL_Dat_Ban_NH/img/${food.img }" alt="">
														<h4>${food.ten_Mon_An  }</h4>
														<p>${food.gia }VND</p>
													</div>
												</c:if>
											</c:forEach>
										</div>
									</div>
								</c:forEach>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	<script src="./views/Staff/js/sidebar.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>