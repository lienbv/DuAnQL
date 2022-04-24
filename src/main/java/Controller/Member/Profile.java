package Controller.Member;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.restfb.types.User;

import Dao.DaoHoadon;
import Dao.DaoTTBD;
import Dao.Daouser;
import Services.EncryptUtil;
import model.HoaDon;
import model.KhachHang;
import model.ThongTinBanDat;

@WebServlet({ "/Profile", "/Profile/Changepass", "/Profile/Updateprofile" })
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Daouser daouser;
	private KhachHang user;
	private DaoTTBD daottbd;
	private DaoHoadon daohd;
	private List<ThongTinBanDat> lstttbd;
	private List<HoaDon> lsthd;

	public Profile() {
		this.daouser = new Daouser();
		this.user = new KhachHang();
		this.lstttbd = new ArrayList<ThongTinBanDat>();
		this.lsthd = new ArrayList<HoaDon>();
		this.daohd = new DaoHoadon();
		this.daottbd = new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		this.user = (KhachHang) session.getAttribute("acountKH");
		int id = this.user.getIdkh();
		request.setAttribute("iduser", id);
		profile(request, response, id);
		request.getRequestDispatcher("/views/assets/QuanLyThongTinMember.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		this.user = (KhachHang) session.getAttribute("acountKH");
		int index = this.user.getIdkh();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String url = request.getRequestURL().toString();
		if (url.contains("Changepass")) {
			String oldpass = request.getParameter("oldpassword");
			String newpass = request.getParameter("newpass");
//			if (oldpass.equals(this.user.getPassword().trim())) {
			if (checkPassword(oldpass, this.user) || oldpass.equals(this.user.getPassword().trim())) {
				this.daouser.changepassworduser(index, newpass);
				response.sendRedirect(request.getContextPath() + "/Profile?successChangePass=1");
			} else {
				response.sendRedirect(request.getContextPath() + "/Profile?errorChangePass=1");
			}
		} else if (url.contains("Updateprofile")) {
			try {
				BeanUtils.populate(this.user, request.getParameterMap());
				this.user.setIdkh(index);
				if (checkinput(user, user.getSdt())) {
					this.user.setIdkh(index);
					this.daouser.updateprofileuser(this.user);
					response.sendRedirect(request.getContextPath() + "/Profile?sucssecUpdateprofile=2");
				} else {
					response.sendRedirect(request.getContextPath() + "/Profile?errorUpdateprofile=2");
				}

			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}

		}
	}

	private void profile(HttpServletRequest request, HttpServletResponse response, int id) {
		this.user = this.daouser.findbyid(id);
		request.setAttribute("profile", this.user);
		profilebooking(request, response, this.user);
	}

	private void profilebooking(HttpServletRequest request, HttpServletResponse response, KhachHang kh) {
		this.lstttbd = this.daottbd.findTTBDbyIDkh(kh);
		request.setAttribute("lstbandat", this.lstttbd);
		hoadon(request, response, kh);
	}

	private void hoadon(HttpServletRequest request, HttpServletResponse response, KhachHang kh) {

		this.lsthd = this.daohd.findHDbyIDkh(kh);
		request.setAttribute("lsthoadon", this.lsthd);
	}

	private boolean checkinput(KhachHang k, String sdt) {
		List<KhachHang> lst = this.daouser.finduserbysdt(k, sdt);

		if (lst.size() == 0) {
			System.out.println(lst.size());
			return true;
		} else {
			System.out.println(lst.size());
			return false;
		}

	}

	private boolean checkPassword(String oldPass, KhachHang user) {
		return EncryptUtil.checkPass(oldPass, user.getPassword());

	}
}
