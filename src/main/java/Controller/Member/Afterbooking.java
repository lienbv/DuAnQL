package Controller.Member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.DaoTTBD;
import Dao.Daouser;
import model.KhachHang;
import model.ThongTinBanDat;

/**
 * Servlet implementation class Afterbooking
 */
@WebServlet("/Afterbooking")
public class Afterbooking extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Daouser daouser;
    private KhachHang user;
    private ThongTinBanDat ttbd;
    private DaoTTBD daottdb;
    
    public Afterbooking() {
        this.daottdb=new DaoTTBD();
        this.daouser=new Daouser();
        this.user=new KhachHang();
        this.ttbd=new ThongTinBanDat();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("idgest"));
		this.user=this.daouser.findbyid(id);
		this.ttbd=this.daottdb.findttbdbystatus(user);
		request.setAttribute("booking", this.ttbd);
		request.getRequestDispatcher("/views/assets/AfterBookingGuest.jsp").forward(request, response);
	}

}
