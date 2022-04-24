package Controller.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Daouser;
import Services.Create_RandomString;
import Services.EncryptUtil;
import model.Email;
import model.KhachHang;
import net.bytebuddy.utility.RandomString;
import utils.EmailUtils;

@WebServlet("/ForgotpasswordServlet")
public class ForgotpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daouser dao;

	public ForgotpasswordServlet() {
		this.dao = new Daouser();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("views/assets/HomeKhachHang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<KhachHang> list = new ArrayList<KhachHang>();
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			list = dao.findEmail(username, emailAddress);
			if (list != null) {
				Create_RandomString random = new Create_RandomString();
				String pass = random.generateRandomString();
				String hash = EncryptUtil.hashPassword(pass);
				KhachHang kh = list.get(0);
				kh.setPassword(hash);
				this.dao.update(kh);
				Email gmail = new Email();
				gmail.setFrom("lienptph16568@fpt.edu.vn");
				gmail.setFrompassword("Lien2002");
				gmail.setTo(emailAddress);
				gmail.setSubject("Mail Forgot Password of " + username);
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username).append(" ");
				sb.append("you are the forgot password and this is my password. ");
				sb.append("Your password is: ").append(pass);
				gmail.setContent(sb.toString());
				EmailUtils.send(gmail);
				response.sendRedirect(request.getContextPath() + "/ForgotpasswordServlet" + "?successforgotpass=1");

			} else {
				response.sendRedirect(request.getContextPath() + "/HomeKhachHangServlet" + "?errorforgotpass=1");
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect(request.getContextPath() + "/HomeKhachHangServlet" + "?errorforgotpass=1");
		}

	}
}
