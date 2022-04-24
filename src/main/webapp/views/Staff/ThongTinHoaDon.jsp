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
<title>Thông tin hóa đơn</title>
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
	<style type="text/css">
		body{
    		counter-reset: section;
		}
		th::before{
    		counter-increment: section;
    		content: counter(section);
		}
	</style>
</head>

<body>
	<form action="/QL_Dat_Ban_NH/Controller_Bill" method="post">
		<div id="app">
			<div class="container-fluid">

				<!-- side bar -->
				<jsp:include page="Sidebar.jsp"></jsp:include>

				<div class="container_right l-12">
					<div class="right_header">
						<div class="header_search"></div>
					</div>

					<div class="container_right_body l-12">
						<div class="body_left l-3"></div>
						<div class="body_right l-9">
							<div class="body_right_content">
								<div class="content_thanhtoan">
									<h4>Thông tin hóa đơn</h4>
									<div class="container_body">
										<div class="mb-3 row">
											<label for="staticEmail" class="col-sm-2 col-form-label"
												style="font-weight: 500;">Mã bàn:</label>
											<div class="col-sm-10">
												<input type="text" readonly class="form-control-plaintext"
													id="staticEmail" value="Bàn ${idBD }">
											</div>
										</div>
										<div class="mb-3 row">
											<label for="inputPassword" class="col-sm-2 col-form-label"
												style="font-weight: 500;">Số hóa đơn:</label>
											<div class="col-sm-10">
												<input type="text" readonly class="form-control-plaintext"
													id="staticEmail" value="${idHD }">
											</div>
										</div>
										<div class="mb-3 row">
											<label for="staticEmail" class="col-sm-2 col-form-label"
												style="font-weight: 500;">Khách hàng:</label>
											<div class="col-sm-10">
												<input type="text" readonly class="form-control-plaintext"
													id="staticEmail" value="${name }">
											</div>
										</div>
										<div class="mb-3 row">
											<label for="inputPassword" class="col-sm-2 col-form-label"
												style="font-weight: 500;">Giờ vào:</label>
											<div class="col-sm-10">
												<input type="text" readonly class="form-control-plaintext"
													id="staticEmail" value="${timeBD }">
											</div>
										</div>
										<div class="mb-3 row">
											<label for="staticEmail" class="col-sm-2 col-form-label"
												style="font-weight: 500;">Giờ ra:</label>
											<div class="col-sm-10">
												<input type="text" readonly class="form-control-plaintext"
													id="staticEmail" value="${timeKT }">
											</div>
										</div>
										<!--table menu-->
										<table class=" table table-danger" style="text-align: center;">
											<thead>
												<tr>
													<td style="font-weight: bold;" scope="col">STT</td>
													<td style="font-weight: bold;" scope="col">TÊN MÓN</td>
													<td style="font-weight: bold;" scope="col">ĐƠN GIÁ</td>
													<td style="font-weight: bold;" scope="col">SỐ LƯỢNG</td>
													<td style="font-weight: bold;" scope="col">THÀNH TIỀN</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${ hdct}" var="hdct">
													<tr>

														<th scope="row"></th>
														<td>${hdct.mnct.menu.ten_Mon_An }</td>
														<td>${hdct.mnct.menu.gia }</td>
														<td>${hdct.so_luong }</td>
														<td>${hdct.thanh_Tien }</td>
													</tr>
												</c:forEach>
											</tbody>
											<tfoot>
												<tr>
													<th></th>
													<td style="font-weight: bold;" colspan="3">Tổng tiền</th>
													<td>${sum }</td>
												</tr>
											</tfoot>
										</table>

										<!--phuong thuc thanh toan-->
										<select class="form-select"
											aria-label="Default select example"
											style="margin-bottom: 15px;">
											<option selected>Chọn phương thức thanh toán</option>
											<option value="tien_mat">Trả bằng tiền mặt</option>
											<option value="chuyen_khoan">Chuyển khoản</option>
											<option value="quet_the">Trả bằng thẻ</option>
										</select>
										<div class="mb-3 row">
											<label for="staticEmail" class="col-sm-2 col-form-label">Số
												tiền phải thu</label>
											<div class="col-sm-10">
												<input readonly type="text" class="form-control"
													id="tienthu" value="${sum }">
											</div>
										</div>
										<div class="mb-3 row">
											<label for="inputPassword" class="col-sm-2 col-form-label">Voucher</label>
											<div class="col-sm-10">
												<input type="text" class="form-control"
													id="voucher" name="khuyen_mai" value="0.0" >
											</div>
										</div>
										<div class="mb-3 row">
											<label for="staticEmail" class="col-sm-2 col-form-label">Số
												tiền khách đưa</label>
											<div class="col-sm-10">
												<input type="text" required class="form-control"
													onkeyup="calculate()" id="khachdua" value="">
											</div>
										</div>
										<div class="mb-3 row">
											<label for="inputPassword" class="col-sm-2 col-form-label">Số
												tiền thừa</label>
											<div class="col-sm-10">
												<input readonly required type="text" class="form-control"
													id="tienthua" value="">
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="body_right_footer">
								<button type="submit" class="btn btn-success"
									formaction="/QL_Dat_Ban_NH/Controller_Bill/inHD?idhd=${hoa_don.idhd }">In hóa đơn</button>
								<button type="submit" class="btn btn-warning" formaction="/QL_Dat_Ban_NH/Controller_Bill/pay?idhd=${hoa_don.idhd }" >Thanh toán</button>
								<button type="submit" class="btn btn-light" formaction="/QL_Dat_Ban_NH/Controller_Bill/pay?idhd=${hoa_don.idhd }">Quay Lại</button>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</form>
	
	<div class="container_footer" style="text-align: center;">
        <hr>
        <p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
    </div>
	<script src="./views/Staff/js/sidebar.js"></script>
	<script>
		function calculate() {
			var tienhoadon = document.getElementById('tienthu').value;
			var tienthu = document.getElementById('khachdua').value;
			var voucher = document.getElementById('voucher').value;
			var result = 0.0;
			if (voucher > 0) {
				result = parseFloat(tienthu)
						- (parseFloat(tienhoadon) - (parseFloat(tienhoadon) * (voucher / 100)));
			} else {
				result = parseFloat(tienthu) - parseFloat(tienhoadon);
			}
			document.getElementById('tienthua').value = result;
		}
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>

</html>