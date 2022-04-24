
<%@page import="model.Bdct"%>
<%@page import="Dao.Daobdct"%>
<%@page import="model.ThongTinBanDat"%>
<%@page import="java.util.List"%>
<%@page import="Dao.DaoTTBD"%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="./views/assets/imgs/logo.jpg" type="image/x-icon">
    <title>Thống kê bàn đặt</title>
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
                    <h4 style=" margin-top: 10px;">THỐNG KÊ BÀN ĐẶT</h4>
                </div>
                <div class="right_body--header">
                <form action="/QL_Dat_Ban_NH/ThongKeBanDat" method="post">
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
                                    <th scope="col">SỐ LƯỢNG BÀN ĐẶT</th>
                                    <th scope="col">Tổng bàn</th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            	int nam = Integer.parseInt(request.getParameter("nam"));
                            	int bd1=0,bd2=0,bd3=0,bd4=0,bd5=0,bd6=0,bd7=0,bd8=0,bd9=0,bd10=0,bd11=0,bd12=0;
                            	int ttban1=0,ttban2=0,ttban3=0,ttban4=0,ttban5=0,ttban6=0,ttban7=0,ttban8=0,ttban9=0,ttban10=0,ttban11=0,ttban12=0;
                            	DaoTTBD daottbd=new DaoTTBD();
                            	Daobdct daobdct = new Daobdct();
                            	List<ThongTinBanDat> lsttbd=daottbd.thongKe(nam);
                            	List<Bdct> lstbdct = daobdct.getall();
                            	Calendar c;
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan()); 
                            		if(c.getTime().getMonth()+1==1){
                            			bd1+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban1+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 1</th>  <td>"+bd1+"</td>  <td>"+ttban1+"</td> <tr>");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==2){
                            			bd2+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban2+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 2</th> <td>"+bd2+"</td> <td>"+ttban2+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==3){
                            			bd3+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban3+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 3</th> <td>"+bd3+"</td> <td>"+ttban3+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==4){
                            			bd4+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban4+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 4</th> <td>"+bd4+"</td> <td>"+ttban4+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==5){
                            			bd5+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban5+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 5</th> <td>"+bd5+"</td> <td>"+ttban5+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==6){
                            			bd6+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban6+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 6</th> <td>"+bd6+"</td> <td>"+ttban6+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==7){
                            			bd7+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban7+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 7</th> <td>"+bd7+"</td> <td>"+ttban7+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==8){
                            			bd8+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban8+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 8</th> <td>"+bd8+"</td> <td>"+ttban8+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==9){
                            			bd9+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban9+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 9</th> <td>"+bd9+"</td> <td>"+ttban9+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==10){
                            			bd10+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban10+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 10</th> <td>"+bd10+"</td> <td>"+ttban10+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==11){
                            			bd11+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban11+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 11</th> <td>"+bd11+"</td> <td>"+ttban11+"</td> <tr> ");
                            	for(int i =0; i < lsttbd.size(); i++){
                            		c = Calendar.getInstance();
                            		c.setTime(lsttbd.get(i).getNgayDatBan());
                            		if(c.getTime().getMonth()+1==12){
                            			bd12+=1;
                            			for(int j = 0; j < lstbdct.size(); j++){
                            			 	if(lstbdct.get(j).getThongTinBanDat().getIdBd() == lsttbd.get(i).getIdBd()){
                            			 		ttban12+=1;
                            			 	}
                            			}
                            		}
                            	}
                            	out.print("<tr> <th scope='row'>Tháng 12</th> <td>"+bd12+"</td> <td>"+ttban12+"</td> <tr> ");
                            	int sumban = ttban1+ttban2+ttban3+ttban4+ttban5+ttban6+ttban7+ttban8+ttban9+ttban10+ttban11+ttban12;
                            	out.print("<tr>");
                            	out.print("<th colspan='2'>Tổng</th>");
                            	out.print("<th style='color: tomato; font-size: 20px;' id='sum'>"+sumban+"</th>");
                            	out.print("<tr>");
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
                'title': 'Thống kê bàn đặt',
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