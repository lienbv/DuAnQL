package Controller.Staff;

import java.io.IOException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoTTBD;
import Dao.Daobdct;
import Dao.Daouser;
import model.Bdct;
import model.KhachHang;
import model.ThongTinBanDat;

/**
 * Servlet implementation class Notification
 */
@WebServlet({
	"/Notification",
	"/Notification/Create"

})
public class Notification extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Bdct> lstbdct;
	private Daobdct daobdct;
	private DaoTTBD daottbd;
	private Daouser daouser;
    public Notification() {
    	this.daottbd=new DaoTTBD();
    	this.lstbdct=new ArrayList<Bdct>();
    	this.daobdct=new Daobdct();
    	this.daouser=new Daouser();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.lstbdct=this.daobdct.getall();	
		
		showttbdbystatuswl(request, response);
		showttbdbystatuscf(request, response);
		showttbdbystatuscancel(request, response);
		request.setAttribute("ban_dat_chi_tiet", this.lstbdct);
		
		int in= daottbd.count();
		request.setAttribute("sl", in);
		int ttdem= daottbd.counttthd();
		request.setAttribute("tt", ttdem);
		
		request.getRequestDispatcher("/views/Staff/QuanLyThongBao.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url=request.getRequestURL().toString();
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		if(url.contains("Create")) {
			createbd(request, response);
		}
	}

	//hiển thị danh sách bàn đặt có trạng thái là waitting line
	private void showttbdbystatuswl(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<ThongTinBanDat> lst=this.daottbd.showttbdbywl();
			System.out.println(lst.size()+"abc");
			List<ThongTinBanDat> lstwl=new ArrayList<ThongTinBanDat>();
			SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
			for(ThongTinBanDat t:lst) {
				String ngayd=format.format(t.getNgayDatBan());
				lstwl.add(new ThongTinBanDat(t.getIdBd(), ngayd, t.getGioDatBan(), t.getNgayDatBan()));
				System.out.println(lstwl.size()+"abc");
			}
			System.out.println(lstwl.size()+"abc");
			request.setAttribute("danh_sach_doi", lstwl);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	//hiển thị danh sách bàn đặt có trạng thái là Confirmed
		private void showttbdbystatuscf(HttpServletRequest request, HttpServletResponse response) {
			List<ThongTinBanDat> lstt=this.daottbd.showttbdbycf();
			List<ThongTinBanDat> lstcf=new ArrayList<ThongTinBanDat>();
			SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
			for(ThongTinBanDat t:lstt) {
				String ngayd=format.format(t.getNgayDatBan());
				lstcf.add(new ThongTinBanDat(t.getIdBd(), ngayd, t.getGioDatBan(), t.getNgayDatBan()));
			}
			
			request.setAttribute("da_xac_nhan", lstcf);
			
		}
		
		//hiển thị danh sách bàn đặt có trạng thái là Cancelled
		private void showttbdbystatuscancel(HttpServletRequest request, HttpServletResponse response) {
			List<ThongTinBanDat> lstcancel=this.daottbd.showttbdbycancel();
			request.setAttribute("da_huy", lstcancel);
		}
		
		//kiểm tra số điện thoại của khách hàng đã tồn tại trong tài khoản nào hay chưa.
		//nếu có thì update thông tin khách hàng
		//nếu không thì tạo thông tin khách hàng 
		//tạo thông tin bàn đặt từ thông tin khách hàng vừa nhập
		private void createbd(HttpServletRequest request, HttpServletResponse response) throws IOException {
			String name=request.getParameter("ten_kh");
			String phone=request.getParameter("sdt");
			response.setContentType("text/html;charset=UTF-8");
			request.setCharacterEncoding("utf-8");
			int soluong=Integer.parseInt(request.getParameter("so_luong"));
			String ghi_chu=request.getParameter("note");
			KhachHang kh=this.daouser.showuserbyphone(phone);
			KhachHang user=new KhachHang();
			if(kh==null) {
				user.setHoTen(name);
				user.setSdt(phone);
				this.daouser.insert(user);
			}else {
				kh.setHoTen(name);
				this.daouser.update(user);
			}
			KhachHang khachhang=this.daouser.showuserbyphone(phone);
			ThongTinBanDat ttbd=new ThongTinBanDat();
			ttbd.setGhi_Chu(ghi_chu);
			ttbd.setKhachHang(khachhang);
			ttbd.setSo_Luong_Nguoi(soluong);
			ttbd.setTrang_Thai("Waitting line");
			long millis=System.currentTimeMillis();   
			java.sql.Date date=new java.sql.Date(millis);
			LocalTime localtime=LocalTime.now();
			Time time= Time.valueOf(localtime);
			ttbd.setGioDatBan(time);
			ttbd.setNgayDatBan(date);
			this.daottbd.insert(ttbd);
			ThongTinBanDat t=this.daottbd.findttbdbyuserdesc(khachhang);
			response.sendRedirect(request.getContextPath()+"/Confirmbooking?index="+t.getIdBd()+"&&status=1&&date="+showdatenow());
		}
		
		private String showdatenow() {
			Calendar c=Calendar.getInstance();
			SimpleDateFormat fommat=new SimpleDateFormat("dd/MM/yyyy");
			int day=c.get(Calendar.DATE);
			int month=c.get(Calendar.MONTH);
			int year=c.get(Calendar.YEAR);
			c.set(year, month, day);
			String date1=fommat.format(c.getTime());
			return date1;
		}
}