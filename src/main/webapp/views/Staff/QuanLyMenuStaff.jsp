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
<title>Quản lý menu</title>
<link rel="stylesheet" href="./views/Staff/css/base.css">
<link rel="stylesheet" href="./views/Staff/css/quanlymenustaff.css">
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

				<form action="/QL_Dat_Ban_NH/BanDat" method="post">
					<div class="right_header">
						<div class="container_right_footer">
						<a href="/QL_Dat_Ban_NH/QuanLiThongTinBan" type="button" class="btn btn-secondary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                            </svg>
                        </a>
						<c:if test="${hd==null }">
							<button type="submit" class="btn btn-success" formaction="/QL_Dat_Ban_NH/QuanLiMenuController/Confirm?id=${ttbd.idBd }">Xác nhận khách đến</button>
						</c:if>
						<c:if test="${hd!=null }">	
							<a type="button" href="/QL_Dat_Ban_NH/Controller_Bill?idhd=${hd.idhd}" class="btn btn-warning">Thanh toán</a>
						</c:if>
						</div>
						<div class="header_search">
							<input oninput="searchByName(this)" type="search" name="txt"
								id="" value="${txtS }"
								placeholder="Nhập mã bàn muốn tìm kiếm...">
							<button type="submit" class="btn btn-dark">
								<svg xmlns="http://www.w3.org/2000/svg" style="color: white;"
									width="16" height="16" fill="currentColor" class="bi bi-search"
									viewBox="0 0 16 16">
                                    <path
										d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                                </svg>
								TÌM KIẾM
							</button>
						</div>
					</div>
				</form>
			</div>
			<form action="/QuanLiMenuController" method="post">
				<div class="container_right_body l-12">
					<div class="body_left l-3"></div>
					<div class="body_right l-9">
						<h3>Số lượng bàn đang sử dụng: ${bv } bàn</h3>
						<c:forEach var="items" items="${ListBDCT }">
							<c:if test="${hd==null }">
								<div class="content_button l-5">
								<a href="">
									<button type="submit" class="btn btn-primary buttonTable"
										formaction="QuanLiMenuController/bdct?idbdct=${items.idBdct} " disabled>
										Bàn ${items.ttBan.IDBan} <br> Loại bàn:
										${items.ttBan.loaiBan}
									</button>
								</a>
							</div>
							</c:if>
							<c:if test="${hd!=null }">
								<div class="content_button l-5">
								<a href="">
									<button type="submit" class="btn btn-primary buttonTable"
										formaction="QuanLiMenuController/bdct?idbdct=${items.idBdct}&&idhd=${hd.idhd } ">
										Bàn ${items.ttBan.IDBan} <br> Loại bàn:
										${items.ttBan.loaiBan}
									</button>
								</a>
							</div>
							</c:if>
							
						</c:forEach>

					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="container_footer" style="text-align: center;">
        <hr>
        <p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
    </div>
	<script src="./views/Staff/js/sidebar.js"></script>
</body>

</html>