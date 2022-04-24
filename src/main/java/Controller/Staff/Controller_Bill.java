package Controller.Staff;

import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoHDCT;
import Dao.DaoHoadon;
import Dao.DaoTTBD;
import Services.WriteExcel;
import Services.WritePDF;
import model.Hdct;
import model.HoaDon;
import model.KhachHang;
import model.Staff;
import model.ThongTinBanDat;

@WebServlet({ "/Controller_Bill", "/Controller_Bill/inHD", "/Controller_Bill/Back", "/Controller_Bill/pay" })
public class Controller_Bill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DaoHoadon dao_HD;
	private HoaDon hd;
	private List<Hdct> listHDCT;
	private DaoHDCT dao_HDCT;
	private WriteExcel writeExcel;
	private ThongTinBanDat ttbd;
	private DaoTTBD daottbd;
	private WritePDF pdf;

	public Controller_Bill() {
		this.dao_HD = new DaoHoadon();
		this.hd = new HoaDon();
		this.listHDCT = new ArrayList<Hdct>();
		this.dao_HDCT = new DaoHDCT();
		this.writeExcel = new WriteExcel();
		this.ttbd=new ThongTinBanDat();
		this.daottbd=new DaoTTBD();
		this.pdf = new WritePDF();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//this.hd = this.dao_HD.sortIDbyHD();
		int idhd=Integer.parseInt(request.getParameter("idhd"));
		this.hd=this.dao_HD.findbyid(idhd);
		request.setAttribute("hoa_don", this.hd);
		ThongTinBanDat ttbd = this.hd.getThongTinBanDat();
		int idBD = ttbd.getIdBd();
		request.setAttribute("idBD", idBD);

		Time timeBD = ttbd.getGioDatBan();
		request.setAttribute("timeBD", timeBD);

		int idHD = this.hd.getIdhd() + 1;
		request.setAttribute("idHD", idHD);

		Date timeKT = hd.getThoi_gian();
		request.setAttribute("timeKT", timeKT);

		KhachHang kh = this.hd.getKhachHang();
		String name = kh.getHoTen();
		request.setAttribute("name", name);
		this.listHDCT = this.dao_HDCT.findhdctbyidhd(this.hd);
		double sum = 0;
		for(Hdct x:listHDCT) {
			sum+=x.getThanh_Tien();
		}
		request.setAttribute("sum", sum);
		request.setAttribute("hdct", this.listHDCT);
		
		int in= daottbd.count();
		request.setAttribute("sl", in);
		int ttdem= daottbd.counttthd();
		request.setAttribute("tt", ttdem);
		
		request.getRequestDispatcher("/views/Staff/ThongTinHoaDon.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();
		int idhd=Integer.parseInt(request.getParameter("idhd"));
		this.hd=this.dao_HD.findbyid(idhd);
		if (url.contains("inHD")) {
			this.pdf.exportPDF(response,idhd);
			//doGet(request, response);
			// response.sendRedirect(request.getContextPath() + "/Controller_Bill");	
		} else if (url.contains("Back")) {
			response.sendRedirect(request.getContextPath() + "/Lienhe");
		} else if (url.contains("pay")) {
			updatehd(request, response, this.hd);
			this.writeExcel.exportExcel(response,idhd);	
		}
	}

	private void updatehd(HttpServletRequest request, HttpServletResponse response,HoaDon h) throws IOException {
		this.ttbd=this.daottbd.findbyid(h.getThongTinBanDat().getIdBd());
		this.ttbd.setTrang_Thai("Paid");
		this.daottbd.update(ttbd);
		float km=Float.parseFloat(request.getParameter("khuyen_mai"));
		HttpSession session = request.getSession();
		Staff staff = (Staff) session.getAttribute("acountST");
		long millis=System.currentTimeMillis();   
		java.sql.Date date=new java.sql.Date(millis);
		h.setThoi_gian(date);
		h.setStaff(staff);
		h.setKhuyen_mai(km);
		this.listHDCT=this.dao_HDCT.findhdctbyidhd(h);
		float tongtien=0;
		for(Hdct x:listHDCT) {
			tongtien+=x.getThanh_Tien();
		}
		h.setTong_Tien(tongtien-tongtien*km/100);
		this.dao_HD.update(h);
		response.sendRedirect(request.getContextPath()+"/HomeStaffController?SuccsesBill=5");
	}
}
