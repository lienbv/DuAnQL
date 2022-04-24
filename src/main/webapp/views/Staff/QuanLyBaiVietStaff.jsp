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
    <title>Quản lý bài viết</title>
    <link rel="stylesheet" href="./views/Staff/css/base.css">
    <link rel="stylesheet" href="./views/Staff/css/quanlybaiviet.css">
    <link rel="stylesheet" href="./views/Staff/css/addPost.css">
    <link rel="stylesheet" href="./views/Staff/css/grid.css">
    <link rel="stylesheet" href="./views/Staff/fontawesome-free-5.15.3-web/css/all.min.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>

<body>
    <div id="app">
        <div class="container-fluid">
            <!-- side bar -->
			<jsp:include page="Sidebar.jsp"></jsp:include>
			
            <div class="container_right l-12">
            	<!-- header right quản lý bài viết -->
                <jsp:include page="HeaderRightPost.jsp"></jsp:include>
                <form action="/QL_Dat_Ban_NH/HomeStaffController" method="post">
                <div class="right_body">
                <c:forEach var="items" items="${ listBV }">
                       <div class="body_item">
                        <img src="./views/assets/imgs/${items.img }" style="width: 298px; height: 240px;" alt="">
                        <p style=" margin-top: 10px; font-size: 20px; font-weight: 500;">${items.ten_tieu_de }</p>
                        <p>${items.noi_dung }</p>
                        <div class="service-item">
                            <h3><a target="_blank" href="${items.link }">
                                    Xem ngay</a></h3>
                        </div>
                        <div class="item_button">
                            <button type="submit" class="btn btn-success" formaction="/QL_Dat_Ban_NH/HomeStaffController/update?id=${ items.IDbv }">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pen-fill" viewBox="0 0 16 16">
                                    <path d="m13.498.795.149-.149a1.207 1.207 0 1 1 1.707 1.708l-.149.148a1.5 1.5 0 0 1-.059 2.059L4.854 14.854a.5.5 0 0 1-.233.131l-4 1a.5.5 0 0 1-.606-.606l1-4a.5.5 0 0 1 .131-.232l9.642-9.642a.5.5 0 0 0-.642.056L6.854 4.854a.5.5 0 1 1-.708-.708L9.44.854A1.5 1.5 0 0 1 11.5.796a1.5 1.5 0 0 1 1.998-.001z"/>
                                </svg>
                                
                            </button>
                            <button type="button" class="btn btn-danger" onclick="showMess(${ items.IDbv})" >
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                    <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z"/>
                                </svg>
                            </button>
                        </div>
                    </div>
                </c:forEach>
                </div>
                   </form>
            </div>
        </div>
		<!-- modal add bài viết -->
        <jsp:include page="ModalAddPost.jsp"></jsp:include>
        
    </div>
    
    <div class="container_footer" style="text-align: center;">
        <hr>
        <p>Copyright © 2021 Team One. Powered by HaiNguyen</p>
    </div>

    <script src="./views/Staff/js/modaladdpost.js"></script>
    <script src="./views/Staff/js/throwErrorQuanLyBaiViet.js"></script>
    <script src="./views/Staff/js/sidebar.js"></script>
    	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function showMess(id){
            var ques = confirm('Do you want to delete?');
			if(ques == true){
				window.location.href='/QL_Dat_Ban_NH/DeleteBaiViet?id='+id;
			} else {
				
			}
        }

        function fileValid(){
            var fileInput = document.getElementById('exampleInputImg');
            var filePath = fileInput.value;
            var allowedExtendsion = /(\.png|\.jpeg|\.jpg)$/i;

            if(!allowedExtendsion.exec(filePath)){
                alert("Vui lòng nhập định dạng ảnh .png, .jpge, .jpg");
                document.getElementById('exampleInputImg').style.borderColor = "red";
                fileInput.value = '';
                return false;
            } else {
                document.getElementById('exampleInputImg').style.borderColor = "green";
            }
        }

    </script>
</body>

</html>