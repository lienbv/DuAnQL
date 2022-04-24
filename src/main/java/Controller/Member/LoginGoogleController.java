package Controller.Member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Daouser;
import Services.Checkdatebooking;
import accessfacebook.common.GoogleUtils;
import model.GooglePojo;
import model.KhachHang;

@WebServlet("/login-google")
public class LoginGoogleController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daouser serviceKhach;
    private KhachHang khach;
    private Checkdatebooking check;
    public LoginGoogleController() {
    	this.khach=new KhachHang();
    	this.serviceKhach=new Daouser();
    	this.check=new Checkdatebooking();
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		if(code == null || code.isEmpty()) {
			RequestDispatcher dis = request.getRequestDispatcher("/views/assets/HomeKhachHang.jsp");
			dis.forward(request, response);
		} else {
			String accessToken = GoogleUtils.getToken(code);
			GooglePojo googlepojo = GoogleUtils.getUserInfo(accessToken);
			String[] arrname = googlepojo.getEmail().split("@");
			String name = arrname[0];
			if(this.checkAccount(googlepojo.getId()) == false) {
				this.createAccount(googlepojo.getId(), googlepojo.getEmail(), googlepojo.getEmail(), name);
				khach = this.serviceKhach.login_Google(googlepojo.getId(), googlepojo.getEmail());
				if(khach != null) {
					this.saveSession(request, khach, googlepojo.getId(), googlepojo.getEmail());
					response.sendRedirect(request.getContextPath()+"/HomeKhachHangServlet?successGoogle=1");
				} else {
					response.sendRedirect(request.getContextPath()+"/login-google?errorGoogle=1");
				}
			} else {
				khach = this.serviceKhach.login_Google(googlepojo.getId(), googlepojo.getEmail());
				if(khach != null) {
					this.saveSession(request, khach, googlepojo.getId(), googlepojo.getEmail());
					response.sendRedirect(request.getContextPath()+"/HomeKhachHangServlet?successGoogle=1");
				} else {
					response.sendRedirect(request.getContextPath()+"/login-google?errorGoogle=1");
				}
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void createAccount(String username, String password, String gmail, String name) {
		KhachHang khach = new KhachHang();
		this.serviceKhach = new Daouser();
		khach = new KhachHang(0, gmail, name, password, "", username);
		this.serviceKhach.insert(khach);
	}
	
	private boolean checkAccount(String idGmail) {
		if(this.serviceKhach.checkAcc(idGmail) == null) {
			return false;
		} else {
			return true;
		}
	}
	
	private void saveSession(HttpServletRequest request, KhachHang khach, String username, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("acountKH", khach);
		
		Cookie cookieUserName = new Cookie("userNameCookie", username);
		Cookie cookiePassword = new Cookie("passwordCookie", password);
		
		cookiePassword.setMaxAge(600);
		cookieUserName.setMaxAge(600);
		showdatenow(request);
		this.check.checkdate();
	}
	
	private void showdatenow(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Calendar c=Calendar.getInstance();
		SimpleDateFormat fommat=new SimpleDateFormat("dd/MM/yyyy");
		int day=c.get(Calendar.DATE);
		int month=c.get(Calendar.MONTH);
		int year=c.get(Calendar.YEAR);
		c.set(year, month, day);
		String date1=fommat.format(c.getTime());
		session.setAttribute("date_book",date1 );
		
	}
}
