
<%@page import="java.util.ArrayList"%>
<%@page import="model.Menu"%>
<%@page import="Dao.DaoMenu"%>
<%@page import="model.Hdct"%>
<%@page import="Dao.DaoHDCT"%>
<%@page import="model.HoaDon"%>
<%@page import="java.util.List"%>
<%@page import="Dao.DaoHoadon"%>
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
<title>Thống kê Menu</title>
<link rel="stylesheet" href="./views/Manager/css/base.css">
<link rel="stylesheet" href="./views/Manager/css/thongkebandat.css">
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
					<h4 style="margin-top: 10px;">THỐNG KÊ MENU</h4>
				</div>
				<div class="right_body--header">
					<form action="/QL_Dat_Ban_NH//ThongKeMenu" method="post">
						<div class="header_search left">
							<select style="width: 200px; float: left; margin-right: 10px;"
								name="yeartk" class="form-select"
								aria-label="Default select example">
								<option selected value="2021">2021</option>
								<option value="2020">2020</option>
								<option value="2019">2019</option>
							</select>
						</div>
						<div class="header_search">
							<button type="submit" class="btn btn-success">Xem thống
								kê</button>
						</div>
					</form>
				</div>
			</div>

			<div class="container_right_body">
				<div class="body_left l-3"></div>
				<div class="right_body l-9">
					<div class="right_body--header-button"></div>
					<div class="right_body--content">
						<table id="t1" class="table" style="text-align: center;">
							<thead>
								<tr>
									<th scope="col">MÃ MÓN</th>
									<th scope="col">SỐ LƯỢNG ORDER</th>
									<th scope="col">TỔNG TIỀN</th>
								</tr>
							</thead>
							<tbody>
								<%
								int nam = Integer.parseInt(request.getParameter("nam"));
								int sl = 0;
								double gia = 0;
								DaoHoadon daohd = new DaoHoadon();
								List<HoaDon> lstHD = daohd.thongKe(nam);
								DaoHDCT daohdct = new DaoHDCT();
								List<Hdct> lstHdct = new ArrayList();
								List<Hdct> lstHdct1 = new ArrayList();
								for (int i = 0; i < lstHD.size(); i++) {
									lstHdct.addAll(daohdct.findhdctbyidhd(lstHD.get(i)));
								}
								DaoMenu daomn = new DaoMenu();
								List<Menu> lstmenu = daomn.getall();
								for (Menu m : lstmenu) {
									for (Hdct h : lstHdct) {

										if (h.getMnct().getMenu().getIdmn() == m.getIdmn()) {
									sl += h.getSo_luong();
									gia += h.getThanh_Tien();
										}
									}
									lstHdct1.add(new Hdct(m.getIdmn(), sl, gia));
									sl = 0;
									gia = 0;
								}
								for (Hdct hdct1 : lstHdct1) {
									if (hdct1.getSo_luong() != 0) {
										gia += hdct1.getThanh_Tien();
										out.print("<tr>");
										out.print("<td>" + hdct1.getIdHdct() + "</td>");
										out.print("<td>" + hdct1.getSo_luong() + "</td>");
										out.print("<td>" + hdct1.getThanh_Tien() + "</td>");
										out.print("</tr>");
									}
								}
								out.print("<tr>");
								out.print(" <th colspan='2'>Tổng</th>");
								out.print("<th style='color: tomato; font-size: 20px;' id='sum'>" + String.format("%.10f", gia) + "</th>");
								out.print("</tr>");
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>

		<!--modal biểu đồ-->
		<div class="modal_chart js_modal_chart">
			<div class="modal_chart--container js_modal_chart--container">
				<svg style="float: right;" class="exit js_btn-close"
					xmlns="http://www.w3.org/2000/svg" width="26" height="26"
					fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
                    <path
						d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z" />
                </svg>
				<div id="piechart_3d" style="width: 740px; height: 530px;"></div>
			</div>
		</div>
	</div>

	<script type="text/javascript"
		src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="./views/Manager/js/modalChart.js"></script>
	<script src="./views/Manager/js/sidebar.js"></script>
</body>

</html>