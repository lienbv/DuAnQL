package Controller.Staff;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoCart;
import Dao.DaoTTBD;
import Dao.Daobdct;
import Dao.Daottban;
import Services.UtilsDate;
import model.Bdct;
import model.GioHang;
import model.ThongTinBanDat;
import model.TtBan;

@WebServlet({ "/Confirmbooking", "/Confirmbooking/Create", "/Confirmbooking/Update" })
public class Confirmbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoTTBD daottbd;
	private ThongTinBanDat ttbd;
	private Daottban daottban;
	private List<GioHang> lstgh;
	private DaoCart daocart;
	private TtBan ttban;
	private Bdct bdct;
	private Daobdct daobdct;
	private List<Bdct> lstbdct;
	private UtilsDate utilsDate;
	private DaoTTBD daottb;

	public Confirmbooking() {
		this.daottbd = new DaoTTBD();
		this.ttbd = new ThongTinBanDat();
		this.daottban = new Daottban();
		this.daocart = new DaoCart();
		this.ttban = new TtBan();
		this.bdct = new Bdct();
		this.daobdct = new Daobdct();
		this.lstbdct = new ArrayList<Bdct>();
		this.utilsDate = new UtilsDate();
		this.daottb = new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int index = Integer.parseInt(request.getParameter("index"));
		int status = Integer.parseInt(request.getParameter("status"));
		this.ttbd = this.daottbd.findbyid(index);
		String ngay = request.getParameter("date");
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			java.util.Date d = format1.parse(ngay);
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String ngayd = format.format(d);
			this.utilsDate.giodat(request, ngayd);
			this.utilsDate.ngaydat(request);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("ngay", ngay);
		if (status == 2) {
			List<Bdct> lst = this.daobdct.findbdctbyttbd(this.ttbd);
			request.setAttribute("Confirmed", lst);
		}
		request.setAttribute("status", status);

		showemptytable(request, response);
		showcardbyidkh(request, response, this.ttbd);
		showdatenow(request, response, this.ttbd);
		request.setAttribute("infor", this.ttbd);
		int in = daottb.count();
		request.setAttribute("sl", in);
		int ttdem = daottb.counttthd();
		request.setAttribute("tt", ttdem);
		request.getRequestDispatcher("/views/Staff/DetailConfirmBan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		int index = Integer.parseInt(request.getParameter("index"));
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		this.ttbd = this.daottbd.findbyid(index);
		if (url.contains("Create")) {
			updatettbd(request, response, this.ttbd);
			confirm_booking(request, response, this.ttbd);
		} else if (url.contains("Update")) {
			updatettbd(request, response, this.ttbd);
			updatettbdbyconfirmed(request, response, this.ttbd);
			confirm_booking(request, response, this.ttbd);
		}
	}

	// Hiá»ƒn thá»‹ táº¥t cáº£ cÃ¡c bÃ n Ä‘ang trá»‘ng
	private void showemptytable(HttpServletRequest request, HttpServletResponse response) {
		List<TtBan> lstemptytable = this.daottban.showemptytable();
		request.setAttribute("ban_trong", lstemptytable);
	}

	// Hiá»ƒn thá»‹ giá»� hÃ ng theo khÃ¡ch hÃ ng
	private void showcardbyidkh(HttpServletRequest request, HttpServletResponse response, ThongTinBanDat t) {
		this.lstgh = this.daocart.FindCartbyIDDB(t);
		request.setAttribute("dsgiohang", this.lstgh);
	}

	// táº¡o bÃ n Ä‘áº·t chi tiáº¿t
	private void confirm_booking(HttpServletRequest request, HttpServletResponse response, ThongTinBanDat t)
			throws IOException {
		String[] lstb = request.getParameterValues("checkboxbandat");
		if(lstb != null) {
			for (String x : lstb) {
				this.bdct.setThongTinBanDat(t);
				this.ttban = this.daottban.findbyid(Integer.parseInt(x));
				this.bdct.setTtBan(ttban);
				//lstbdct.add(new Bdct(0, ttban, t));
				this.daobdct.insert(new Bdct(0, ttban, t));
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/Notification");
	}

	// thay Ä‘á»•i tráº¡ng thÃ¡i cá»§a thÃ´ng tin bÃ n Ä‘áº·t;
	private void updatettbd(HttpServletRequest request, HttpServletResponse response, ThongTinBanDat t) {
		t.setTrang_Thai("Confirmed");
		String ngaydat = request.getParameter("date");
		String giodat = request.getParameter("timedatban");
		int soluong = Integer.parseInt(request.getParameter("so_luong"));
		SimpleDateFormat fommat = new SimpleDateFormat("dd/MM/yyyy");
		java.util.Date ngay;
		try {
			ngay = fommat.parse(ngaydat);
			Date date = new Date(ngay.getTime());
			t.setNgayDatBan(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Time time = Time.valueOf(giodat);
		String note = request.getParameter("Note");

		t.setGioDatBan(time);
		t.setGhi_Chu(note);
		t.setSo_Luong_Nguoi(soluong);
		this.daottbd.update(t);
	}

	private void updatettbdbyconfirmed(HttpServletRequest request, HttpServletResponse response, ThongTinBanDat t) {
		
		this.daobdct.deletelichdat(t);

	}

	private void showdatenow(HttpServletRequest request, HttpServletResponse response, ThongTinBanDat t) {
		HttpSession session = request.getSession();
		Calendar c = Calendar.getInstance();
		SimpleDateFormat fommat = new SimpleDateFormat("dd/MM/yyyy");
		c.setTime(t.getNgayDatBan());
		String date1 = fommat.format(c.getTime());
		session.setAttribute("date_book", date1);

	}
}
