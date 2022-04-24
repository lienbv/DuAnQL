package Controller.Member;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import Dao.DaoTTBD;
import Dao.Daouser;
import Services.UtilsDate;
import model.KhachHang;
import model.ThongTinBanDat;

/**
 * Servlet implementation class Bookinggests
 */
@WebServlet("/Bookinggests")
public class Bookinggests extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daouser daouser;
    private KhachHang user;
    private ThongTinBanDat ttbd;
    private DaoTTBD daottbd;
    private UtilsDate utilsDate;
    public Bookinggests() {
        this.daouser=new Daouser();
        this.user=new KhachHang();
        this.ttbd=new ThongTinBanDat();
        this.daottbd=new DaoTTBD();
        this.utilsDate=new UtilsDate();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idgest"));
		this.user=this.daouser.findbyid(id);
		String ngay=request.getParameter("date");
		this.utilsDate.ngaydat(request);
		this.utilsDate.giodat(request, ngay);
		request.setAttribute("user", this.user);
		request.setAttribute("ngay", ngay);
		request.getRequestDispatcher("/views/assets/BeforeBookingGuest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idgest"));
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String ngay=request.getParameter("date");
		insertbd(request, response, id);
		response.sendRedirect(request.getContextPath()+"/Afterbooking?idgest="+id+"&&date="+ngay+"sucssesBookingGuest=3");
	}
	private void insertbd(HttpServletRequest request, HttpServletResponse response,int index) {
		try {
			BeanUtils.populate(this.ttbd, request.getParameterMap());
			String ngaydat=request.getParameter("date");
			String giodat=request.getParameter("timedatban");
			String hoten=request.getParameter("name");
			SimpleDateFormat fommat=new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date ngay= fommat.parse(ngaydat);
			Date date=new Date(ngay.getTime());
			Time time=Time.valueOf(giodat);
			this.ttbd.setNgayDatBan(date);
			this.ttbd.setGioDatBan(time);
			this.user=this.daouser.findbyid(index);
			this.user.setHoTen(hoten);
			this.ttbd.setKhachHang(this.user);
			this.ttbd.setTrang_Thai("Waitting line");
			this.daottbd.insert(this.ttbd);
			this.daouser.update(user);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
