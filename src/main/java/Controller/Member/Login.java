package Controller.Member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.Dao_Staff;
import Dao.Daouser;
import Dao.baiVietDao;
import Services.Checkdatebooking;
import model.BaiViet;
import model.KhachHang;
import model.Staff;

@WebServlet("/Login")
@MultipartConfig
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daouser daouser;
	private Dao_Staff daoStaff;
	private Checkdatebooking check;
	private baiVietDao dao;
	public Login() {
		this.daoStaff = new Dao_Staff();
		this.daouser = new Daouser();
		this.check=new Checkdatebooking();
		this.dao=new baiVietDao();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			List<BaiViet> list=dao.getall();
			request.setAttribute("baiviet", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.check.checkdate();
		request.getRequestDispatcher("views/assets/HomeKhachHang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.check.checkdate();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		KhachHang kh = this.daouser.login(username, password);
		Staff st = this.daoStaff.login(username, password);
		
		if (kh != null) {
			this.saveSessionkh(request, kh, username, password);
			showdatenow(request, response);
			response.sendRedirect(request.getContextPath() + "/HomeKhachHangServlet");
		} else {
			if (st != null) {
				if (st.getChucVu().equals("Staff")) {
					saveSessionStaff(request, st, username, password);
					response.sendRedirect(request.getContextPath() + "/HomeStaffController");
				} else if (st.getChucVu().equals("Manager")) {
					saveSessionManager(request, st, username, password);
					response.sendRedirect(request.getContextPath() + "/HomeManager");
				}
			} else {
				response.sendRedirect(request.getContextPath()+"/Login?errorAccWrong=1");
			}

		}

	}
	
	private void saveSessionkh(HttpServletRequest request, KhachHang khach, String username, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("acountKH", khach);
		
		Cookie cookieUserName = new Cookie("userNameCookie", username);
		Cookie cookiePassword = new Cookie("passwordCookie", password);
		
		cookiePassword.setMaxAge(600);
		cookieUserName.setMaxAge(600);
	
	}
	
	private void saveSessionStaff(HttpServletRequest request, Staff staff, String username, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("acountST", staff);
		
		Cookie cookieUserName = new Cookie("userNameCookie", username);
		Cookie cookiePassword = new Cookie("passwordCookie", password);
		System.out.println(cookieUserName);
		
		cookiePassword.setMaxAge(600);
		cookieUserName.setMaxAge(600);
	
	}
	
	private void saveSessionManager(HttpServletRequest request, Staff staff, String username, String password) {
		HttpSession session = request.getSession();
		session.setAttribute("acountMa", staff);
		
		Cookie cookieUserName = new Cookie("userNameCookie", username);
		Cookie cookiePassword = new Cookie("passwordCookie", password);
		
		cookiePassword.setMaxAge(600);
		cookieUserName.setMaxAge(600);
	
	}
	
	private void showdatenow(HttpServletRequest request, HttpServletResponse response) {
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