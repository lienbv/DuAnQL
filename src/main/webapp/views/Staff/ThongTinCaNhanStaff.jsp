<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<%-- //Chưa validate định dạng file kiểu dạng zip  --%>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
<title>Thông tin cá nhân</title>
<link rel="stylesheet" href="./views/Staff/css/base.css">
<link rel="stylesheet" href="./views/Staff/css/thongtincanhanstaff.css">
<link rel="stylesheet" href="./views/Staff/css/grid.css">
<link rel="stylesheet"
	href="./views/Staff/fontawesome-free-5.15.3-web/css/all.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<%
String succes = request.getParameter("succes");
String err = request.getParameter("error");
%>
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
						<ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
							<li class="nav-item1" role="presentation">
								<button class="nav-link active" id="pills-home-tab"
									data-bs-toggle="pill" data-bs-target="#pills-home"
									type="button" role="tab" aria-controls="pills-home"
									aria-selected="true">CẬP NHẬT</button>
							</li>
							<li class="nav-item1" role="presentation">
								<button class="nav-link" id="pills-profile-tab"
									data-bs-toggle="pill" data-bs-target="#pills-profile"
									type="button" role="tab" aria-controls="pills-profile"
									aria-selected="false">ĐỔI MẬT KHẨU</button>
							</li>
						</ul>
						<div class="tab-content" id="pills-tabContent">
							<div class="tab-pane fade show active" id="pills-home"
								role="tabpanel" aria-labelledby="pills-home-tab">

								<div class="changeInfo">
									<h3>Chỉnh sửa thông tin</h3>
									<form action="/Ql_Dat_Ban_NH/ProfileStaff" method="post"
										enctype="multipart/form-data">
										<%
										if ("6".equals(succes)) {
											out.print(
											"<h5 id='alertupdateprofile' style='color: green;' class='form-text text-muted' >Update profile success</h5>");
										}
										%>
										<div class="mb-3">
											<input type="image" src="/QL_Dat_Ban_NH/img/${ staff.img }"
												alt="" style="width: 230px; height: 200px;"
												class="form-control" id="exampleImg">
										</div>
										<div class="mb-3">
											<label for="exampleInputImg" class="form-label">Chọn
												ảnh đại diện</label> <input type="file" class="form-control"
												name="image" id="exampleInputImg" value="${ staff.img }"
												onchange="return fileValid()"> <label for=""
												class="error"></label>
										</div>
										<div class="mb-3">
											<label for="exampleInputFullName1" class="form-label">Họ
												và tên</label> <input required type="text" name="name"
												class="form-control" id="exampleInputFullName1"
												value="${ staff.hoTen }" aria-describedby="emailHelp"
												onchange="checkFormName()"> <label for=""
												id="nameHelp" class="error"></label>
										</div>
										<div class="mb-3">
											<label for="exampleInputPhoneNume1" class="form-label">Số
												điện thoại</label> <input required type="text" name="phone"
												class="form-control" id="exampleInputPhoneNume1"
												value="${ staff.sdt }" aria-describedby="emailHelp"
												onchange="checkFormPhone()"> <label id="phoneHelp"
												for="" class="error"></label>
										</div>
										<div class="mb-3">
											<label for="exampleInputLink" class="form-label">Email</label>
											<input required type="mail" name="email" class="form-control"
												id="exampleInputLink" value="${ staff.email }"
												aria-describedby="emailHelp"> <label for=""
												class="error"></label>
										</div>
										<button type="submit" id="submit2" class="btn btn-success"
											formaction="/QL_Dat_Ban_NH/ProfileStaff/Update_profile_staff?idnv=${staff.idnv }">Submit</button>
									</form>
								</div>

							</div>
							<div class="tab-pane fade" id="pills-profile" role="tabpanel"
								aria-labelledby="pills-profile-tab">

								<div class="changeInfo">
									<h3>ĐỔI MẬT KHẨU</h3>
									<form action="/Ql_Dat_Ban_NH/ProfileStaff" method="post">
										<%
										if ("5".equals(succes)) {
											out.print(
											"<h5 id='alertupdateprofile' style='color: green;' class='form-text text-muted' >Change Password Success</h5>");
										}
										%>
										<div class="mb-3">
											<label for="exampleInputName" class="form-label">Mật
												khẩu cũ</label> <input required type="password" name="pass_cu"
												class="form-control" id="exampleInputName"
												aria-describedby="emailHelp">
											<%
											if ("5".equals(err)) {
												out.print("<small id='alert_user' style='color: red;' class='form-text text-muted' >Password Insuccess</small>");
											}
											%>
											<label for="" class="error"></label>
										</div>
										<div class="mb-3">
											<label for="InputNewPass1" class="form-label">Mật
												khẩu mới</label> <input required type="password" name="pass_moi"
												class="form-control" id="InputNewPass1"
												aria-describedby="emailHelp">
										</div>
										<div class="mb-3">
											<label for="InputNewPass2" class="form-label">Nhập
												lại mật khẩu</label> <input required type="password"
												name="xacnhan_pass" class="form-control" id="InputNewPass2"
												aria-describedby="emailHelp" onkeyup='check();'> <label
												for="" id="newPass2Help" class="error" style="color: red;"></label>
											<label for="" id="newPass2HelpSuc" class="success"
												style="color: green;"></label>
										</div>
										<button type="submit" id="submit1" class="btn btn-success"
											formaction="/QL_Dat_Ban_NH/ProfileStaff/Changepass_staff?idnv=${staff.idnv }">Submit</button>
									</form>
								</div>
							</div>
						</div>
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
	<script src="./views/Staff/js/throwErrorTTCN.js"></script>
	<script src="./views/Staff/js/thongtincanhanstaff.js"></script>
	<script>
		function fileValid() {
			var fileInput = document.getElementById('exampleInputImg');
			var filePath = fileInput.value;
			var allowedExtendsion = /(\.png|\.jpeg|\.jpg)$/i;

			if (!allowedExtendsion.exec(filePath)) {
				alert("Vui lòng nhập định dạng ảnh .png, .jpge, .jpg");
				document.getElementById('exampleInputImg').style.borderColor = "red";
				fileInput.value = '';
				return false;
			} else {
				document.getElementById('exampleInputImg').style.borderColor = "green";
			}
		}

		document.getElementById("exampleInputImg").onchange = function() {
			var reader = new FileReader();

			reader.onload = function(e) {
				// get loaded data and render thumbnail.
				document.getElementById("exampleImg").src = e.target.result;
			};

			// read the image file as a data URL.
			reader.readAsDataURL(this.files[0]);
		};
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>