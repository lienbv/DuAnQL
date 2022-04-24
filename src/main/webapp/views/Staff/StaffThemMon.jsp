<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<!--kiểm tra số lượng của thêm món  -->
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
<title>Thêm món</title>
<link rel="stylesheet" href="./views/Staff/css/staffthemmon.css">
<link rel="stylesheet" href="./views/Staff/css/base.css">
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
				<a href="/QL_Dat_Ban_NH/menuCTController?id=${idbdct}&&idhd=${idhd}" type="button" class="btn btn-secondary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                            </svg>
                        </a>
					<div class="header_search"></div>
				</div>

				<div class="container_right_body l-12">
					<div class="body_left l-3"></div>
					<div class="body_right l-9">
						<div class="body_right-header">
						<!-- <form action="/QL_Dat_Ban_NH/SeacherMenuStaff" method="post"> -->
							<div class="body_right-header-search">
								<input  type="search" name="txt" 
									id="search_menu" value="${txtS }"
									placeholder="Nhập món ăn muốn tìm kiếm...">
								<a type="button" onclick="searchmenu(${idbdct},${idhd })"  class="btn btn-dark">
									<svg xmlns="http://www.w3.org/2000/svg" style="color: white;"
										width="16" height="16" fill="currentColor"
										class="bi bi-search" viewBox="0 0 16 16">
                                            <path
											d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                                        </svg>
									TÌM KIẾM
								</a>

							</div>
							<!-- </form> -->
							<div class="body_right-header-info">
								<h4>Bàn ${ bdct.idBdct}</h4>
							</div>
						</div>
						<c:forEach items="${monan }" var="items">
						<form action="/QL_Dat_Ban_NH/AddMenuCTController" method="post">
								
										<div class="body_right-content--item l-3">
											<div class="item_img">
												<img src="./views/assets/imgs/${items.img}" alt="" name="img"
													width="250" height="250">
											</div>
											<div class="item_title">
												<p>${items.ten_Mon_An }</p>
											</div>
												<input type="number" min="1" name="s_l" id="s_l" >
												<button type="submit" class="btn btn-primary"
													formaction="/QL_Dat_Ban_NH/AddMenuCTController?idmn=${items.idmn }&&idhd=${idhd}&&id=${idbdct}">
													Thêm món</button> 
													
										</div>
						
								</form>
								</c:forEach>

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
	<script src="./views/Staff/js/throwErrorStaffThemMon.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>

	<script>

		function searchmenu(idbdct,idhd) {
			var tim= document.getElementById('search_menu').value; 
			window.location.href='/QL_Dat_Ban_NH/SeacherMenuStaff?id='+idbdct+"&&idhd="+idhd+"&&search="+tim;
			 
		}
			
	</script>
</body>

</html>