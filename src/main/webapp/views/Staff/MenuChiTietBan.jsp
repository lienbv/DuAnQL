
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
<title>Update Menu Chi tiết bàn ${bd.thongTinBanDat.idBd}</title>
<link rel="stylesheet" href="./views/Staff/css/base.css">
<link rel="stylesheet" href="./views/Staff/css/menuchitietban.css">
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
				<a href="/QL_Dat_Ban_NH/QuanLiMenuController?id=${bd.thongTinBanDat.idBd}" type="button" class="btn btn-secondary">
                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M15 8a.5.5 0 0 0-.5-.5H2.707l3.147-3.146a.5.5 0 1 0-.708-.708l-4 4a.5.5 0 0 0 0 .708l4 4a.5.5 0 0 0 .708-.708L2.707 8.5H14.5A.5.5 0 0 0 15 8z"/>
                            </svg>
                        </a>
					<div class="header_search">
						<h3 style="color: white;">Thông tin menu chi tiết bàn
							${bd.ttBan.IDBan}</h3>
					</div>
				</div>

				<div class="container_right_body l-12">
					<div class="body_left l-3"></div>
					<div class="body_right l-9">
						<form action="/QL_Dat_Ban_NH/menuCTController" method="post">
							<div class="body_right_content">
								<table class="table" style="text-align: center;">
									<thead>
										<tr>
											<th scope="col">MÃ MÓN</th>
											<th scope="col">TÊN MÓN</th>
											<th scope="col">SỐ LƯỢNG</th>
											<th scope="col">ĐƠN GIÁ</th>
											<th scope="col">SỐ LƯỢNG ĐÃ LÊN</th>
											<th scope="col">THAO TÁC</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listMNCT }" var="mn">
											<c:forEach items="${listHDCT }" var="hd">
												<c:if test="${mn.getIdMnct()==hd.getMnct().getIdMnct() }">
													<form action="/QL_Dat_Ban_NH/Update_MenuCT" method="post">
													<tr>
														<td>${ hd.getMnct().getMenu().getIdmn() }</td>
														<td>${ hd.getMnct().getMenu().getTen_Mon_An()}</td>
														<td>
															<button type="button" class="btnPM" id="btnMinus1"
																onclick="onclickMinus1(${hd.getMnct().idMnct })">
																<svg xmlns="http://www.w3.org/2000/svg" width="16"
																	height="16" fill="currentColor" class="bi bi-dash-lg"
																	viewBox="0 0 16 16">
                                                    <path
																		fill-rule="evenodd"
																		d="M2 8a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11A.5.5 0 0 1 2 8Z" />
                                                </svg>
															</button> <input type="text" name="spinner" min="1"
															id="spinner1${hd.getMnct().idMnct}"
															value="${ hd.getMnct().getSo_luong()}" class="spinner">
															<button type="button" class="btnPM" id="btnPlus1"
																onclick="onclickPlus1(${hd.getMnct().idMnct })">
																<svg xmlns="http://www.w3.org/2000/svg" width="16"
																	height="16" fill="currentColor" class="bi bi-plus-lg"
																	viewBox="0 0 16 16">
                                                    <path
																		fill-rule="evenodd"
																		d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
                                                </svg>
															</button>
														</td>
														<td>${ hd.getMnct().getMenu().getGia()}</td>
														<td>
															<button type="button" class="btnPM" id="btnMinus2"
																onclick="onclickMinus2(${hd.idHdct})">
																<svg xmlns="http://www.w3.org/2000/svg" width="16"
																	height="16" fill="currentColor" class="bi bi-dash-lg"
																	viewBox="0 0 16 16">
                                                    <path
																		fill-rule="evenodd"
																		d="M2 8a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11A.5.5 0 0 1 2 8Z" />
                                                </svg>
															</button> <input type="text" name="spinnerr" min="1"
															id="spinner2${hd.idHdct}" value="${ hd.getSo_luong()}"
															onkeyup="checkSo(${hd.getMnct().idMnct}, ${hd.idHdct})" class="spinner">
															<button type="button" class="btnPM" id="btnPlus2"
																onclick="onclickPlus2(${hd.idHdct})">
																<svg xmlns="http://www.w3.org/2000/svg" width="16"
																	height="16" fill="currentColor" class="bi bi-plus-lg"
																	viewBox="0 0 16 16">
                                                    <path
																		fill-rule="evenodd"
																		d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z" />
                                                </svg>
															</button>
														</td>
														<td>

															<button type="submit" id="btnS" class="btn btn-primary"
																formaction="/QL_Dat_Ban_NH/Update_MenuCT?idmenuCT=${hd.getMnct().idMnct}&&idbcct=${bd.idBdct}&&idHDCT=${hd.idHdct}&&idhd=${idhd}">Xác
																nhận</button>
														</td>
													</tr>
													</form>
												</c:if>

											</c:forEach>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="body_right_footer">
									<button type="submit" class="btn btn-success"
									formaction="/QL_Dat_Ban_NH/menuCTController/create?id=${bd.idBdct}&&idhd=${idhd}">Chọn
									thêm món</button>
							</div>
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
    
	<script src="./views/Staff/js/throwErrorStaffThemMon.js"></script>
	<script>
		function onclickMinus1(num) {
			var sl = document.getElementById('spinner1' + num).value;
			sl--;
			document.getElementById('spinner1' + num).value = sl;
			if (sl < 1) {
				document.getElementById('btnMinus1' + num).disabled = true;
			} else {
				document.getElementById('btnMinus1' + num).disabled = false;
			}
			console.log(sl);
		}

		function onclickPlus1(num) {
			var sl = document.getElementById('spinner1' + num).value;
			sl++;
			document.getElementById('spinner1' + num).value = sl;
			if (sl > 0) {
				document.getElementById('btnMinus1' + num).disabled = false;
			}
			console.log(sl);
		}

		function onclickMinus2(num) {
			var sl = document.getElementById('spinner2' + num).value;
			sl--;
			document.getElementById('spinner2' + num).value = sl;
			if (sl < 1) {
				document.getElementById('btnMinus2' + num).disabled = true;
			} else {
				document.getElementById('btnMinus2' + num).disabled = false;
			}
		}

		function onclickPlus2(num) {
			var sl = document.getElementById('spinner2' + num).value;
			sl++;
			document.getElementById('spinner2' + num).value = sl;
			if (sl > 0) {
				document.getElementById('btnMinus2' + num).disabled = false;
			}
		}

		function checkSo(num1, num2) {
			var cot1 = document.getElementById('spinner1' + num1).value;
			var cot2 = document.getElementById('spinner2' + num2).value;
			if (cot2 > cot1) {
				alert("Số lượng đã lên vượt quá Số lượng đồ ăn đang có");
				document.getElementById('btnPlus2' + num).disabled = true;
			} else {
				document.getElementById('btnPlus2' + num).disabled = false;
			}
		}
	</script>

	<script src="./views/Staff/js/sidebar.js"></script>
</body>

</html>