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
    <title>Chỉnh sửa bài viết ${bv.ten_tieu_de }</title>
    <link rel="stylesheet" href="./views/Staff/css/base.css">
    <link rel="stylesheet" href="./views/Staff/css/editbaiviet.css">
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

				<div class="right_body">
					<div class="body_container">
						<h3>Chỉnh sửa bài viết</h3>

						<form action="/UpdateBaiVietController" method="post"
							enctype="multipart/form-data">

							<div class="mb-3">
								<label for="exampleInputImg" class="form-label">Chọn ảnh
									bài viết</label> <input type="file" accept="image/*"
									class="form-control" id="exampleInputImg"
									onchange="return fileValid()" name="img" value="${bv.img }">
								<img id="output" alt="" src="./views/assets/imgs/${bv.img }"
									width="680" height="510"> <label for="" class="error"></label>
							</div>
							<div class="mb-3">
								<label for="exampleInputTitle" class="form-label">Tiêu
									đề bài viết</label> <input required type="text" class="form-control"
									id="exampleInputTitle" aria-describedby="emailHelp"
									name="tieude" value="${bv.ten_tieu_de }"> <label for=""
									class="error"></label>
							</div>
							<div class="mb-3">
								<div class="form-floating">
									<textarea required class="form-control" maxlength="100"
										name="noidung" placeholder="Tối đa nhập 100 ký tự..."
										id="floatingTextarea2" style="height: 100px; resize: none;">${bv.noi_dung }</textarea>
									<label for="floatingTextarea2">Mô tả</label>
								</div>
								<label for="" class="error txtAreaHelp"></label>
							</div>
							<div class="mb-3">
								<label for="exampleInputLink" class="form-label">Link
									bài viết</label> <input required type="text" class="form-control"
									name="link" id="exampleInputLink" value="${bv.link }"
									aria-describedby="emailHelp">
							</div>
							<button type="submit" class="btn btn-primary"
								formaction="UpdateBaiVietController/update">Submit</button>
						</form>
					</div>
				</div>
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
    <script src="./views/Staff/js/sidebar.js"></script>
    <script>
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
                loadFile();
            }
        }
        
        function loadFile() {
			var output = document.getElementById('output');
			output.src = URL.createObjectURL(event.target.files[0]);
			output.onload = function() {
				URL.revokeObjectURL(output.src)
			}
		};
    </script>
</body>

</html>