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
<title>Tình trạng bàn</title>
<link rel="stylesheet" href="./views/Staff/css/base.css">
<link rel="stylesheet" href="./views/Staff/css/quanlybandatstaff.css">
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
				<div class="right_header">
					<div class="header_search">
						<form action="" method="post">
							<input type="search" name="" id="" placeholder="Nhập mã bàn...">
							<button type="button" class="btn btn-dark">
								<svg xmlns="http://www.w3.org/2000/svg" style="color: white;"
									width="16" height="16" fill="currentColor" class="bi bi-search"
									viewBox="0 0 16 16">
                                    <path
										d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                                </svg>
								TÌM KIẾM
							</button>
						</form>
					</div>
				</div>
				<div class="container_right_body l-12">
					<div class="body_left l-3"></div>
					<div class="body_right l-9">
						<div class="body_right--info">
							<div class="info--confirm">
								<label for="exampleColorInput" class="form-label">Bàn đã
									xác nhận</label> <input disabled type="color"
									class="form-control form-control-color" id="exampleColorInput"
									value="#0d6efd" title="Choose your color">
							</div>
							<div class="info--confirm">
								<label for="exampleColorInput" class="form-label">Bàn
									Trống</label> <input disabled type="color"
									class="form-control form-control-color" id="exampleColorInput"
									value="#ffc107" title="Choose your color">
							</div>
							<div class="info--confirm">
								<label for="exampleColorInput" class="form-label">Bàn đã
									có khách</label> <input disabled type="color"
									class="form-control form-control-color" id="exampleColorInput"
									value="#adb5bd" title="Choose your color">
							</div>
						</div>
						
						<!--bàn đang có khách start-->
						<div class="body_right--table">
							<c:forEach items="${lstactive }" var="tableactive">
								<div class="content_button l-5">
										<button type="button" class="btn btn-secondary buttonTable">
											Bàn ${tableactive.IDBan} <br> Số người: ${tableactive.loaiBan}
										</button>
								</div>
							</c:forEach>
						</div>
						<!--bàn đang có khác end-->
						
						<!--bàn đã xác nhận start-->
						
						<div class="body_right--table">
							<c:forEach items="${lstcf }" var="tablecf">
								<div class="content_button l-5">
									<button type="button" class="btn btn-primary buttonTable">
										Bàn ${tablecf.IDBan} <br> Số người: ${tablecf.loaiBan}
									</button>
							</div>
							</c:forEach>
						</div>
						<!--bàn đã xác nhận end-->

						<!--bàn đã chưa xác nhận start-->
						<div class="body_right--table">
							<c:forEach items="${lstempty }" var="tableempty">
								<div class="content_button l-5">
										<button type="button" class="btn btn-warning buttonTable">
											Bàn ${tableempty.IDBan} <br> Số người: ${tableempty.loaiBan}
										</button>
								</div>
							</c:forEach>
						</div>
						<!--bàn chưa xác nhận end-->

						
					</div>
				</div>
			</div>
		</div>

	</div>

	<div class="container_footer" style="text-align: center;">
        <hr>
        <p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
    </div>
	<script src="./views/Staff/js/sidebar.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>