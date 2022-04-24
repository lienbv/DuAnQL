<%@page import="model.Hdct"%>
<%@page import="Dao.DaoHDCT"%>
<%@page import="java.util.Calendar"%>
<%@page import="model.HoaDon"%>
<%@page import="java.util.List"%>
<%@page import="Dao.DaoHoadon"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Thống kê hóa đơn</title>
    <link rel="stylesheet" href="./views/Manager/css/base.css">
    <link rel="stylesheet" href="./views/Manager/css/thongkebandat.css">
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
                    <h4 style=" margin-top: 10px;">THỐNG KÊ HÓA ĐƠN</h4>
                </div>
                <div class="right_body--header">
                <form action="/QL_Dat_Ban_NH/ThongKeHoaDon" method="post">
                    <div class="header_search">
                        <select style="width: 200px; float: left; margin-right: 10px;" name="yeartk" class="form-select" aria-label="Default select example">
                            <option selected value="2021">2021</option>
                            <option value="2020">2020</option>
                            <option value="2019">2019</option>
                        </select>
                        <button type="submit" class="btn btn-success">Xem thống kê</button>
                    </div>
                    </form>
                </div>
            </div>

            <div class="container_right_body">
                <div class="body_left l-3"></div>
                <div class="right_body l-9">
                    <div class="right_body--header-button">
                    </div>
                    <div class="right_body--content">
                        <table id="t1" class="table" style="text-align: center;">
                            <thead>
                                <tr>
                                    <th scope="col">THÁNG</th>
                                    <th scope="col">SỐ HÓA ĐƠN</th>
                                    <th scope="col">TỔNG TIỀN</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            	int nam = Integer.parseInt(request.getParameter("nam"));
                            	int shd1=0,shd2=0,shd3=0,shd4=0,shd5=0,shd6=0,shd7=0,shd8=0,shd9=0,shd10=0,shd11=0,shd12=0;
                            	double tt1=0,tt2=0,tt3=0,tt4=0,tt5=0,tt6=0,tt7=0,tt8=0,tt9=0,tt10=0,tt11=0,tt12=0;
                            	DaoHoadon daohd = new DaoHoadon();
                            	List<HoaDon> lsthd = daohd.thongKe(nam);
                            	DaoHDCT daohdct = new DaoHDCT();
                            	List<Hdct> lsthdct = daohdct.getall();
                            	Calendar c;
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 1){
                            			shd1+=1;
										tt1 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 1</th> <td>"+shd1+"</td> <td>"+tt1+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 2){
                            			shd2+=1;
										tt2 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 2</th> <td>"+shd2+"</td> <td>"+tt2+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 3){
                            			shd3+=1;
										tt3 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 3</th> <td>"+shd3+"</td> <td>"+tt3+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 4){
                            			shd4+=1;
										tt4 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 4</th> <td>"+shd4+"</td> <td>"+tt4+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 5){
                            			shd5+=1;
										tt5 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 5</th> <td>"+shd5+"</td> <td>"+tt5+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 6){
                            			shd6+=1;
										tt6 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 6</th> <td>"+shd6+"</td> <td>"+tt6+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 7){
                            			shd7+=1;
										tt7 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 7</th> <td>"+shd7+"</td> <td>"+tt7+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 8){
                            			shd8+=1;
										tt8 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 8</th> <td>"+shd8+"</td> <td>"+tt8+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 9){
                            			shd9+=1;
										tt9 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 9</th> <td>"+shd9+"</td> <td>"+tt9+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 10){
                            			shd10+=1;
										tt10 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 10</th> <td>"+shd10+"</td> <td>"+tt10+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 11){
                            			shd11+=1;
										tt11 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 11</th> <td>"+shd11+"</td> <td>"+tt11+"</td> <tr>");
                            	for(int i = 0; i < lsthd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsthd.get(i).getThoi_gian());
                            		if(c.getTime().getMonth()+1 == 12){
                            			shd12+=1;
										tt12 = lsthdct.get(i).getSo_luong()* lsthdct.get(i).getThanh_Tien();
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 12</th> <td>"+shd12+"</td> <td>"+tt12+"</td> <tr>");
                            	double sum = tt1 + tt2 + tt3 + tt4 + tt5 + tt6 + tt7 + tt8 + tt9 + tt10 + tt11 + tt12;
                            	out.print("<tr>");
                            	out.print("<th colspan='2'>Tổng</th>");
                            	out.print("<th style='color: tomato; font-size: 20px;' id='sum'>"+sum+"</th>");
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
                <svg style="float: right;" class="exit js_btn-close" xmlns="http://www.w3.org/2000/svg" width="26"
                    height="26" fill="currentColor" class="bi bi-x-circle-fill" viewBox="0 0 16 16">
                    <path
                        d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM5.354 4.646a.5.5 0 1 0-.708.708L7.293 8l-2.647 2.646a.5.5 0 0 0 .708.708L8 8.707l2.646 2.647a.5.5 0 0 0 .708-.708L8.707 8l2.647-2.646a.5.5 0 0 0-.708-.708L8 7.293 5.354 4.646z" />
                </svg>
                <div id="piechart_3d" style="width: 740px; height: 530px;"></div>
            </div>
        </div>
    </div>

    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">

        // Load the Visualization API and the corechart package.
        google.charts.load('current', { 'packages': ['corechart'] });

        // Set a callback to run when the Google Visualization API is loaded.
        google.charts.setOnLoadCallback(drawChart);

        // Callback that creates and populates a data table,
        // instantiates the pie chart, passes in the data and
        // draws it.
        function drawChart() {

            // Create the data table.
            var data = new google.visualization.DataTable();
            data.addColumn('string', 'Topping');
            data.addColumn('number', 'Slices');
            data.addRows([
                ['Tháng 1', 200],
                ['Tháng 2', 100],
                ['Tháng 3', 223],
                ['Tháng 4', 199],
                ['Tháng 5', 40],
                ['Tháng 6', 45],
                ['Tháng 7', 55],
                ['Tháng 8', 60],
                ['Tháng 9', 110],
                ['Tháng 10', 80],
                ['Tháng 11', 30],
                ['Tháng 12', 80]
            ]);

            // Set chart options
            var options = {
                'title': 'Thống kê hóa đơn',
                width: 740,
                height: 530,
                is3D: true
            };

            // Instantiate and draw our chart, passing in some options.
            var chart = new google.visualization.PieChart(document.getElementById('piechart_3d'));
            chart.draw(data, options);
        }
    </script>
    <script src="./views/Manager/js/modalChart.js"></script>
    <script src="./views/Manager/js/sidebar.js"></script>
</body>

</html>