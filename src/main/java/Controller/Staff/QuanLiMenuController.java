package Controller.Staff;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoBanDatCT;
import Dao.DaoHoadon;
import Dao.DaoTTBD;
import model.Bdct;
import model.HoaDon;
import model.Staff;
import model.ThongTinBanDat;

@WebServlet({ 
	"/QuanLiMenuController",
	"/QuanLiMenuController/bdct" ,
	"/QuanLiMenuController/Confirm"
})
public class QuanLiMenuController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Bdct bdct;
	private DaoBanDatCT daobdct;
	private DaoTTBD daottbd;
	private ThongTinBanDat ttbd;
	private HoaDon hd;
	private DaoHoadon daohd;
	public QuanLiMenuController() {
		bdct = new Bdct();
		daobdct = new DaoBanDatCT();
		this.ttbd=new ThongTinBanDat();
		this.daobdct=new DaoBanDatCT();
		this.hd=new HoaDon();
		this.daohd=new DaoHoadon();
		this.daottbd= new DaoTTBD();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idttbd=Integer.parseInt(request.getParameter("id"));
		this.ttbd=this.daottbd.findbyid(idttbd);
		request.setAttribute("ttbd", this.ttbd);
		List<Bdct> lstBDCT = daobdct.findTTBD(this.ttbd);
		request.setAttribute("ListBDCT", lstBDCT);
		this.hd=this.daohd.findHDbyIDkh(ttbd);
		request.setAttribute("hd", this.hd);
		int index = daobdct.count(ttbd);
		request.setAttribute("bv", index);
		
		int in= daottbd.count();
		request.setAttribute("sl", in);
		int ttdem= daottbd.counttthd();
		request.setAttribute("tt", ttdem);
		
		request.getRequestDispatcher("/views/Staff/QuanLyMenuStaff.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		
		if(url.contains("Confirm")) {
			int idttbd=Integer.parseInt(request.getParameter("id"));
			this.ttbd=this.daottbd.findbyid(idttbd);
			this.ttbd.setTrang_Thai("Active");
			this.daottbd.update(ttbd);
			HoaDon hd1= new HoaDon();
		    hd1.setKhachHang(this.ttbd.getKhachHang());
			hd1.setKhuyen_mai(0);	
			HttpSession session = request.getSession();
			Staff staff = (Staff) session.getAttribute("acountST");
			hd1.setStaff(staff);
			hd1.setThongTinBanDat(this.ttbd);
			long millis=System.currentTimeMillis();   
			java.sql.Date date=new java.sql.Date(millis);
			hd1.setThoi_gian(date);
			hd1.setTong_Tien(0);
			this.daohd.insert(hd1);
			response.sendRedirect(request.getContextPath()+"/QuanLiMenuController?id="+idttbd);
			
		}else if(url.contains("bdct")) {
			int idbd = Integer.parseInt(request.getParameter("idbdct"));
			int idhd=Integer.parseInt(request.getParameter("idhd"));
			this.bdct = this.daobdct.findbyid(idbd);
			response.sendRedirect(request.getContextPath() + "/menuCTController?id=" + idbd+"&&idhd="+idhd);
		}
		
	}

}