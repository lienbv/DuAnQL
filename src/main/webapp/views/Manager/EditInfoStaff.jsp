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
    <title>Chỉnh sửa thông tin của ${staff.username}</title>
    <link rel="stylesheet" href="./views/Manager/css/base.css">
    <link rel="stylesheet" href="./views/Manager/css/editinfostaff.css">
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
                    <h4 style=" margin-top: 10px;">CHỈNH SỬA THÔNG TIN</h4>
                </div>
            </div>
            <div class="container_right_body">
                <div class="body_left l-3"></div>
                <div class="right_body l-9">
                    <div class="right_body--header"></div>
                    <div class="right_body--content">
                        <form action="UpdateAccManager" method="post">
                            <div class="mb-3">
                                <input type="image" src="${staff.img}" style="width: 250px; height: 230px;" class="form-control" id="exampleImg">
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputImg" class="form-label">CHỌN ẢNH ĐẠI DIỆN</label>
                                <input required type="file" class="form-control" id="exampleInputImg"
                                    onchange="return fileValid()" name="anhdaidien">
                                <label for="" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputID" class="form-label">ID NHÂN VIÊN</label>
                                <input readonly type="text" class="form-control"
                                    id="exampleInputID" name="id" value="${staff.idnv}">
                                <label for="" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputUserName" class="form-label">USER NAME</label>
                                <input readonly type="text" class="form-control"
                                    id="exampleInputUserName" name="username" value="${staff.username}">
                                <label for="" id="usernameHelp" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPass" class="form-label">PASSWORD</label>
                                <input readonly type="password" class="form-control"
                                    id="exampleInputPass" name="password" value="${staff.password}">
                                <label for="" id="passHelp" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputName" class="form-label">HỌ VÀ TÊN</label>
                                <input onkeyup="checkFormName()" required type="text" class="form-control"
                                    id="exampleInputName" name="fullname" value="${staff.hoTen}">
                                <label for="" id="nameHelp" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputPhone" class="form-label">SỐ ĐIỆN THOẠI</label>
                                <input onkeyup="checkFormPhone()" required type="text" class="form-control"
                                    id="exampleInputPhone" name="sodienthoai" value="${staff.sdt}">
                                <label for="" id="phoneHelp" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputEmail" class="form-label">EMAIL</label>
                                <input required type="email" class="form-control"
                                    id="exampleInputEmail" name="email" value="${staff.email}">
                                <label for="" id="emailHelp" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputCCCD" class="form-label">CĂN CƯỚC CÔNG DÂN</label>
                                <input required type="text" class="form-control"
                                    id="exampleInputCCCD" name="cccd" value="${staff.cccd}">
                                <label for="" id="cccdHelp" class="error"></label>
                            </div>
                            <div class="mb-3">
                                <label for="exampleInputRole" class="form-label">CHỨC VỤ</label>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" value="Nhân Viên" name="flexRadioRole"
                                        id="flexRadioRoleStaff" ${staff.chucVu.equalsIgnoreCase("Nhân Viên") ? "checked" : ""}>
                                    <label class="form-check-label" for="flexRadioDefault1">NHÂN VIÊN</label>
                                </div>
                                <div class="form-check">
                                    <input class="form-check-input" type="radio" value="Quản Lý" name="flexRadioRole"
                                        id="flexRadioRoleManager" ${staff.chucVu.equalsIgnoreCase("Quản Lý") ? "checked" : ""}>
                                    <label class="form-check-label" for="flexRadioDefault2">QUẢN LÝ</label>
                                </div>
                            </div>
                            <button type="reset" class="btn btn-secondary" style="margin: 10px;">RESET</button>
                            <button type="submit" class="btn btn-primary" id="btn_save" style="margin: 10px;">SAVE</button>
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
            }
        }

        
        document.getElementById("exampleInputImg").onchange = function () {
            var reader = new FileReader();

            reader.onload = function (e) {
            // get loaded data and render thumbnail.
            document.getElementById("exampleImg").src = e.target.result;
            };

            // read the image file as a data URL.
            reader.readAsDataURL(this.files[0]);
        };
    </script>
    <script src="./views/Manager/js/modaladdnhanvien.js"></script>
    <script src="./views/Manager/js/sidebar.js"></script>
</body>

</html>