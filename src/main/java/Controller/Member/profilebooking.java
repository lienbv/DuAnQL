package Controller.Member;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.DaoCart;
import Dao.DaoTTBD;
import model.GioHang;
import model.KhachHang;
import model.ThongTinBanDat;

/**
 * Servlet implementation class profilebooking
 */
@WebServlet("/profilebooking")
public class profilebooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private DaoTTBD daottbd;
    private KhachHang kh;
    private ThongTinBanDat ttbd;
    private List<GioHang> lstgh;
    private DaoCart daocart;
    
    public profilebooking() {
    	this.daottbd=new DaoTTBD();
    	this.ttbd=new ThongTinBanDat();
    	this.kh=new KhachHang();
    	this.lstgh=new ArrayList<GioHang>();
    	this.daocart=new DaoCart();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		this.kh=(KhachHang) session.getAttribute("acountKH");
		this.ttbd=this.daottbd.findttbdbystatus(this.kh);
		this.lstgh=this.daocart.FindCartbyIDDB(this.ttbd);
		request.setAttribute("inforbooking", this.ttbd);
		request.setAttribute("carts", this.lstgh);
		request.getRequestDispatcher("/views/assets/SauDatBan.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}