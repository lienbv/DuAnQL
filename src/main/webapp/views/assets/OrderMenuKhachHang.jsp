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
    <title>Order Menu</title>
    <link rel="stylesheet" href="./views/assets/css/ordermenukhachhang.css">
    <link rel="stylesheet" href="./views/assets/css/login.css">
    <link rel="stylesheet" href="./views/assets/css/grid.css">
    <link rel="stylesheet" href="./views/assets/css/base.css">
    <link rel="stylesheet" href="./views/assets/css/forgotpassword.css">
    <link rel="stylesheet" href="./views/assets/responsive/homeR.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    <link rel="stylesheet" href="./fontawesome-free-5.15.3-web/css/all.min.css">

</head>

<body>
    <div id="app">
    
        <jsp:include page="HeaderKhachHang.jsp"></jsp:include>

        <div class="container_content col row l-12">
        
            <div class="content_header">
                <div class="header_tabs">
                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item" role="presentation">
                            <button class="nav-link active" id="pills-home-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-home" type="button" role="tab" aria-controls="pills-home"
                                aria-selected="true">MENU</button>
                        </li>
                        <li class="nav-item" role="presentation">
                            <button class="nav-link" id="pills-profile-tab" data-bs-toggle="pill"
                                data-bs-target="#pills-profile" type="button" role="tab" aria-controls="pills-profile"
                                aria-selected="false">GIỎ HÀNG</button>
                        </li>
                    </ul>
                </div>
            </div>

            <div class="tab-content content_body" id="pills-tabContent">
            
                <div class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                    <div class="">
                    	
                    	<div class="form_content">
                    	<c:forEach items="${listmenu }" var="menu">
                            <div class="body_item l-4">
                            
                                <form action="/QL_Dat_Ban_NH/Order" method="post">
                                    <div class="item_img">
                                        <img src="./views/assets/imgs/${menu.img }" style="width: 300px; height: 250px;" alt="">
                                    </div>
                                    <div class="item_name">${menu.ten_Mon_An }</div>
                                    <div class="item_price" style="font-weight: 500; color: tomato;">${menu.gia } VND</div>
                                    <div class="item_quantity"><input style="width: 80px; margin: 5px 0;" type="number" name="soluong" id="" min="1" value="1"></div>
                                    <div class="item_order">
                                        <button type="submit" formaction="/QL_Dat_Ban_NH/Order/chonmon?idmn=${menu.idmn}" class="btn btn-success">CHỌN MÓN</button>
                                    </div>
                                </form>
                                
                            </div>
						</c:forEach>
                            
                        </div>
						
                    </div>

                </div>
				
                <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">
                <!-- <form action="/QL_Dat_Ban_NH/Order" method="post"> -->
                <form action="/QL_Dat_Ban_NH/Order" method="post">
                    <table class="table">
                        <thead>
                            <tr>
                                <th scope="col">ẢNH SẢN PHẨM</th>
                                <th scope="col">TÊN SẢN PHẨM</th>
                                <th scope="col">PHÂN LOẠI</th>
                                <th scope="col">SỐ LƯỢNG</th>
                                <th scope="col">THÀNH TIỀN</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                        
                        	<c:forEach items="${gh }" var="giohang">
                            <tr>
                                <th><img style="width: 300px; height: 200px; border-radius: 10px;"
                                        src="./views/assets/imgs/${giohang.menu.img }" alt=""></th>
                                <td>${giohang.menu.ten_Mon_An }</td>
                                <td>${giohang.menu.loaiMenu.tenLoai }</td>
                                <td><input type="text" style="width: 100px;" readonly name="" id="" value="${giohang.so_luong }"></td>
                                <td>${giohang.menu.gia*giohang.so_luong}</td>
                                <td>
                                
                                <button formaction="/QL_Dat_Ban_NH/Order/delete?id=${giohang.idgh}" class="btn btn-danger btn-sm"><i class="fas fa-trash-alt"></i></button></td>
                            </tr>
                            </c:forEach>
                            
                        </tbody>
                        <tfoot>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><button formaction="/QL_Dat_Ban_NH/Order/datban" style="float: right;" class="btn btn-success btn-block">GỌI MÓN <i class="fa fa-angle-right"></i></button></td>
                            </tr>
                        </tfoot>
                    </table>
                    </form>
                    <!-- </form> -->
                </div>
			
            </div>
            
        </div>

        <!--modal login, regis start-->
        <jsp:include page="Login.jsp"></jsp:include>

        <!--modal forgot pass start-->
        <jsp:include page="ForgotPassword.jsp"></jsp:include>

	
    </div>

    <jsp:include page="FooterKhachHang.jsp"></jsp:include>

    <script>
        var myCarousel = document.querySelector('#myCarousel')
        var carousel = new bootstrap.Carousel(myCarousel, {
            interval: 1000,
            wrap: false
        })

        var triggerTabList = [].slice.call(document.querySelectorAll('#myTab button'))
        triggerTabList.forEach(function (triggerEl) {
            var tabTrigger = new bootstrap.Tab(triggerEl)

            triggerEl.addEventListener('click', function (event) {
                event.preventDefault()
                tabTrigger.show()
            })
        })

    </script>
    <script>
    function showMessage(id){
        var option = confirm('Bạn có muốn xóa món ăn đã chọn hay không?');
        if(option){
            window.location.href = '/QL_Dat_Ban_NH/Deletefood?id='+id;
        }
    }
    </script>
    <script src="./views/assets/js/login.js"></script>
    <script src="./views/assets/js/navbar.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    <script src="./views/assets/js/onclickLogin.js"></script>
</body>

</html>