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
<title>Quản lý bàn</title>
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
					<h4 style="margin-top: 10px;">QUẢN LÝ BÀN</h4>
				</div>

			</div>
			<div class="container_right_body">
				<div class="body_left l-3"></div>
				<div class="right_body l-9">
					<div class="right_body--header">
						<div class="header_button">
							<button type="button" class="btn btn-success js-modal-btn">
								<svg xmlns="http://www.w3.org/2000/svg" width="25" height="25"
									fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                    <path fill-rule="evenodd"
										d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
                                </svg>
								THÊM MỚI
							</button>
						</div>

						<div class="header_search">

						</div>


					</div>
					<form action="/QL_Dat_Ban_NH/ThembanManager">
						<div class="right_body--content">
							<c:forEach var="items" items="${listBan }">
								<div class="content_item">
									<div class="item--img">
										<img src="./views/assets/imgs/ban.jpg" style="width: 298px; height: 240px;" alt="">
									</div>
									<div class="item--title">
										<h5>Bàn ${items.loaiBan } người</h5>
									</div>
									<div class="item_button">
										<a class="btn btn-success" type="button" 
											 href="/QL_Dat_Ban_NH/UpdateBanManager?id=${items.IDBan}">
											<svg xmlns="http://www.w3.org/2000/svg" width="16"
												height="16" fill="currentColor" class="bi bi-pen-fill"
												viewBox="0 0 16 16">
                                        <path
													d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z" />
                                    </svg>
										</a>
									</div>
								</div>
							</c:forEach>
						</div>
					</form>
				</div>
			</div>

		</div>

		<div class="modal_add js_modal_add">
			<div class="modal_add_container js_modal_add_container">
				<h3>THÊM BÀN MỚI</h3>
				<form action="/QL_Dat_Ban_NH/ThembanManager" method="post">
					<!-- <div class="mb-3">
                        <label for="exampleInputQuantity" class="form-label">ID BÀN</label>
                        <input onkeyup="checkNumber()" required type="number" min="1" class="form-control" id="exampleInputQuantity">
                        <label for="" id="quantityHelp" style="color: tomato;"></label>
                    </div> -->
					<div class="mb-3">
						<label for="exampleInputPhone" class="form-label">LOẠI BÀN</label>
						<select class="form-select" aria-label="Default select example"
							name="loaiban" id="loaiban">
							<option selected value="2">Bàn 2 người</option>
							<option value="4">Bàn 4 người</option>
							<option value="6">Bàn 6 người</option>
							<option value="8">Bàn 8 người</option>
						</select>
					</div>

					<button type="submit" class="btn btn-primary"
						formaction="/QL_Dat_Ban_NH/ThembanManager/create"
						style="margin: 10px;">SAVE</button>
					<button type="button" class="btn btn-danger js_btn-close"
						style="margin: 10px;">Exit</button>
				</form>
			</div>
		</div>
	</div>

	<script src="./views/Manager/js/modaladdnhanvien.js"></script>
	<script src="./views/Manager/js/throwError.js"></script>
	<script src="./views/Manager/js/sidebar.js"></script>
	<script>
    function showMess(id){
        var ques=confirm('Do you want to delete?');
		if(ques){
			alert('delete succsessfull');
			window.location.href='/QL_Dat_Ban_NH/DeleteBanManager?id='+id;
		}
    }
    function chon(loai) {
    	/* var loaiban=document.getElementById('ban'+loai).value; */
    	 var value = loai.value;
    	if(value==2){
    		
    	}
	}
    </script>
</body>

</html>