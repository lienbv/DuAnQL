package Controller.Member;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoTTBD;
import Dao.Daouser;
import model.KhachHang;
import model.ThongTinBanDat;

/**
 * Servlet implementation class Bookinggest
 */
@WebServlet("/Bookinggest")
public class Bookinggest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private Daouser daouser;
       private KhachHang kh;
       private DaoTTBD daottbd;
       private ThongTinBanDat ttbd;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bookinggest() {
        this.daouser=new Daouser();
        this.kh=new KhachHang();
        this.daottbd=new DaoTTBD();
        this.ttbd=new ThongTinBanDat();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/views/assets/HeaderKhachHang.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sdt=request.getParameter("phone_number");
		this.kh=this.daouser.finduserbyphone(sdt);
		HttpSession session = request.getSession();
		showdatenow(request, response);
		String ngay=(String) session.getAttribute("date_book");
		if(kh==null) {
			KhachHang k=new KhachHang();
			k.setSdt(sdt);
			this.daouser.insert(k);
			KhachHang user=this.daouser.finduserbyphone(sdt);
			response.sendRedirect(request.getContextPath()+"/Bookinggests?idgest="+user.getIdkh()+"&&date="+ngay);
		}else {
			this.ttbd=this.daottbd.findttbdbystatus(kh);
			if(this.ttbd==null) {
				response.sendRedirect(request.getContextPath()+"/Bookinggests?idgest="+kh.getIdkh()+"&&date="+ngay);
			}else {
				response.sendRedirect(request.getContextPath()+"/Afterbooking?idgest="+kh.getIdkh()+"&&date="+ngay);
			}
			
		}
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
