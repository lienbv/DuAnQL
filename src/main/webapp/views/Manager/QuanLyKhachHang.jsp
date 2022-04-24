<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Thông tin khách hàng</title>
    <link rel="stylesheet" href="./views/Manager/css/base.css">
    <link rel="stylesheet" href="./views/Manager/css/quanlykhachhang.css">
    <link rel="stylesheet" href="./views/Manager/css/grid.css">
    <link rel="stylesheet" href="./views/assets/fontawesome-free-5.15.3-web/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <div id="app">
        <div class="container-fluid">

            <jsp:include page="SideBarManager.jsp"></jsp:include>

            <div class="container_right l-12">

                <div class="right_header" style="color: white; font-size: 18px;">
                    <h4 style=" margin-top: 10px;">QUẢN LÝ KHÁCH HÀNG</h4>
                </div>

            </div>
            <div class="container_right_body">
                <div class="body_left l-3"></div>
                <div class="right_body l-9">
                    <div class="right_body--header">
                        <div class="header_search">
                            <form action="FindAccMember" method="post">
                                <input type="search" name="txt" id="" value="${search}" placeholder="Nhập tên khách hàng">
                                <button type="button" class="btn btn-dark">
                                    <svg xmlns="http://www.w3.org/2000/svg" style="color: white;" width="16" height="16"
                                        fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                                        <path
                                            d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z" />
                                    </svg>
                                    TÌM KIẾM
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="right_body--content">
                        <table class="table" style="text-align: center;">
                            <thead>
                                <tr>
                                    <th scope="col">MÃ KHÁCH HÀNG</th>
                                    <th scope="col">HỌ VÀ TÊN</th>
                                    <th scope="col">SỐ ĐIỆN THOẠI</th>
                                    <th scope="col">GMAIL</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach items = "${lstMem}" var = "o">
                            	<tr>
                                    <td scope="row">${o.idkh }</td>
                                    <td>${o.hoTen}</td>
                                    <td>${o.sdt}</td>
                                    <td>${o.gmail}</td>
                                </tr>
                            </c:forEach>
                                
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

        </div>

    </div>

    <div class="container_footer" style="text-align: center;">
        <hr>
        <p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
    </div>
    <script src="./views/Manager/js/sidebar.js"></script>
</body>

</html>