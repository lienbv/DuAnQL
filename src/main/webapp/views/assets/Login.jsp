
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--modal login, regis start-->
<%
String err = request.getParameter("error");
String succes = request.getParameter("succes");
%>

<div class="modal-login js-modal-login">
	<div class="modal-login_container js-modal-login_container">
		<div class="container" id="container">
			<div class="form-container sign-up-container">
				<form action="/QL_Dat_Ban_NH/SignUp" method="post">
					<i class="fas fa-times btn-close"></i>
					<h1>Create Account</h1>
					<input name="user" type="text" minlength="5" maxlength="15" required placeholder="User name" style="padding: 12px 15px; margin: 4px 0;" />
					<%
					if ("1".equals(err)) {
						out.print(
						"<small id='alert_user' style='color: red;' class='form-text text-muted' >Account already exists</small>");
					}
					%>
					<input name = "password" minlength="5" type="password"  maxlength="15" required placeholder="Password" id="pass" style="padding: 12px 15px; margin: 4px 0;" />
                    <input type="password" minlength="5" maxlength="15" required placeholder="Repeat Password" id="repeatPass" onchange="checkPass();" style="padding: 12px 15px; margin: 4px 0;" />
					<input name="hoten" minlength="5" maxlength="30" type="text" id="exampleInputFullName1" required placeholder="Full name" style="padding: 12px 15px; margin: 4px 0;" onchange="checkFormName()" /> 
					<input name="sdt" type="text" id="exampleInputPhoneNume1" required placeholder="Phone number" style="padding: 12px 15px; margin: 4px 0;" onchange="checkFormPhone()" /> 
					<input name="gmail" type="email" required placeholder="Email" style="padding: 12px 15px; margin: 4px 0;" />
					<button id="button" style="border-radius: 20px;">Sign Up</button>
				</form>
			</div>
			
			<div class="form-container sign-in-container">
				<form action="/QL_Dat_Ban_NH/Login" method="POST"
					enctype="multipart/form-data">
					<i class="fas fa-times btn-close2"
						style="margin-top: -30px; z-index: 1;"></i>
					<h1>Sign in</h1>
					<%
					if ("1".equals(succes)) {
						out.print("<h5 id='alert_succes' style='color: green;' class='form-text text-muted' >Sign Up Success</h5>");
					}
					%>
					<div class="social-container">
						<a
							href="https://www.facebook.com/dialog/oauth?client_id=1036349233816178&redirect_uri=http://localhost:8080/QL_Dat_Ban_NH/login-facebook"
							class="social"><i class="fab fa-facebook-f"></i></a> <a
							href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/QL_Dat_Ban_NH/login-google&response_type=code&client_id=1054660386439-6eqgbps8p3uv61ejhifnmqsd3jap54mt.apps.googleusercontent.com&approval_prompt=force"
							class="social"><i class="fab fa-google-plus-g"></i></a> <a
							href="#" class="social"><i class="fab fa-linkedin-in"></i></a>
					</div>
					<span>or use your account</span> <input type="text" required
						placeholder="User name" id="username" name="username"
						style="padding: 12px 15px; margin: 8px 0;" /> <span class="error"></span>
					<input type="password" required placeholder="Password"
						id="password" name="password"
						style="padding: 12px 15px; margin: 8px 0;" /> <span class="error">${ message}</span>
					<a type="button" class="btn_forgot" href="#">Forgot your
						password?</a>
					<button type="Submit" style="border-radius: 20px;">Sign In</button>
				</form>
			</div>
			<div class="overlay-container">
				<div class="overlay">
					<div class="overlay-panel overlay-left">
						<h1>Welcome Back!</h1>
						<p>To keep connected with us please login with your personal
							info</p>
						<button class="ghost" id="signIn" style="border-radius: 20px;">Sign
							In</button>
					</div>
					<div class="overlay-panel overlay-right">
						<h1>Hello, Friend!</h1>
						<p>Enter your personal details and start journey with us</p>
						<button class="ghost" id="signUp" style="border-radius: 20px;">Sign
							Up</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>