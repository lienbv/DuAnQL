package Controller.Member;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Dao.DaoTTBD;
import Dao.Daouser;
import Services.UtilsDate;
import model.KhachHang;
import model.ThongTinBanDat;

@WebServlet("/Changebooking")
public class Changebooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoTTBD daottbd;
	private ThongTinBanDat ttbd;
	private KhachHang kh;
	private Daouser daouser;
	private UtilsDate utilsDate;
	private String date;

	public Changebooking() {
		this.daottbd = new DaoTTBD();
		this.ttbd = new ThongTinBanDat();
		this.daouser = new Daouser();
		this.utilsDate = new UtilsDate();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		int index = Integer.parseInt(request.getParameter("index"));
		request.setAttribute("idttdb", index);
		date = request.getParameter("date");
		request.setAttribute("ngay", date);
		this.ttbd = this.daottbd.findbyid(index);
		utilsDate.ngaydat(request);
		utilsDate.giodat(request, date);
		request.setAttribute("show", this.ttbd);
		request.getRequestDispatcher("/views/assets/EditInfoSauDatBan.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("index"));
		this.ttbd = this.daottbd.findbyid(index);
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String sdt = request.getParameter("sdt");
		HttpSession session = request.getSession();
		String ngay = (String) session.getAttribute("date_book");
		this.kh = (KhachHang) session.getAttribute("acountKH");
		if (checkinput(kh, sdt) == true) {
			this.updatemember(request, response, this.kh, index, ngay, sdt);
			this.updatettdb(request, response, index);
			response.sendRedirect(request.getContextPath() + "/Booking?date=" + ngay + "&&successChangeBooking=3");
		} else {
			response.sendRedirect(request.getContextPath() + "/Changebooking?date=" + this.ttbd.getNgayDatBan()
					+ "&&index=" + index + "&&errorChangeBooking=3");
		}

	}

	private void updatettdb(HttpServletRequest request, HttpServletResponse response, int index)
			throws UnsupportedEncodingException {
		String ngaydat = request.getParameter("date");
		String giodat = request.getParameter("timedatban");
		SimpleDateFormat fommat = new SimpleDateFormat("dd/MM/yyyy");
		ThongTinBanDat t=this.daottbd.findbyid(index);
		java.util.Date ngay;
		try {
			ngay = fommat.parse(ngaydat);
			Date date = new Date(ngay.getTime());
			Time time = Time.valueOf(giodat);
			int soluong = Integer.parseInt(request.getParameter("soluong"));
			String note = request.getParameter("note");
			t.setNgayDatBan(date);
			t.setGioDatBan(time);
			System.out.println(note);
			t.setGhi_Chu(note);
			t.setSo_Luong_Nguoi(soluong);
			this.daottbd.update(t);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private void updatemember(HttpServletRequest request, HttpServletResponse response, KhachHang k, int index,
			String ngay, String sdt) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("UTF-8");
		String hoten = request.getParameter("ten");
		k.setSdt(sdt);
		k.setHoTen(hoten);
		this.daouser.update(k);
	}

	private boolean checkinput(KhachHang k, String sdt) {
		List<KhachHang> lst = this.daouser.finduserbysdt(k, sdt);

		if (lst.size() == 0) {
			return true;
		} else {
			return false;
		}

	}

}
