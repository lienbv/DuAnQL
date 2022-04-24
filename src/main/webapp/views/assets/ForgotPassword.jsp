<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!--modal forgot pass start-->
<div class="modal-forgot" style="z-index: 10;">
	<div class="modal-forgot_container">
		<div class="container-center">
			<%
			String err = request.getParameter("error");
			if ("1".equals(err)) {
				out.print("<h5 style=\"color: red;\">username or email error </h5>");
			}
			%>
			<%
			String success = request.getParameter("success");
			if ("1".equals(success)) {
				out.print("<h5 style=\"color: red;\">username or email success </h5>");
			}
			%>
			<i class="fas fa-times closeFG"></i>

			<form action="/QL_Dat_Ban_NH/ForgotpasswordServlet" method="POST">
				<h4>
					Just provide your email<br> and we can do the rest
				</h4>
				<formgroup> <input type="email" name="email" required /> <label
					for="email"><br>Email</label> <span>enter your email</span> </formgroup>

				<formgroup> <input type="text" name="username" required /> <label
					for="username"><br>User Name</label> <span>enter your
					user name</span> </formgroup>
				<button id="login-btn">Next</button>
			</form>
		</div>
	</div>
</div>