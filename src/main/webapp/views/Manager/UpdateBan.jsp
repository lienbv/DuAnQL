<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chỉnh sửa bàn </title>
<link rel="stylesheet" href="./views/Manager/css/base.css">
<link rel="stylesheet" href="./views/Manager/css/quanlyban.css">
<link rel="stylesheet" href="./views/Manager/css/grid.css">
<link rel="stylesheet"
	href="./views/assets/fontawesome-free-5.15.3-web/css/all.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>
	<div id="app">
		<div class="container-fluid">

			<jsp:include page="SideBarManager.jsp"></jsp:include>

			<div class="container_right l-12">

				<div class="right_header" style="color: white; font-size: 18px;">
					<h4 style="margin-top: 10px;">CHỈNH SỬA THÔNG TIN BÀN</h4>
				</div>

			</div>
			<div class="container_right_body">
				<div class="body_left l-3"></div>
				<div class="right_body l-9">
					<div class="right_body--header"></div>
					<div class="right_body--content" style="padding: 30px;">
						<form action="/QL_Dat_Ban_NH/UpdateBanManager" method="post">
							<!--  <div class="mb-3">
                                <label for="exampleInputQuantity" class="form-label">ID BÀN</label>
                                <input onkeyup="checkNumber()" required type="number" min="1" class="form-control" id="exampleInputQuantity">
                                <label for="" id="quantityHelp" style="color: tomato;"></label>
                            </div> -->
							<div class="mb-3">
								<label for="exampleInputPhone" class="form-label">LOẠI
									BÀN</label> <select class="form-select"
									aria-label="Default select example" name="loaiban" id="loaiban">
										<option ${ban.loaiBan==2? "selected":""}  value="2">Bàn 2 người</option>
										<option ${ban.loaiBan==4? "selected":""}  value="4">Bàn 4 người</option>
										<option ${ban.loaiBan==6? "selected":""}  value="6">Bàn 6 người</option>
										<option ${ban.loaiBan==8? "selected":""}  value="8">Bàn 8 người</option>
								</select>
							</div>

							<button type="submit" id="submit" class="btn btn-primary"
								style="margin: 10px;">SAVE</button>
							<button type="button" class="btn btn-danger"
								style="margin: 10px;">Exit</button>
						</form>
					</div>
				</div>
			</div>

		</div>

	</div>

	<div class="container_footer" style="text-align: center;">
		<hr>
		<p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
	</div>
<script src="./views/Manager/js/modaladdnhanvien.js"></script>
	<script src="./views/Manager/js/sidebar.js"></script>

</body>

</html>